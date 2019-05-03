
typedef struct stack {
  int top;
  int ints[100];
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