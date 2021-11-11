#!/bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'
tests=1
done=0


echo -e "\n\n----------------------------------"
echo "Starting"
echo "----------------------------------"

passed=0
total=0

make compile

exe_test() { #Inspired by: Abread
    input=$1
    x=$(basename $input | cut -f 1 -d'.')


    if [ -e tests/$x.import ]; then
        java -cp :po-uilib.jar:. -Dfile.encoding=UTF8 -Dimport=tests/$x.import -Din=tests/$x.in -Dout=tests/$x.outhyp ggc.app.App;
    else
        java -cp po-uilib.jar:. -Dfile.encoding=UTF8 -Din=tests/$x.in -Dout=tests/$x.outhyp ggc.app.App;
    fi

    diff -cB -w tests/${x%.in}.out tests/${x%.in}.outhyp > tests/${x%.in}.diff;
    if [ -s tests/${x%.in}.diff ]; then
        echo -e "${tests}- ${RED}FAIL${NC}: $x \n" ;
    else
        echo -e "${tests}- ${GREEN}SUCCESS${NC} \n"
	    rm -f tests/${x%.in}.diff tests/${x%.in}.outhyp ; 
    fi
    exit 0
}

export -f exe_test

nice parallel --progress --eta --bar $@ exe_test ::: tests/*.in
# "--jobs 200%" will put the script "running 2 jobs per CPU core"


passed=$(find ./tests -iname '*.diff' -type f | wc -l)
total=$(find ./tests -iname '*.in' -type f | wc -l)


echo -e "\n\n----------------------------------"

if [ $passed -eq $total ]; then
    printf '%b' "${green}Go get your 20$reset\n"
else 
    printf '%b' "Score: ${red}${passed}${reset}/${total}\n"
fi

echo "----------------------------------"