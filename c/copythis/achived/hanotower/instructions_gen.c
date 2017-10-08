#include <stdio.h>

#define S 15
int main(){
    mvdisk(0,2,1,S);
    return 0;
}

int mvdisk(int fr,int to,int spare,int n){
    if(n<=1){
	printf("%d%d\n",fr,to);
	return 0;
    }
    mvdisk(fr,spare,to,n-1);
    printf("%d%d\n",fr,to);
    mvdisk(spare,to,fr,n-1);
    return 0;
}
