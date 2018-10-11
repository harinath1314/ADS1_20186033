/**
 * Solution for Binary Search Table.
 * author : harinatha reddy
 * date: 11/10/18.
 */
import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution {
	/**
	 * Constructs the object for checkstyle.
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
		Bst bst = new Bst();
		while (input.hasNextLine()) {
			String[] tokens = input.nextLine().split(" ");
			switch (tokens[0]) {
			case"put":
				bst.put((Comparable)(new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]))) , Integer.parseInt(tokens[2 + 2]));
				break;
			case"get":
				System.out.println(bst.get((Comparable)(new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3])))));
				break;
			default:
				break;
			}

		}


	}

}
/**
 * Class for book.
 */
class Book {
	/**
	 * book name.
	 */
	private String name;
	/**
	 * book author.
	 */
	private String author;
	/**
	 * book price.
	 */
	private double price;

	/**
	 * Constructs the  for Book class.
	 *
	 * @param      bookname    The bookname
	 * @param      authorname  The authorname
	 * @param      bookprice   The bookprice
	 */
	Book(final String bookname, final String authorname, final double bookprice) {
		this.name = bookname;
		this.author = authorname;
		this.price = bookprice;
	}
	public String getname() {
		return name;
	}
	public String getauthor() {
		return author;
	}
	public double getprice() {
		return price;
	}
	public int compareTo(Book that) {
		return this.name.compareTo(that.name);
	}



}
/**
 * Class for Binary Search Table.
 */
class Bst<Key extends Comparable<Key>, Value> {


	private class Node {

		private Key key;
		private Value value;
		private Node left;
		private Node right;

		Node(Key book, Value volume) {
			this.key = book;
			this.value = volume;

		}
	}
	private Node root;

	Bst() {
		this.root = null;
	}

	public void put(Key book, Value volume) {
		root = helpingnature(root, book, volume);

	}

	private Node helpingnature(Node x, Key book, Value volume) {

		if (root == null) {
			return new Node(book, volume);
		}
		int compare = book.compareTo(x.key);
		if (compare < 0) {
			x.left = helpingnature(x.left, book, volume);

		} else if (compare > 0) {
			x.right = helpingnature(x.right, book, volume);

		} else {
			x.value = volume;
		}
		return x;

	}

	public Value get(Key book) {
		return gethelp(root, book).value;

	}

	private Node gethelp(Node x , Key book) {
		if (x == null) {
			return null;
		}
		int compare = book.compareTo(x.key);
		if (compare < 0) {
			x.left = gethelp(x.left, book);

		} else if (compare > 0) {
			x.right = gethelp(x.right, book);

		}
		return x;
	}

}


