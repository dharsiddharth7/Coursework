import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.*;


public class Quick3wayBM {
    private static int median = 0;
    private static int tukeyNinther = 0;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;

        if (n <= 8) {
            insertionSort(a, lo, hi);
            if (lo > hi) {
                return;
            } else {
                System.out.println("Insertion Sort: " + lo + ", " + hi);
                return;
            }
        }

        else if (n <= 40) {
            int check = (n - 1) / 2;
            int m = median3(a, lo, lo + check, lo + (2 * check));
            median = 1;
            swap(a, m, lo);
        }

        else {
            int eps = (int)Math.floor((n - 1) / 8);
            int mid = (int)Math.floor(lo + (n - 1) / 2);
            int m1 = median3(a, lo, lo + eps, lo + eps * 2);
            int m2 = median3(a, lo + eps * 3, lo + eps * 4, lo + eps * 5);
            int m3 = median3(a, lo + eps * 6, lo + eps * 7, lo + eps * 8);
            int ninther = median3(a, m1, m2, m3);
            tukeyNinther = 1;
            swap(a, ninther, lo);
        }

        int i = lo, j = hi + 1;
        int p = lo, q = hi + 1;
        Comparable v = a[lo];
        while (true)
        {
            while (a[++i].compareTo(v) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (v.compareTo(a[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }

            if (i == j && a[j].compareTo(v) == 0) {
                swap(a, --q, j);
            }

            if (i > j) {
                break;
            }
            if (i == j) {
                j--;
                break;
            }

            swap(a, i, j);

            if (a[i].compareTo(v)==0) {
                swap(a, ++p, i);
            }
            if (a[j].compareTo(v) == 0) {
                swap(a, --q, j);
            }
        }
        if (median == 1) {
            System.out.println("Median of 3: " + lo + ", " + v + ", " + p + ", " + i + ", " + j + ", " + q + ", " + hi);
            median = 0;
        } else if (tukeyNinther == 1) {
            System.out.println("Tukey Ninther: " + lo + ", " + v + ", " + p + ", " + i + ", " + j + ", " + q + ", " + hi);
            tukeyNinther = 0;
        }

        i = j + 1;
        for (int k = lo; k <= p; k++)
            swap(a, k, j--);
        for (int k = hi; k >= q; k--)
            swap(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }

    private static void insertionSort(Comparable[] array, int lo, int hi) {
        Insertion.sort(array,lo,hi);
    }

    private static int median3(Comparable[] a, int i, int j, int k) {
        return (compareLess(a[i], a[j]) ? (compareLess(a[j], a[k]) ? j : compareLess(a[i], a[k]) ? k : i) :
                (compareLess(a[k], a[j]) ? j : compareLess(a[k], a[i]) ? k : i));
    }

    private static void printArray(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
    }

    private static boolean compareLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Quick3wayBM q = new Quick3wayBM();

        int index = 0;
        int arrayLength = StdIn.readInt();
        Comparable[] a = new Comparable[arrayLength];
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            a[index] = x;
            index++;
        }
        q.sort(a);
        printArray(a);
    }

}
