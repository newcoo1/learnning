#include <stdio.h>


typedef struct stack {
  int *ptop;
  int ints[1003];
} istack;
int pop(istack *s){
  if(s->ptop>s->ints){
    --(s->ptop);
    return s->ints[*(s->ptop+1)];
  }else{
    return -1;
  }
}
int push(istack *s,int n){
  ++(s->ptop);
  *(s->ptop)=n;
  return n;
}
int main(){
  int n;
  scanf("%d",&n);
  //int ints[10]={3,1,5,7,20,0};
  istack sstack;
  istack rstack;
  sstack.ptop=sstack.ints;
  rstack.ptop=rstack.ints;
  for (int i=0;i<n;++i) {
    int input;
    scanf("%d",&input);
    push(&rstack,input);
    //printf("%d ",rstack.ints[i]);
  }
  while(rstack.ptop>rstack.ints){
    int temp=pop(&rstack);
    if(*(sstack.ptop)<=temp){
      push(&sstack,temp);
    }else{
      push(&rstack,pop(&sstack));
      push(&rstack,temp);
    }
  }
  for(int i=0;i<n;++i){
    printf("%d\n",sstack.ints[i+1]);
  }
  return 0;
}
