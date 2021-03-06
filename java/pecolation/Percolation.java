import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
   private int n;
   private int nopensize;
   private int size;
   private boolean isopen[];
   private WeightedQuickUnionUF qu;
   private void argErr(){ throw new java.lang.IllegalArgumentException();}
  
   public Percolation(int n){
      if(n<=0) argErr();
      this.n=n;
      size=n*n;
      nopensize=0;
      isopen=new boolean[size+2];
      isopen[0]=true;
      isopen[size+1]=true;
      for(int i=1;i<size+1;++i){
         isopen[i]=false;
      }
      qu=new WeightedQuickUnionUF(size+2);
      for(int i=1;i<n+1;++i){ qu.union(0,i);}
   }                // create n-by-n grid, with all sites blocked
   public    void open(int row, int col){
      if( (row)<=0 || (col<=0) || (row >n)||(col>n)) argErr();
      int nn=(row-1)*this.n+col;
      if(isopen[nn]==true) return ;
      isopen[nn]=true;
      if(nn%n==1){
         if(isopen[nn+1]) qu.union(nn,nn+1);
         if (nn<(this.n+1) ){
            if(isopen[nn+this.n]) qu.union(nn,nn+this.n);
         }else if(nn>n*(n-1)){
            if (isopen[nn-n]) qu.union(nn,nn-n);
         }else{
            if(isopen[nn+this.n]) qu.union(nn,nn+this.n);
            if(isopen[nn-this.n]) qu.union(nn,nn-this.n);
         }
      }else if(nn%this.n==0){
         if(isopen[nn-1] ) qu.union(nn,nn-1);
         if(nn<(this.n+1) ){
            if(isopen[nn+this.n]) qu.union(nn,nn+this.n);
         }else if(nn>n*(n-1)){
            if(isopen[nn-this.n] )qu.union(nn,nn-this.n);
          }else{
               if(isopen[nn+this.n]) qu.union(nn,nn+this.n);
               if(isopen[nn-this.n]) qu.union(nn,nn-this.n);
            }
      }else{
         if(isopen[nn+1]) qu.union(nn,nn+1);
         if(isopen[nn-1])qu.union(nn,nn-1);
         if(nn<n+1){
            
            if(isopen[nn+this.n] )qu.union(nn,nn+this.n);
         }else if(nn>n*(n-1)){
         
            if(isopen[nn-this.n]) qu.union(nn,nn-this.n);
         
         }else{
         
            if(isopen[nn+this.n]) qu.union(nn,nn+this.n);
            if(isopen[nn-this.n]) qu.union(nn,nn-this.n);
         }
     }
            
      nopensize++;
      //more
      
   }    // open site (row, col) if it is not open already
   public boolean isOpen(int row, int col){
      if( (row)<=0 || (col<=0) || (row >n)||(col>n)) argErr();
      return isopen[(row-1)*n+col];
   }  // is site (row, col) open?
   public boolean isFull(int row, int col){
      if( (row)<=0 || (col<=0) || (row >n)||(col>n)) argErr();
      return this.isOpen(row,col)&&qu.connected(0,(row-1)*n+col);} // is site (row, col) full?
   public     int numberOfOpenSites(){return nopensize;}       // number of open sites
   public boolean percolates(){
      for(int i=1;i<n+1;++i){
         if (isFull(n,i)) return true;
      }
      return false;
   }              // does the system percolate?
  
   public static void main(String[] args) {
     int sz=100;
     int t=100;
     double sum=0;
     Percolation per10=new Percolation(sz);
     while(!per10.percolates()){
        per10.open(StdRandom.uniform(1,per10.n+1),StdRandom.uniform(1,per10.n+1));
     }
    
     StdRandom.uniform(1,per10.n+1);
    
     System.out.println(per10.numberOfOpenSites());
    
     for(int i=0;i<t;++i){
        while(!per10.percolates()){
        per10.open(StdRandom.uniform(1,per10.n+1),StdRandom.uniform(1,per10.n+1));}
        sum+=(double)per10.numberOfOpenSites()/per10.size;
     }
     System.out.println(sum/t);
        
   }
}
  
  /* ADD YOUR CODE HERE */

   
