#include <stdio.h>
#include "includes/utils.h"
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <ctype.h>

int binsearch(int x,int v[],int len){
  int low=0;
  int high=len-1;
  int mid=(low+high)/2;
  while( (low <=high)&&(v[mid]!=x) ){
    printf("%d %d \n",low,high);
    (x<v[mid])&&(high=mid-1);
    (x>v[mid])&&(low=mid+1);
    mid=(low+high)/2;
  }
  //(x==v[mid]) && (return mid);
  return (x==v[mid]) ? mid:-1;
}
int main(void){
  int numbers[]={0,1,2,3,4,5};
  printf("%d \n",binsearch(-1,numbers,6) );//sizeof(numbers)/sizeof(int )));  
  return 0;
}
