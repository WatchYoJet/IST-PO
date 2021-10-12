clean:
	@rm -f *class
	@rm -f src/*class
	@echo "So clean I could lick the floor"

test:
	@./tests/runtests.sh