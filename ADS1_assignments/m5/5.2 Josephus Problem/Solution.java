
/**.
 * author Harinatha reddy;.
 * date: 30/9/18;.
 * class: for the joseph.
 */
import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * no of elements.
     */
    private int noE;
    /**
     * first, last nodes.
     */
    private Node first, last;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * data.
         */
        private int data;
        /**
         * next link.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      val   The value
         * @param      link  The link
         */
        Node(final int val, final Node link) {
            this.data = val;
            this.next = link;
        }
    }
    /**
     * Constructs the object.
     */
    Deque() {
        noE = 0;
        first = null;
        last = null;
    }
    /**
     * Pushes a left.
     *
     * @param      value  The value
     */
    void pushLeft(final int value) {
        if (first == null) {
            first = new Node(value, null);
            last = first;
        } else {
            Node newnode = new Node(value, first);
            first = newnode;
        }

        noE++;
    }
    /**
     * Pushes a right.
     *
     * @param      value  The value
     */
    void pushRight(final int value) {
        if (last == null) {
            last = new Node(value, null);
            first = last;
        } else {
            Node newnode = new Node(value, null);
            last.next = newnode;
            last = newnode;
        }
        noE++;
    }
    /**
     * popleft.
     *
     * @return     { description_of_the_return_value }
     */
    int popLeft() {
        if (first != null) {
            Node popped = first;
            first = first.next;
            popped.next = null;
            noE--;
            return popped.data;

        } else {
            return 0;
        }
    }
    /**
     * pop right.
     *
     * @return     { description_of_the_return_value }
     */
    int popRight() {
        if (last != null) {
            Node temp = null;
            Node popped = last;
            Node element = first;
            while (element != last) {
                temp = element;
                element = element.next;
            }
            last = temp;
            last.next = null;
            //popped.next = null;
            noE--;
            return popped.data;
        } else {
            return 0;
        }
    }
    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    int size() {
        return noE;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return first == null;
    }
    /**
     * prints.
     *
     * @return     { description_of_the_return_value }
     */
    String print() {
        if (noE != 0) {
            String str = "";
            Node temp = first;
            while (temp != null) {
                str += Integer.toString(temp.data) + ", ";
                temp = temp.next;
            }
            return "[" + str.substring(0, str.length() - 2) + "]";
        }
        return "[]";

    }

}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfinputs = sc.nextInt();
        for (int i = 0; i < noOfinputs; i++) {
            Deque queue = new Deque();
            sc.nextLine();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                queue.pushRight(j);
            }
            while (queue.size() != 1) {
                for (int j = 0; j < m - 1; j++) {
                    queue.pushRight(queue.popLeft());
                }
                System.out.print(queue.popLeft() + " ");
                //queue.print();
            }
            System.out.print(queue.popLeft());
            System.out.println();
        }
    }
}
