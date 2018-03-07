/**
 * easy sort selection sort,insertion sort and shell sort
 *
 * @author johnnylee
 */
public class Sort {

  private static Comparable[] aux;

  /**
   * selection sort
   */
  public static void selection(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
        exch(a, i, min);
      }
    }
  }

  /**
   * insertion sort
   */
  public static void insertion(Comparable[] a) {
    int N = a.length;
    Comparable temp;
    for (int i = 1; i < N; i++) {
      int j = i;
      temp=a[j];
      for (; j > 0 && less(a[j], a[j - 1]); j--) {
        //改进前
       // exch(a, j, j - 1);
        //改进后
        a[j]=a[j-1];
      }
      a[j]=temp;
    }
  }

  /**
   * shell sort
   */
  public static void shell(Comparable[] a) {
    int N = a.length;

    //求增量
    int H = 1;
    while (H < N / 3) {
      H = 3 * H + 1;
    }
    while (H >= 1) {
      for (int i = H; i < N; i++) {
        for (int j = i; j >= H && less(a[j], a[j - H]); j -= H) {
          exch(a, j, j - H);
        }
      }
      H = H / 3;
    }

  }

  /**
   * top down merge(recursive
   */
  public static void TopDownSort(Comparable[] a) {
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  /**
   * down top merge
   */
  public static void DownTopSort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int low = 0; low < N - sz; low += sz + sz) {
        merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
      }
    }
  }

  public static void sort(Comparable[] a, int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = (low + high) / 2;
    sort(a, low, mid);
    sort(a, mid + 1, high);
    merge(a, low, mid, high);
  }

  public static void merge(Comparable[] a, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;
    for (int k = low; k <= high; k++) {
      aux[k] = a[k];
    }
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > high) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }

  /**
   * quick sort(elemental version
   */
  public static void quick(Comparable[] a) {
    StdRandom.shuffle(a);
    quick(a, 0, a.length - 1);
  }

  private static void quick(Comparable[] a, int low, int high) {
    if (high <= low) {
      return;
    }
    int j = partition(a, low, high);
    quick(a, low, j - 1);
    quick(a, j + 1, high);
  }

  private static int partition(Comparable[] a, int low, int high) {
    int i = low;
    int j = high + 1;
    Comparable v = a[low];
    while (true) {
      while (less(a[++i], v)) {
        if (i == high) {
          break;
        }
      }
      while (less(v, a[--j])) {
        if (j == low) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      exch(a, i, j);
    }
    exch(a, low, j);
    return j;
  }

  /**
   * heap sort
   * @param a
   */
  public static void heap(Comparable[] a) {
    int N = a.length;
    for (int k = N / 2; k >= 1; k--) {
      sink(a, k, N);
    }
    while (N > 1) {
      exch(a, 1, N--);
      sink(a, 1, N);
    }
  }

  private static void sink(Comparable[] a, int k, int N) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      exch(a, k, j);
      k = j;
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = In.readStrings();
    selection(a);
    assert isSorted(a);
    show(a);
  }

}
