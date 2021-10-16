test:
	@echo "--------------------"
	@echo "CLEANING"
	@echo "--------------------"
	@make clean
	@echo "--------------------"
	@echo "STARTING TESTS"
	@echo "--------------------"
	@./tests/runtests.sh

clean:
	@find . -type f -name '*.class' -delete
	@find . -type f -name '*.outhyp' -delete
	@find . -type f -name '*.diff' -delete
	@echo "I could lick the floor"

compile:
	@javac -cp po-uilib.jar:. `find ggc -name '*.java'`

execute:
	@java -cp po-uilib.jar:. ggc.app.App

run:
	@make compile
	@make execute