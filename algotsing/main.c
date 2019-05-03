#include <stdio.h> 

#define SIZE 500

typedef struct stack {
  int top;
  int ints[SIZE];
} istack;
int pop(istack *s){
  if(s->top>0){
    --(s->top);
    return s->ints[s->top+1];
  }else{
    return -1;
  }
}
int push(istack *s,int n){
  ++(s->top);
  s->ints[s->top]=n;
  return n;
}

int main(){
    int n;
    int histogram[SIZE];
    istack is;
    int maxArea=0;
    is.top=0;
    is.ints[0]=0;
    histogram[0]=0;
    histogram[n+1]=0;
    scanf("%d",&n);
    for (int i = 1; i < n+1; i++) {
        scanf("%d",&histogram[i]);
    }
    for(int i=1;i<n+2;){
        if(histogram[is.ints[is.top]]<=histogram[i]){
            push(&is,i);
            ++i;
        }else{
            int hight=histogram[pop(&is)];
            int currentArea=hight*(i-is.ints[is.top]-1);
            if(maxArea<currentArea){ maxArea=currentArea;}
        }
    }
    int lastarea=histogram[pop(&is)]*(n-is.ints[is.top]);
    if(maxArea<lastarea) {maxArea=lastarea;}
    printf("%d \n",maxArea);
    return 0;
}
