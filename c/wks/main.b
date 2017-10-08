#include <stdio.h>
#include "includes/utils.h"
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

int sysinfo(void);
int main(void){
  sysinfo();
  return 0;
}

int sysinfo(void){
  int si=sizeof(int);
  int sf=sizeof(float);
  int sd=sizeof(double);
  int sc=sizeof(char);
  int sl=sizeof(long);
  int ss=sizeof(short);
  printf("size:\nint:%d  short:%d  long:%d char%d
	       float:%d  double:%d",
	       si,     ss,	 sl	 sc,
	       sf,     sd);
  return 0;
}
