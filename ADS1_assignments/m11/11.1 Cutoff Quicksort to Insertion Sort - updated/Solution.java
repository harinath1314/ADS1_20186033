/**
 * Solution for Quick sort Technique.
 * Author : harinatha reddy.
 * date : 5/10/18
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * checkstyle purpose Constructs the object.
     */
    private Solution() {

    }
    /**
     * main maethod starts here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestcases = input.nextInt();
        // System.out.println();
        for (int i = 0; i < noOfTestcases; i++) {
            int pivot = input.nextInt();
            input.nextLine();
            String elements = input.nextLine();
            Quick array = new Quick();
            String[] elearr = elements.split(" ");
            array.sort(elearr, pivot);
            // System.out.println(array.show(elearr));
            array.show(elearr);
            System.out.println();



        }
    }
}
/**
 * Class for quick.
 */
class Quick {

    /**
     * Constructs the object.
     */
    protected Quick() {
        /**
         * { item_description }
         */
    }

    /**
     * sort function.
     *
     * @param      a      { parameter_description }
     * @param      pivot  The pivot
     */
    public static void sort(final Comparable[] a, final int pivot) {
        sort(a, 0, a.length - 1, pivot);
        assert isSorted(a);
    }

    /**
     * sort function.
     *
     * @param      a      { parameter_description }
     * @param      lo     The lower
     * @param      hi     The higher
     * @param      pivot  The pivot
     */
    private static void sort(
        final Comparable[] a, final int lo, final int hi, final int pivot) {
        if (hi <= lo + pivot - 1) {
            System.out.println("insertionSort called");
            insertionSort(a, lo, hi);
            return;
        }

        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1, pivot);
        sort(a, j + 1, hi, pivot);
        assert isSorted(a, lo, hi);
    }
    /**
     * partition function.
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { description_of_the_return_value }
     */
    private static int partition(
        final Comparable[] a, final int lo, final int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) {

                    break;
                }
            }


            // check if pointers cross
            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);
        show(a);
        System.out.println();

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Comparable select(final Comparable[] a, final int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException(
                "index is not between 0 and " + a.length + ": " + k);
        }
        // StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {

            int i = partition(a, lo, hi);
            if (i > k) {
                hi = i - 1;
            } else if (i < k) {
                lo = i + 1;
            } else {
                return a[i];
            }
        }
        return a[lo];
    }



    /*********************************************************************
     *  Helper sorting functions.
     **********************************************************************/
    /**
     * less function.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private static boolean less(final Comparable v, final Comparable w) {
        if (v == w) {
            return false;   // optimization when reference equals

        }
        return v.compareTo(w) < 0;
    }

    /**
     * exchanges the elements.
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private static void exch(final Object[] a, final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /**
     * isorted function.
     *
     * @param      a     { parameter_description }
     *
     * @return     True if sorted, False otherwise.
     */
    private static boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted.
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    private static boolean isSorted(
        final Comparable[] a, final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }



    /**
     * show the array.
     *
     * @param      a     { parameter_description }
     */
    public  static void show(final Comparable[] a) {
        String str = "[";
        for (int i = 0; i < a.length; i++) {
            str += a[i] + ", ";
        }
        System.out.print(str.substring(0, str.length() - 2) + "]");
    }
    /**
     * {Method for insertion sort}.
     * sort from a[lo] to a[hi].
     * Time complexity of insertion sort is O(N^2/2).
     * @param      a     {Comparable array}.
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public static void insertionSort(final Comparable[] a,
                                     final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                // show(a);
            }
        }
    }

}
