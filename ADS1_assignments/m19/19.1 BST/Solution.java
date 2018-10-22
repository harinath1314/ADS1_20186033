/**
 * file name :API using search tree.
 * author : harinatha reddy
 * date : 22-10-18.
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
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		Bst bst = new Bst();
		while (input.hasNext()) {
			String[] tokens = input.nextLine().split(",");

			switch (tokens[0]) {
			case"put":
				bst.put(new Book(tokens[1], tokens[2],
				                 Double.parseDouble(tokens[2 + 1])),
				        Integer.parseInt(tokens[2 + 2]));
				break;
			case"get":
				System.out.println(bst.get((new Book(tokens[1],
				                                     tokens[2], Double.parseDouble(tokens[2 + 1])))));
				break;
			case"min":
				System.out.println(bst.min());
				break;
			case"max":
				System.out.println(bst.max());
				break;
			case"select":
				System.out.println(bst.select(Integer.parseInt(tokens[1])));
				break;
			case"floor":
				System.out.println(bst.floor(new Book(tokens[1], tokens[2],
				            Double.parseDouble(tokens[2 + 1]))));
				break;
			case"ceiling":
				System.out.println(bst.ceiling(new Book(tokens[1], tokens[2],
				            Double.parseDouble(tokens[2 + 1]))));
				break;
			default:
				break;
			}

		}


	}

}/**
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
	Book(final String bookname, final String authorname,
	     final double bookprice) {
		this.name = bookname;
		this.author = authorname;
		this.price = bookprice;
	}
	/**
	 * getter for name.
	 *
	 * @return      name of book.
	 */
	public String getname() {
		return name;
	}
	/**
	 * getter for author.
	 *
	 * @return      author name.
	 */
	public String getauthor() {
		return author;
	}
	/**
	 * getter for price.
	 *
	 *
	 * @return     price of book.
	 */
	public double getprice() {
		return price;
	}
	/**
	 * compare to funtcion.
	 *
	 * @param      that  The that.
	 *
	 * @return     integer.
	 */
	public int compareTo(final Book that) {

		if (this.getname().compareTo(that.getname()) > 0) {
			return 1;
		} else if (this.getname().compareTo(that.getname()) < 0) {
			return -1;
		} else {
			if (this.getauthor().compareTo(that.getauthor()) > 0) {
				return 1;
			} else if (this.getauthor().compareTo(that.getauthor()) < 0) {
				return -1;
			} else {
				if (this.getprice() > that.getprice()) {
					return 1;
				} else if (this.getprice() < that.getprice()) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
	/**
	 * tostring method.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String toString() {
	return this.getname() + ", " + this.getauthor() + ", " + this.getprice();
	}



}


/**
 * Class for bst.
 */
class Bst {
	/**
	 * Class for node.
	 */
	private class Node {
		/**
		 * book key varoiable.
		 */
		private Book key;
		/**
		 * valvariable.
		 */
		private Integer val;
		/**
		 * left node.
		 */
		private Node left;
		/**
		 * right node.
		 */
		private Node right;
		/**
		 * count varible.
		 */
		private int  count;
		/**
		 * Constructs the object.
		 *
		 * @param      book   The book
		 * @param      value  The value
		 */
		Node(final Book book, final Integer value) {
			this.key = book;
			this.val = value;
			this.left = null;
			this.right = null;



		}


	}

	/**
	 * root.
	 */
	private Node root;
	/**
	 * Constructs the object.
	 */
	Bst() {
		this.root = null;
	}
	/**
	 * size method.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return size(root);
	}
	/**
	 * size with root.
	 *
	 * @param      x     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size(final Node x) {
		if (x == null) {
			return 0;
		}
		return x.count;
	}
	/**
	 * put method.
	 * complexity of put method in average is log N
	 * complexity of put method in worst case is N.
	 *
	 * @param      book    The book
	 * @param      volume  The volume
	 */
	public void put(final Book book, final Integer volume) {
		root = helpingnature(root, book, volume);

	}
	/**
	 * helper function.
	 *
	 * @param      x       { parameter_description }
	 * @param      book    The book
	 * @param      volume  The volume
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Node helpingnature(final Node x, final Book book,
	                           final Integer volume) {

		if (x == null) {
			return new Node(book, volume);
		}
		int cmp = book.compareTo(x.key);
		if (cmp < 0) {
			x.left = helpingnature(x.left, book, volume);

		} else if (cmp > 0) {
			x.right = helpingnature(x.right, book, volume);

		} else {
			x.val = volume;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;

	}
	/**
	 * get method.
	 * complexity of get method in average is log N
	 * complexity of get method in worst case is N.
	 *
	 *
	 * @param      book  The book
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Integer get(final Book book) {
		return (gethelp(root, book));

	}
	/**
	 * gethelp.
	 *
	 * @param      x     { parameter_description }
	 * @param      book  The book
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Integer gethelp(final Node x, final Book book) {
		if (x == null) {
			return null;
		}
		int cmp = book.compareTo(x.key);
		if (cmp < 0) {
			return  gethelp(x.left, book);

		} else if (cmp > 0) {
			return  gethelp(x.right, book);

		}
		return x.val;
	}

	/**
	 * minimum function method.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Book min() {
		return min(root).key;

	}
	/**
	 * min function.
	 *
	 * @param      x     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Node min(final Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);

	}
	/**
	 * minimum function method.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Book max() {
		return max(root).key;

	}
	/**
	 * max function.
	 *
	 * @param      x     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Node max(final Node x) {
		if (x.right == null) {
			return x;
		}
		return max(x.right);

	}

	/**
	 * Return the key in the symbol table whose rank is {@code k}.
	 * This is the (k+1)st smallest key in the symbol table.
	 *
	 * @param  k the order statistic
	 * @return the key in the symbol table of rank {@code k}
	 * @throws IllegalArgumentException unless {@code k} is between 0 and
	 *        <em>n</em>–1
	 */
	public Book select(int k) {
		// if (k < 0 || k >= size()) {
		// 	throw new IllegalArgumentException("argument to select() is invalid: " + k);
		// }
		Node x = select(root, k);
		return x.key;
	}

	// Return key of rank k.
	private Node select(Node x, int k) {
		if (x == null) return null;
		int t = size(x.left);
		if      (t > k) return select(x.left,  k);
		else if (t < k) return select(x.right, k - t - 1);
		else            return x;
	}
	/**
	 * Returns the largest key in the symbol table less than or .
	 *
	 * @param  key the key
	 * @return the largest key in the symbol table less than
	 * @throws NoSuchElementException if there is no such key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Book floor(Book key) {
		if (key == null) throw new IllegalArgumentException("argument to floor() is null");
		Node x = floor(root, key);
		if (x == null) return null;
		else return x.key;
	}

	private Node floor(Node x, Book key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp <  0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null) return t;
		else return x;
	}
	/**
	 * Returns the smallest key in the symbol table greater than or equal.
	 *
	 * @param  key the key
	 * @return the smallest key in the symbol table greater than or equal.
	 * @throws NoSuchElementException if there is no such key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Book ceiling(Book key) {
		if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
		Node x = ceiling(root, key);
		if (x == null) return null;
		else return x.key;
	}

	private Node ceiling(Node x, Book key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0) {
			Node t = ceiling(x.left, key);
			if (t != null) return t;
			else return x;
		}
		return ceiling(x.right, key);
	}

}