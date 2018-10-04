/**
 * class for Solution.
 * author harinath reddy
 * date 04/10/18.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * main solution class.
 */
public final class Solution {
	/**
	 * main soltion is here.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
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
				list.reverse();
				System.out.println(list.print());


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
		Node(int dat) {
			this.data = dat;
		}
		/**
		 * Constructs the object.
		 *
		 * @param      dat   The dat
		 * @param      nex   The nex
		 */
		Node(int dat, Node nex) {
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
	public void insertAt(int index, int element) throws Exception {
		if (index > size) throw new Exception
			("Can’t insert at this position");
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
	public Node inserthelper(Node main, int count , int element) {
		if (count == 0) {
			return new Node(element, main);
		}
		main.next = inserthelper(main.next, count--, element);
		return main;
	}

	public void reverse() {
		main = reverseHelper(main);
	}

	public Node reverseHelper(Node main) {
		if (main == null || main.next == null) return main;
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
			return "[" + str.substring(0, str.length() - 2) + "]";
		}
		return "[]";

	}
}