package week_2.elementary_sorts;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortRandomRealNumbers1 {
 public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(args[0]);
    Double[] a = new Double[N];
    
    for (int i = 0; i < N; i++)
     a[i] = StdRandom.uniform();
    
    Insertion.sort(a);
    
    for (int i = 0; i < N; i++)
     StdOut.println(a[i]);
 }
}