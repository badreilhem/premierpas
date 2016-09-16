.PHONY : clean fclean test all

all :	bin
	cd src ; javac actionsandpool/*/*.java -d ../bin
#	cd src ; javadoc -d ../docs -subpackages actionsandpool
	cd bin ; jar cvfm ../actionsandpool.jar ../manifest actionsandpool -C .. docs -C .. src -C .. README.md

bin :
	mkdir bin

actionsandpool:
	java -jar actionsandpool.jar

clean :
	rm -f *~
	cd src/actionsandpool/* ; rm -f -r *.java~
	cd tests/actionsandpool/* ; rm -f -r *.java~


fclean : clean
	rm -f -r actionsandpool.jar
