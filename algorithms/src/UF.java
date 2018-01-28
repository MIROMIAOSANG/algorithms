/**
 * 
 * @author johnnylee
 * @param []id is the union
 * @param []sz is to express the size of the tree
 * @param count is to count the union components
 */
public class UF {
	private int[] id;
	private int count;
	private int[] sz;

	/**
	 * initilize array
	 * 
	 */
	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}

	public int count() {
		return count;
	}

	// QuickFind
	public int findQF(int p) {
		return id[p];
	}

	public boolean connectedQF(int p, int q) {
		return id[p] == id[q];
	}

	public void unionQF(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		if (pid == qid) {
			return;
		}

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
		count--;
	}

	// QuickUnion
	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public boolean connectedQU(int p, int q) {
		return root(p) == root(q);
	}

	public void unionQU(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j) {
			return;
		}
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		// id[i] = j;
		count--;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connectedQU(p, q)) {
				continue;
			}
			uf.unionQU(p, q);
			StdOut.println(p + " " + q);
			StdOut.println(uf.count() + "components");

		}
	}

}
