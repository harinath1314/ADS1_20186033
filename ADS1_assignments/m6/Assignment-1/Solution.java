/**
 * Solution for tradinal adding;
 * Author Harinath reddy
 * date 29/9/18;
 */
import java.util.Scanner;
import java.util.Iterator;




/**
 * the main solution starts from here.
 */
public final class Solution {
    /**.
     * for checkstyle.
     */
    private Solution() {

    }
    /**
     * this is the main method of problem.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
         pDigits = AddLargeNumbers.numberToDigits(p);
         qDigits = AddLargeNumbers.numberToDigits(q);
         LinkedList result = AddLargeNumbers
        .addLargeNumbers(pDigits, qDigits);
         System.out.println(AddLargeNumbers.digitsToNumber(result));
         break;
        default:
            break;
        }
    }

}

/**.
 * class for linked list.
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E> implements Iterable<E> {

    /**
     * getsixe gives size of linked list.
     *
     * @return     { description_of_the_return_value }
     */
    public int getsize() {
        return size;
    }
    /**
     * inner Class node for linked list.
     *
     * @param      <E>   { parameter_description }
     */
    private class Node<E> {
        /**
         * variable.
         */
        private E data;
        /**
         * variable.
         */
        private Node<E> next;
        /**
         * Constructs the object.
         */
        Node() {

        }
        /**
         * Constructs the object for node class.
         *
         * @param      dat  The data
         */
        Node(final E dat) {
            this(dat, null);
        }
        /**
         * Constructs the object overladed.
         *
         * @param      dat  The data
         * @param      nex  The next
         */
        Node(final E dat, final Node<E> nex) {
            this.data = dat;
            this.next = nex;
        }

    }
    /**
     * two private variables for linked list.
     */
    private Node<E> head, tail;
    /**
     * int variable for linked list size.
     */
    private int size;

    /**
     * Adds an at tail of linked list.
     *
     * @param      data  The data
     */
    public void addAtTail(final E data) {
        Node<E> node = new Node<E>();
        node.data = data;
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = tail.next;
        size++;
    }

    /**
     * iterrator for iteration objects or elements.
     *
     * @return     myiterarot object is returned.
     */
    public Iterator<E> iterator() {
        return new MyIterator<E>(head);
    }
    /**
     * Class for my iterator.
     *
     * @param      <E>   generic type.
     */
    private class MyIterator<E> implements Iterator<E> {
        /**
         * Node for iteration.
         */
        private Node<E> current;
        /**
         * Constructs the object for my iterator.
         *
         * @param      first  The first
         */
        MyIterator(final Node<E> first) {
            current = first;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current !=  null;
        }
        /**
         * remove to override implenations.
         */
        public void remove() {

        }
        /**
         * next iteration of linked list.
         *
         * @return     { description_of_the_return_value }
         */
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
        /**
         * getter for ceckstyle.
         *
         * @return     { description_of_the_return_value }
         */
        public Node getcurrent() {
            return current;
        }
    }
}
