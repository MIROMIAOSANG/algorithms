/**
 * primary queue(Max Heap
 * @param <Key>
 */
public class MaxPrimaryQueue<Key extends Comparable<Key>> {

  /**
   * 基于堆的完全二叉树
   */
  private Key[] pq;

  private int N = 0;

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    Key t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  /**
   * down top swim
   * @param k
   */
  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k / 2, k);
      k = k / 2;
    }
  }

  /**
   * top down sink
   * @param k
   */
  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      exch(k, j);
      k = j;
    }
  }

  public MaxPrimaryQueue(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  /**
   * insert to behind and swim
   * @param v
   */
  public void insert(Key v) {
    pq[++N] = v;
    swim(N);
  }

  /**
   * use the behind one replace root and sink
   * @return
   */
  public Key delMax() {
    Key max = pq[1];
    exch(1, N--);
    pq[N + 1] = null;
    sink(1);
    return max;
  }
}
