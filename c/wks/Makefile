exef: main.c libs/utils.o
	gcc   -o exef -std=c99  main.c libs/utils.o

libs/utils.o: libs/utils.c
	gcc -o libs/utils.o -c libs/utils.c

test: test.c libs/utils.o
	gcc -o test test.c libs/utils.o
