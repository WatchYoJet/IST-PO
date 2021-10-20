test: clean
	@echo "--------------------"
	@echo "STARTING TESTS"
	@echo "--------------------"
	@./tests/runtests.sh

clean:
	@echo "--------------------"
	@echo "CLEANING"
	@echo "--------------------"
	@find . -type f -name '*.class'  -delete
	@find . -type f -name '*.outhyp' -delete
	@find . -type f -name '*.diff'   -delete

compile: clean
	@echo "--Compiling--"
	@javac -cp po-uilib.jar:. `find ggc -name '*.java'`
	@echo "--DONE--"

execute:
	@echo "--Executing--"
	@java -cp po-uilib.jar:. ggc.app.App
	@echo "--DONE--"

run: compile execute
