package week_1.quick_find;

public class QuickFindUF {

	private int[] id;

	public QuickFindUF(int N) {
		id = new int[N];
		// set id of each object to itself 
		// (N array accesses)
		for (int i = 0; i < N; i++) {
			id[i] = i; 
		}
	}

	// check whether p and q are in the same component
	// (2 array accesses)
	public Boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
			int p_id = id[p];
			int q_id = id[q]; 
			// Change all the entries with id[p] to id[q]
			// (2N + 2 array accesses at most)
			for(int i = 0; i < id.length; i++) {
				if(id[i] == p_id) id[i] = q_id;
			}
					
		}
}
