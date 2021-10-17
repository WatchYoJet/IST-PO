test: clean
	@echo "--------------------"
	@echo "STARTING TESTS"
	@echo "--------------------"
	@./tests/runtests.sh

clean:	
	@echo "--------------------"
	@echo "CLEANING"
	@echo "--------------------"
	@find . -type f -name '*.class' -delete
	@find . -type f -name '*.outhyp' -delete
	@find . -type f -name '*.diff' -delete
	@echo "I could lick the floor"

compile:
	@javac -cp po-uilib.jar:. `find ggc -name '*.java'`

execute:
	@java -cp po-uilib.jar:. ggc.app.App

run: compile execute
	@echo "------------"
	@echo "DONE"
	@echo "------------"
