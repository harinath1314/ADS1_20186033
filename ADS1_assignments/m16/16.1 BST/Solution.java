/**
 * Solution for Binary Search Table.
 * author : harinatha reddy
 * date: 11/10/18.
 */
import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution{
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
			String[] tokens = input.nextLine().split(",");
			System.out.println(tokens[0]);
			switch (tokens[0]) {
			case"put":
				bst.put((new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]))) , Integer.parseInt(tokens[2 + 2]));
				break;
			case"get":
				System.out.println(bst.get((new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3])))));
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
class Bst {


	private class Node {

		private Book key;
		private Integer value;
		private Node left;
		private Node right;

		Node(Book book, Integer volume) {
			this.key = book;
			this.value = volume;

		}
	}
	private Node root;

	Bst() {
		this.root = null;
	}

	public void put(Book book, Integer volume) {
		root = helpingnature(root, book, volume);

	}

	private Node helpingnature(Node x, Book book, Integer volume) {

		if (root == null) {
			return new Node(book, volume);
		}
		int cmp = book.compareTo(x.key);
		if (cmp < 0) {
			x.left = helpingnature(x.left, book, volume);

		} else if (cmp > 0) {
			x.right = helpingnature(x.right, book, volume);

		} else {
			x.value = volume;
		}
		return x;

	}

	public Integer get(Book book) {
		return gethelp(root, book).value;

	}

	private Node gethelp(Node x , Book book) {
		if (x == null) {
			return null;
		}
		int cmp = book.compareTo(x.key);
		if (cmp < 0) {
			x.left = gethelp(x.left, book);

		} else if (cmp > 0) {
			x.right = gethelp(x.right, book);

		}
		return x;
	}

}


