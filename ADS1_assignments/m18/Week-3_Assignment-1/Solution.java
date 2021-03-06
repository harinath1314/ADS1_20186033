/**
 * ADS week-3 exam.
 * Author harinatha reddy
 * date 13/10/18.
 */
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;




class Stock {

    private String stockname;
    private float changevalue;
    
    Stock(){

    }
    Stock(String name, String change ){
        this.stockname = name;
        this.changevalue = Float.parseFloat(change);
    }

    public String getname(){
        return stockname;
    }
    public float getvalue(){
        return changevalue;
    }

    public int compareTo(Stock data){
        return(data.getname().compareTo(this.getname()));

    } 
    public String toString(){
        return getname()+  "-"+getvalue();
    }
}

/**
 * Class for maximum pq.
 *
 * @param      <Stock>  The key
 */
class MaxPQ<Stock> implements Iterable<Stock> {
    private Stock[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Stock> comparator;  // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MaxPQ(int initCapacity) {
        pq = (Stock[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(int initCapacity, Comparator<Stock> comparator) {
        this.comparator = comparator;
        pq = (Stock[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(Comparator<Stock> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MaxPQ(Stock[] keys) {
        n = keys.length;
        pq = (Stock[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
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
     * Returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Stock max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Stock[] temp = (Stock[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }


    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the new key to add to this priority queue
     */
    public void insert(Stock x) {

        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Stock delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Stock max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;   // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }


    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/
    public boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Stock>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        Stock swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }


    /***************************************************************************
     * Iterator.
     ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in descending order.
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Stock> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Stock> {

        // create a new pq
        private MaxPQ<Stock> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<Stock>(size());
            else                    copy = new MaxPQ<Stock>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Stock next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
    // public String toString(){
    //     return delMax();
    // }



}



/**
 *====================================================================================================================================================
 *====================================================================================================================================================
 * ====================================================================================================================================================
 */

/**
 * Class for minimum pq.
 *
 * @param      <Stock>  The key
 */
class MinPQ<Stock> implements Iterable<Stock> {
    private Stock[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Stock> comparator;  // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(int initCapacity) {
        pq = (Stock[]) new Object[initCapacity + 1];
        // String[] lauda = new String[2];
        // pq = new Stock[initCapacity + 1];
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
    public MinPQ(int initCapacity, Comparator<Stock> comparator) {
        this.comparator = comparator;
        pq = (Stock[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(Comparator<Stock> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MinPQ(Stock[] keys) {
        n = keys.length;
        pq = (Stock[]) new Object[keys.length + 1];
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
    public Stock min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Stock[] temp = (Stock[]) new Object[capacity];
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
    public void insert(Stock x) {
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
    public Stock delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Stock min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;   // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }


    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    public void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/
    public boolean greater(int i, int j) {
        if (comparator == null) {
                        // System.out.println(" *********** ");
                        // Stock pq[i] = new Stock();
                        // Stock pq[j] = new Stock();

                        // Stock pq[i] = pq[i];
                        // Stock pq[j] = pq[j];

                        // System.out.println("pq[i] =" + pq[i]);
                        // System.out.println(pq[i].getname());
                        // System.out.println(Stock.getname());
                        // String[] newline = 
                        // System.out.println("hello babu" + pq[i]);

            return ((Comparable<Stock>) pq[i]).compareTo(pq[j]) > 0;
                        // return true;
        } else {
            System.out.println("===========================");
            System.out.println(pq[i]);
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    public void exch(int i, int j) {
        Stock swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a min heap?
    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    public boolean isMinHeap(int k) {
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
    public Iterator<Stock> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Stock> {
        // create a new pq
        private MinPQ<Stock> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MinPQ<Stock>(size());
            else                    copy = new MinPQ<Stock>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Stock next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }


}



/**
 * class for Solution.
 */

public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method starts here.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noStocks = Integer.parseInt(input.nextLine());
        for (int i = 0; i < 6; i++) {
            int j = 0;
            MaxPQ<Stock> mapq = new MaxPQ<Stock>();
            MinPQ<Stock>  mipq = new MinPQ<Stock>();
            while (j < noStocks) {
                String company = input.nextLine();
                String[] companysplit = company.split(",");
                Stock comp = new Stock(companysplit[0], companysplit[1]);

                mapq.insert(comp);
                System.out.println("ob1 = "+comp);
                mipq.insert(comp);
                System.out.println("ob2 = "+comp);

                j++;

            }
            for (int x =0 ; x < 5; x++) {
                Stock s = mapq.delMax();
            System.out.println(s.toString());
                
            }
            System.out.println();

            for (int y =0 ; y < 5; y++) {
                Stock p = mipq.delMin();
            System.out.println(p.toString());
                
            }
            System.out.println();




        }
    }
}








