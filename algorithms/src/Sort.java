/**
 * easy sort
 * selection sort,insertion sort and shell sort
 *
 * @author johnnylee
 */
public class Sort {
    /**
     * selection sort
     *
     * @param a
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
     *
     * @param a
     */
    public static void insertion(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * shell sort
     *
     * @param a
     */
    public static void shell(Comparable[] a) {
        int N = a.length;
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
