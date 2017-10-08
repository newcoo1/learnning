#include <stdio.h>
#include "includes/utils.h"
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

#define TH 15
#define clears printf("\033[2J\033[1;1H")
typedef struct Tower{
    int disks[TH+1];
    int top;
} Tower;
int draw(Tower *,Tower *,Tower *);
int mv(Tower *fr,Tower *to);

int main(){
    Tower t0;
    Tower t1;
    Tower t2;
    for(int i=1;i<TH+1;++i){
	t0.disks[i]=TH-i+1;
	t1.disks[i]=0;
	t2.disks[i]=0;
    }
    t0.disks[0]=TH+1;
    t1.disks[0]=TH+1;
    t2.disks[0]=TH+1;
    t0.top=TH;
    t1.top=0;
    t2.top=0;
    char ins0;    
    char ins1;
    Tower *towers[]={&t0,&t1,&t2};
    clears;
    draw(&t0,&t1,&t2);
    int count=0;
    while(1){
	count+=1;
	if(t2.top==TH){
	    break;
	}
	printf("pls input instuction: ");
	ins0=getchar()-'0';
	ins1=getchar()-'0';
	clears;
	getchar();//skip newline
	printf("move from %d to %d \n",ins0,ins1);
	mv(towers[ins0],towers[ins1]);
	printf("top : %d %d %d\n",t0.top,t1.top,t2.top);
	draw(&t0,&t1,&t2);
	//usleep(1000);
    }
    printf("%d loops!!!!\n",count);
    return 0;
 
}
int draw(Tower *t0p,Tower *t1p,Tower *t2p){
    printf("______________________________________\n");
    for(int i=TH;i>0;--i){
	for (int j=0;j<t0p->disks[i];j++){
	    printf("*");
	}
	for(int j=0;j<TH-t0p->disks[i];j++){
	    printf(" ");
	}
	printf("|");
	for (int j=0;j<t1p->disks[i];j++){
	    printf("*");
	}
	for(int j=0;j<TH-t1p->disks[i];j++){
	    printf(" ");
	}
	printf("|");
	for (int j=0;j<t2p->disks[i];j++){
	    printf("*");
	}
	for(int j=0;j<TH-t2p->disks[i];j++){
	    printf(" ");
	}

	printf("\n");
    }
    printf("__________________________________________\n");
    return 0;
}
int tmp=2;
int pop(Tower *tp);
int push(Tower *tp);
int mv(Tower *fr,Tower *to){
    if( pop(fr) ){
	printf("cant mv disks,erro in pop,input ins again\n");
	return 1; 
    }
    if(push(to)){
	printf("cant mv disks,erro in push,input ins again\n");
	push(fr);
    }
	
    return 0;
}
int pop(Tower *tp){
    if((tp->top)>0){
    tmp=tp->disks[(tp->top)];
    (tp->disks[tp->top] )=0;
    --(tp->top);
    return 0;
    }else{
	printf("cant pop\n");
	return 1;
    }
}
int push(Tower *tp){
    if(tmp<tp->disks[(tp->top)]){
	++(tp->top);
	tp->disks[(tp->top)]=tmp;
	return 0;
    }else {
    printf("cant push\n");
    return 1;
    }
}
