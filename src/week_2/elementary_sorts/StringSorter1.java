package week_2.elementary_sorts;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringSorter1 {
 public static void main(String[] args) throws Exception {
  String[] a = StdIn.readAllStrings();
  Insertion.sort(a);
  for (int i = 0; i < a.length; i++) {
   StdOut.println(a[i]);
  }
 }
}
