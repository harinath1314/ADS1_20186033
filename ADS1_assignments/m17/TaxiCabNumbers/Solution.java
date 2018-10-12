/**
 * Solution of Taxi numbers problem.
 * aythor hainatha reddy
 * date : 12:10:18.b
 */
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
class MinPQ<Key> implements Iterable<Key> {
    /**
     * key array to store elements.
     */
    private Key[] pq;
    /**
     * variable int .
     */
    private int n;
    /**
     * comparator.
     */
    private Comparator<Key> comparator;

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MinPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException
            ("Priority queue underflow");
        return pq[1];
    }

    /**
     * resize method.
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException
            ("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;   // to avoid loiterig and help with garbage collec
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }
    /**
     * Swim method.
     *
     * @param      k     { parameter_description }
     */
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * sink method.
     *
     * @param      k     { parameter_description }
     */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /**
     * greter method.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * excahange method.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    /**
     * Determines if minimum heap.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }


    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**
     * Class for heap iterator.
     */
    private class HeapIterator implements Iterator<Key> {
        /**
         * copy variable.
         */
        private MinPQ<Key> copy;

        /**
         * Constructs the object.
         */
        public HeapIterator() {
            if (comparator == null) copy = new MinPQ<Key>(size());
            else                    copy = new MinPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }
        /**
         * hasNext method.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  { return !copy.isEmpty();   }
        /**
         * remove method.
         */
        public void remove()  { throw new UnsupportedOperationException(); }
        /**
         * next method.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }


}
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * sum variable.
     */
    private final int sum;
    /**
     * int i variable.
     */
    public final int i;
    /**
     * int j varibale.
     */
    public final int j;
    /**
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }
    /**
     * geti method.
     *
     * @return     { description_of_the_return_value }
     */
    int geti() {
        return this.i;
    }
    /**
     * getj method.
     *
     * @return     { description_of_the_return_value }
     */
    int getj() {
        return this.j;
    }
    /**
     * getsum method.
     *
     * @return     { description_of_the_return_value }
     */
    int getsum() {
        return this.sum;
    }
    /**
     * compareTo method.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }




}
/**
 * Solution class and the main method is here.
 */
class Solution {
    /**
     * taxinumber method.
     *
     * @param      list  The list
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int taxinumber(ArrayList<CubeSum> list, int n, int m) {
        int i = 0;
        int res = 0;
        while (n != 0 && i < list.size() - m + 1) {
            ArrayList<CubeSum> sublist = new ArrayList<CubeSum>
            (list.subList(i++, i + m - 1));
            HashSet<Integer> set = new HashSet<Integer>();
            for (CubeSum each : sublist) {
                set.add(each.getsum());
            }
            // System.out.println(set);
            if (set.size() == 1) {
                res = sublist.get(0).getsum();
                n--;
            }

        }
        return res;
    }
    /**
     * main method starts here.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        int num = 500;
        Scanner sc = new Scanner(System.in);
        ArrayList<CubeSum> cubelist = new ArrayList<CubeSum>();
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= num; i++) {
            pq.insert(new CubeSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            cubelist.add(s);
            if (s.getj() < num)
                pq.insert(new CubeSum(s.geti(), s.getj() + 1));
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(taxinumber(cubelist, n, m));
    }
}
