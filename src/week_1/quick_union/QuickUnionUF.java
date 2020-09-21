package week_1.quick_union;

public class QuickUnionUF {
	
	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		// Set id of each object to itself
		// N array access
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	// Chase parent pointers until reach root
	// depth of i array access
	private int root(int i) {
		while (i != id[i]) i = id[i];
		return i;
	}
	
	// check if p and q have the same root
	// depth of p and q array accesses
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	// change root of p to point to root of q
	// depth of p and q array accesses
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
		
	}
	
	
}
