run: compile execute
	@make -s clean

test: compile
	@make -s cleantest
	@echo "--------------------"
	@echo "STARTING TESTS"
	@echo "--------------------"
	@./runtests.sh
	@make -s clean
clean:
	@echo "--CLEANING--"
	@find . -type f -name '*.class'  -delete
	@find . -type f -name '*.dat'  -delete

cleantest:
	@find . -type f -name '*.diff'  -delete
	@find . -type f -name '*.outhyp'  -delete

compile: clean
	@echo "--COMPILING--"
	
	@javac -cp po-uilib.jar:. `find ggc -name '*.java'`
	@echo "--DONE--"

execute:
	@echo "--EXECUTING--"
	@java -cp po-uilib.jar:. ggc.app.App
	@echo "--DONE--"

