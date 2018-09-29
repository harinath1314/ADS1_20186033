/**
 * Solution for tradinal adding;
 * Author Harinath reddy
 * date 29/9/18;
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;



// char[] ntd = number.toCharArray();

/**
 * Class for adding large numbers.
 */
class AddLargeNumbers {
	/**
	 * numbertoDigits converts number to linked lists.
	 *
	 * @param      number  The number
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static LinkedList numberToDigits(String number) {
		LinkedList<String> p = new LinkedList<>();
		String st = number;
		String [] numString = st.split("");
		for (String each : numString) {
			p.addAtTail(each);

		}
		return p;








	}
	/**
	 * digits to numbers function converts the linked list to a string.
	 *
	 * @param      list  The list
	 *
	 * @return     { description_of_the_return_value }
	 */
	static String r = "";
	public static String digitsToNumber(LinkedList list) {
		for (Iterator<String> c = list.iterator(); c.hasNext(); System.out.print((c.next())));
		return r;

	}
	/**
	 * this function adds two linked lists.
	 *
	 * @param      list1  The list 1
	 * @param      list2  The list 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	// public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

	// }
}

/**
 * the main solution starts from here.
 */
public class Solution {
	public static void main(String[] args) {
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

			// case "addLargeNumbers":
			// 	pDigits = AddLargeNumbers.numberToDigits(p);
			// 	qDigits = AddLargeNumbers.numberToDigits(q);
			// 	LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			// 	System.out.println(AddLargeNumbers.digitsToNumber(result));
			// 	break;
		}
	}

}

/**
 * class for linked list
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E> implements Iterable<E> {


	public int getsize() {
		return size;
	}
	/**
	 * inner Class node for linked list.
	 *
	 * @param      <E>   { parameter_description }
	 */
	private class Node<E> {
		E data;
		Node<E> next;
		Node () {}

		Node (E data) {
			this(data, null);
		}

		Node (E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

	}
	/**
	 * two private variables for linked list.
	 */
	private Node<E> head, tail;
	private int size;

	/**
	 * Adds an at tail of linked list.
	 *
	 * @param      data  The data
	 */
	public void addAtTail(E data) {
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
	// public String toString() {
	// 	String newS = "";
	// 	while (head != null) {
	// 		newS += head;


	// 	}
	// 	return newS;
	// }

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
		Node<E> current;
		/**
		 * Constructs the object for my iterator.
		 *
		 * @param      first  The first
		 */
		public MyIterator(Node<E> first) {
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
	}
}
