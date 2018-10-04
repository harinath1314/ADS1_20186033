/**
 * class for Solution.
 * author harinath reddy
 * date 04/10/18.
 */
import java.util.Scanner;
/**
 * main solution class.
 */
public final class Solution {
    /**
     * Constructs the object for checkstyle.
     */
    private Solution() {

    }
    /**
     * main soltion is here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList list = new LinkedList();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String[] tokens = input.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    list.insertAt(Integer.parseInt(tokens[1]),
                                  Integer.parseInt(tokens[2]));
                    System.out.println(list.print());
                } catch (Exception a) {
                    System.out.println(a.getMessage());
                }
                break;
            case"reverse":
                try {
                    list.reverse();
                    System.out.println(list.print());

                } catch (Exception a) {
                    System.out.println(a.getMessage());
                }
                break;
            case"delete":
                break;
            default:
                break;
            }
        }

    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * main node.
     */
    private Node main;
    /**
     * link node.
     */
    private Node link;
    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {

    }
    /**
     * inner class node.
     *
     * @param      <E>   { parameter_description }
     */
    class Node<E> {
        /**
         * data variable.
         */
        private int data;
        /**
         * next node.
         */
        private Node next;
        /**
         * Constructs the object.
         */
        Node() {

        }
        /**
         * Constructs the object.
         *
         * @param      dat   The dat
         */
        Node(final int dat) {
            this.data = dat;
        }
        /**
         * Constructs the object.
         *
         * @param      dat   The dat
         * @param      nex   The nex
         */
        Node(final int dat, final Node nex) {
            this.data = dat;
            this.next = nex;
        }
    }
    /**
     * inserts element at the given index.
     *
     * @param      index      The index
     * @param      element    The element
     *
     * @throws     Exception  { exception_description }
     */
    public void insertAt(final int index, final int element) throws Exception {
        if (index > size || index < 0) {
            throw new Exception(
                "Can't insert at this position.");

        }
        main = inserthelper(main, index, element);
        size++;
    }
    /**
     * helper function for insertAt.
     *
     * @param      main     The main
     * @param      count    The count
     * @param      element  The element
     *
     * @return     { description_of_the_return_value }
     */
    public Node inserthelper(final Node main, int count, final int element) {
        if (count == 0) {
            return new Node(element, main);
        }
        int cou  = count;
        main.next = inserthelper(main.next, cou - 1, element);
        return main;
    }
    /**
     * reverse the hellper.
     *
     * @throws     Exception  { exception_description }
     */
    public void reverse() throws Exception {
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        main = reverseHelper(main);
    }
    /**
     * reverse the list.
     *
     * @param      main  The main
     *
     * @return     { description_of_the_return_value }
     */
    public Node reverseHelper(final Node main) {
        if (main == null || main.next == null) {
            return main;
        }
        Node nhead = reverseHelper(main.next);
        main.next.next = main;
        main.next = null;
        return nhead;
    }
    /**
     * prints the linked list.
     *
     * @return     { description_of_the_return_value }
     */
    public String print() {
        if (size != 0) {
            String str = "";
            Node temp = main;
            while (temp != null) {
                str += Integer.toString(temp.data) + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";

    }
}
