import edu.princeton.cs.algs4.StdStats;
import Percolation;
import java.lang.Math;

public class PercolationStats {
   double m;
   double s;
   double cl;
   double ch;
   int numberOfOpens[];
   public PercolationStats(int n, int trials){
      numberOfOpens=new int[trials];
      for (int i=0;i<trials;++i){
           Percolation per=new Percolation(n);
           while(!per.percolates()){
           per.open(StdRandom.uniform(1,per.n+1),StdRandom.uniform(1,per.n+1));}
           nuberOfOpens[i]=per.numberOfOpenSites();
      }
      m=StdStats.mean(numberOfOpens);
      s=Stdstats.stddev(numberOfOpens);
      cl=m-1.96*s/Math.sqrt(trials);
      ch=m+1.96*s/Math.sqrt(trials);
   }
            
// perform trials independent experiments on an n-by-n grid
      public double mean(){return m;}// sample mean of percolation threshold
      public double stddev(){return s;}                        // sample standard deviation of percolation threshold
      public double confidenceLo(){ return cl;}               // low  endpoint of 95% confidence interval
      public double confidenceHi(){return ch;}             // high endpoint of 95% confidence interval

      public static void main(String[] args)  {
         PercolationStats ps=new PercolationStats(args[1].toInt
         System.out.printf("10f \n",

// test client (described below)
}