import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
   int n;
   int nopensize;
   int size;
   boolean isopen[];
   WeightedQuickUnionUF qu;
  
   public Percolation(int n){
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
      for(int i=0;i<n+1;++i){ qu.union(0,i);}
      for (int i=size-n;i<size+1;++i){ qu.union(size+1,i);}
   }                // create n-by-n grid, with all sites blocked
   public    void open(int row, int col){
      int nn=(row-1)*this.n+col;
      if(isopen[nn+1]) qu.union(nn,nn+1);
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
         if(nn<n+1){
            if(isopen[nn+1]) qu.union(nn,nn+1);
            if(isopen[nn+this.n] )qu.union(nn,nn+this.n);
            if(isopen[nn-1])qu.union(nn,nn-1);
         }else if(nn>n*(n-1)){
            if(isopen[nn+1]) qu.union(nn,nn+1);
           if(isopen[nn-this.n]) qu.union(nn,nn-this.n);
            if(isopen[nn-1] )qu.union(nn,nn-1);
         }else{
            if(isopen[nn+1]) qu.union(nn,nn+1);
            if(isopen[nn+this.n]) qu.union(nn,nn+this.n);
            if(isopen[nn-1])qu.union(nn,nn-1);
            if(isopen[nn-this.n]) qu.union(nn,nn-this.n);
         }
     }
            
      nopensize++;
      //more
      
   }    // open site (row, col) if it is not open already
   public boolean isOpen(int row, int col){
      return isopen[(row-1)*n+col];
   }  // is site (row, col) open?
   public boolean isFull(int row, int col){return false;} // is site (row, col) full?
   public     int numberOfOpenSites(){return nopensize;}       // number of open sites
   public boolean percolates(){return qu.connected(0,size+1);}              // does the system percolate?
  
   public static void main(String[] args) {
     int sz=200;
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

   
