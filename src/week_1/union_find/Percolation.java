package week_1.union_find;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

 private final int virtualTop;
 private final int virtualBottom;
 private final int n;
 private final WeightedQuickUnionUF connectedSitesUF;
 private final WeightedQuickUnionUF filledSitesUF; // Solution to backwash problem
 private boolean[][] isOpen;
 private int numberOfOpenSites;

 // creates n-by-n grid, with all sites initially blocked
 public Percolation(int n) {

  final int grids;

  // Corner cases
  if (n <= 0)
   throw new IllegalArgumentException("N must be greater than 0.");
  this.n = n;

  grids = n * n;
  isOpen = new boolean[n + 1][n + 1];

  connectedSitesUF = new WeightedQuickUnionUF(grids + 2); // including the virtual Top and Bottom (grids + 1 + 1)
  filledSitesUF = new WeightedQuickUnionUF(grids + 1); // including the virtual Top only so (grids + 1)
  virtualTop = grids;
  virtualBottom = grids + 1;

  // Connecting the top sites to virtual Top and Bottom sites to virtual Bottom
  for (int i = 0; i < n; i++) {
   connectedSitesUF.union(virtualTop, i);
   connectedSitesUF.union(virtualBottom, (n - 1) * n + i);

   // Connecting filled sites to virtual Top, but not to the virtual Bottom to
   // address the backwash problem
   filledSitesUF.union(virtualTop, i);
  }
 }

 public void open(int row, int col) {

  validateIndices(row, col);

  int reqRow = row - 1;
  int reqCol = col - 1;

  if (!isOpen[row][col]) {
   isOpen[row][col] = true;
   numberOfOpenSites++;
  }

  // connect the possible neighbor sites for a single grid cell

  if (row - 1 > 0 && isOpen[row - 1][col]) {
   connectedSitesUF.union(reqRow * n + reqCol, (reqRow - 1) * n + reqCol);
   filledSitesUF.union(reqRow * n + reqCol, (reqRow - 1) * n + reqCol);
  }

  if (row + 1 <= n && isOpen[row + 1][col]) {
   connectedSitesUF.union(reqRow * n + reqCol, (reqRow + 1) * n + reqCol);
   filledSitesUF.union(reqRow * n + reqCol, (reqRow + 1) * n + reqCol);
  }

  if (col - 1 > 0 && isOpen[row][col - 1]) {
   connectedSitesUF.union(reqRow * n + reqCol, reqRow * n + (reqCol - 1));
   filledSitesUF.union(reqRow * n + reqCol, reqRow * n + (reqCol - 1));
  }

  if (col + 1 <= n && isOpen[row][col + 1]) {
   connectedSitesUF.union(reqRow * n + reqCol, reqRow * n + (reqCol + 1));
   filledSitesUF.union(reqRow * n + reqCol, reqRow * n + (reqCol + 1));
  }

 }

 // opens a new site if the correct cases are met
 public boolean isOpen(int row, int col) {

  validateIndices(row, col);
  return isOpen[row][col];
 }

 // is the site (row, col) full?
 public boolean isFull(int row, int col) {

  int reqRow = row - 1;
  int reqCol = col - 1;

  validateIndices(row, col);
  return isOpen[row][col] && filledSitesUF.find(reqRow * n + reqCol) == filledSitesUF.find(virtualTop);
 }

 // returns the number of open sites
 public int numberOfOpenSites() {
  return numberOfOpenSites;
 }

 // does the system percolate?
 public boolean percolates() {

  if (n == 1)
   return isOpen(1, 1);
  return connectedSitesUF.find(virtualTop) == connectedSitesUF.find(virtualBottom);
 }

 // Helper method to check for rows and columns
 private void validateIndices(int row, int col) {
  if (row <= 0 || row > n)
   throw new IndexOutOfBoundsException("Row index out of bounds");
  if (col <= 0 || col > n)
   throw new IndexOutOfBoundsException("Row index out of bounds");
 }

//    test client (optional)
//    public static void main(String[] args) {
//    }
}
