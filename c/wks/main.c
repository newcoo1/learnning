#include <stdio.h>
#include "includes/utils.h"
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

int n=1;
int f1(){
  return ++n;
}
int f2(){
  return n*n;
}
int main(void){
  printf("%d %d",f2(),f1() );
  return 0;
}


