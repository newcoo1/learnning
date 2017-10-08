#include <stdio.h>
#include "includes/utils.h"
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
int ds(int n);

int main(){
    ds(40);
    return 0;
}

int ds(int n){
    int ds1(int n,int m);
    ds1(n,9);
    return 0;
}

int ds1(int n,int m){
    if(n<=1){
	for (int i=0;i<m;++i){
	    printf(" ");
	}
	printf("*\n");
	return 0;
    }
    for(int i=0;i<m;++i){
	printf(" ");
    }
    for(int i=0;i<2*n-1;++i){
	printf("*");
    }
    printf("\n");
    ds1(n-1,m+1);
    for(int i=0;i<m;++i){
	printf(" ");
    }
    for(int i=0;i<2*n-1;++i){
	printf("*");
    }
    printf("\n");
    return 0;
}
