.PHONY: all clean git setup restore classpath

JSON_REMOTE=https://github.com/douglascrockford/JSON-java
JSON_LOCAL=./src/org/json

setup: git classpath
	@echo "> Done!"

clean:
	rm -rf src/rentalcar/data/*.class 
	rm -rf src/rentalcar/ui/*.class 
	rm -rf src/rentalcar/web/*class
	rm -rf test/*.class
	rm -rf *.class

restore: clean
	git rm -rf $(JSON_LOCAL)

git:
	-git submodule add $(JSON_REMOTE) $(JSON_LOCAL)
	git submodule init
	git submodule update
