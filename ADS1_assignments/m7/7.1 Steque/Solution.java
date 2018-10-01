/**
 * class for Stqueue.
 * author harinatha reddy.
 * date : 1/10/18.
 */


import java.util.Scanner;
// import java.util.Iterator;
/**
 * class of Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * the main method starts here.
     *
     * @param      args  The arguments to be passed in main.
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        // int noOperations = input.nextInt();
        int noOperations = Integer.parseInt(input.nextLine());
        // System.out.println();
        int i = 0;
        for (i = 0; i < noOperations; i++) {
            Stqueue<String> test = new Stqueue<>();
            String hari = input.nextLine();
            while (hari.length() != 0) {
                String[] operation = (hari).split(" ");

                switch (operation[0]) {
                case "push":
                    test.push(operation[1]);
                    test.print();
                    break;
                case "pop":
                    if (!test.isEmpty()) {
                        test.pop();
                        test.print();
                        break;

                    } else {
                        System.out.println("Steque is empty.");
                    }
                    break;
                case "dequeue":
                    test.dequeue();
                    test.print();
                    break;
                case"enqueue":
                    test.enqueue(operation[1]);
                    test.print();
                default:
                    break;
                }
                if (input.hasNext()) {
                    hari = input.nextLine();
                } else {
                    break;
                }

            }
            System.out.println();
        }
    }
}
/**
 * Class for stqueue.
 * this behaves as a stack and queue.
 *
 * @param      <E>   { parameter_description }
 */
class Stqueue<E> {
    /**
     * Constructs the object.
     */
    Stqueue() {

    }
    /**
     * Class for node.
     *
     * @param      <E>
     */
    private class Node<E> {
        /**
         * data which will be appended.
         */
        private E data;
        /**
         * next carries the next object address.
         */
        private Node<E> next;
        /**
         * Constructs the object.
         */
        Node() {

        }
        /**
         * Constructs the object with data as arg.
         *
         * @param      dat  The data
         */
        Node(final E dat) {
            // this(data, null);
            this.data = null;
        }
        /**
         * Constructs the object for inner class node.
         *
         * @param      dat   The data to be stored.
         * @param      nex   The next address.
         */
        Node(final E dat, final Node nex) {
            this.data = dat;
            this.next = nex;
        }
    }
    /**
     * the variables main and link for a stqueue class.
     */
    private Node<E> main, link;


    /**
     * push function gives add method.
     *
     * @param      data  The data
     */
    public void push(final E data) {
        Node<E> node = new Node<E>();

        node.data = data;
        node.next = main;
        if (main == null) {
            main = node;
            link = node;
            return;

        }
        main = node;

    }
    /**
     * pop function returns the top most stack elements.
     *
     * @return     { description_of_the_return_value }
     */
    public E pop() {
        E data = main.data;
        main = main.next;
        return data;
    }
    /**
     * dequeue function returns the last element of stqueue.
     *
     * @return     E type of data is returned.
     */
    public E dequeue() {
        E data = link.data;
        Node<E> refer = main;

        while (refer.next != link) {
            refer = refer.next;
        }
        refer.next = null;
        link = refer;
        return data;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return main == null;
    }
    /**
     * enqurue method.
     *
     * @param      data  The data
     */
    public void enqueue(final E data) {
        Node<E> node = new Node<E>();
        node.data = data;
        node.next  = null;
        if (main == null) {
            main = node;
            link = node;
        } else {
            link.next = node;
            link = node;
        }

    }
    /**
     * print function.
     */
    public void print() {
        if (!isEmpty()) {
            Node<E> temp = main;
            while (temp.next != null) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.println(temp.data);

        } else {
            System.out.println("Steque is empty.");
        }
    }

}




