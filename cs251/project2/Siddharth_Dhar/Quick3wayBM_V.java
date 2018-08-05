import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdIn;


public class Quick3wayBM_V {
    static int median = 0;
    static int tukey = 0;

    private static final int INSERTION = 8;

    private static final int MEDIAN3 = 40;

    private Quick3wayBM_V() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;

        if (n <= INSERTION) {
            insertionSort(a, lo, hi);
            if (lo > hi) {
                return;
            } else {
                show(a);
                return;
            }
        }
        // use median-of-3 as partitioning element
        else if (n <= MEDIAN3) {
            int check = (n - 1) / 2;
            int m = median3(a, lo, lo + check, lo + (2 * check));
            median = 1;
            exch(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else {
            int eps = (n - 1) / 8;
            int mid = lo + (n - 1) / 2;
            int m1 = median3(a, lo, lo + eps, lo + eps * 2);
            int m2 = median3(a, lo + eps * 3, lo + eps * 4, lo + eps * 5);
            int m3 = median3(a, lo + eps * 6, lo + eps * 7, lo + eps * 8);
            int ninther = median3(a, m1, m2, m3);
            tukey = 1;
            exch(a, ninther, lo);
        }


        int i = lo, j = hi + 1;
        int p = lo, q = hi + 1;
        Comparable v = a[lo];
        while (true)
        {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && eq(a[j], v))
                exch(a, --q, j);
            if (i > j) {
                break;
            }
            if (i == j) {
                j--;
                break;
            }
            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++)
            exch(a, k, j--);
        for (int k = hi; k >= q; k--)
            exch(a, k, i++);
        show(a);
        sort(a, lo, j);
        sort(a, i, hi);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    // return the index of the median element among a[i], a[j], and a[k]
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ? (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    // does v == w ?
    private static boolean eq(Comparable v, Comparable w) {
        return v.compareTo(w) == 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
    }

    public static void main(String[] args) {
        Quick3wayBM_V q = new Quick3wayBM_V();

        int index = 0;
        int arrayLength = StdIn.readInt();
        Comparable[] a = new Comparable[arrayLength];
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            a[index] = x;
            index++;
        }
        show(a);
        q.sort(a);
        show(a);
    }

}