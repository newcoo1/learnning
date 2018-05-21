import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import java.lang.Math;
import java.lang.Integer;
import java.lang.IllegalArgumentException;

public class PercolationStats {
   private double m;
   private double s;
   private double cl;
   private double ch;
   private double edges[];
   public PercolationStats(int n, int trials){
      edges=new double[trials];
      for (int i=0;i<trials;++i){
           Percolation per=new Percolation(n);
           while(!per.percolates()){ per.open(StdRandom.uniform(1,n+1),StdRandom.uniform(1,n+1));}
           edges[i]=(double)per.numberOfOpenSites()/(n*n);
      }
      m=StdStats.mean(edges) ;
      s=StdStats.stddev(edges);
      cl=m-1.96*s/Math.sqrt(trials);
      ch=m+1.96*s/Math.sqrt(trials);
   }
            
// perform trials independent experiments on an n-by-n grid
      public double mean(){return m;}// sample mean of percolation threshold
      public double stddev(){return s;}                        // sample standard deviation of percolation threshold
      public double confidenceLo(){ return cl;}               // low  endpoint of 95% confidence interval
      public double confidenceHi(){return ch;}             // high endpoint of 95% confidence interval

      public static void main(String args[])  {
          
          int s=(Integer.valueOf(args[0]) ).intValue();
          int t =(Integer.valueOf(args[1]) ).intValue();
          if( (s<0) || (t<0) ) throw(new IllegalArgumentException());
          System.out.print(s+"   ");
          System.out.println(t);
         PercolationStats ps=new PercolationStats(s,t);
         System.out.printf("mean=                  %10f \n",ps.mean());
         System.out.printf("stdev=                   %10f\n",ps.stddev());
      }
// test client (described below)
}
      