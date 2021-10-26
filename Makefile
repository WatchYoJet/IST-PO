run: compile execute
	@make -s clean

test: compile
	@echo "--------------------"
	@echo "STARTING TESTS"
	@echo "--------------------"
	@./runtests.sh
	@make -s clean
clean:
	@echo "--CLEANING--"
	@find . -type f -name '*.class'  -delete

compile: clean
	@echo "--COMPILING--"
	@javac -cp po-uilib.jar:. `find ggc -name '*.java'`
	@echo "--DONE--"

execute:
	@echo "--EXECUTING--"
	@java -cp po-uilib.jar:. ggc.app.App
	@echo "--DONE--"

