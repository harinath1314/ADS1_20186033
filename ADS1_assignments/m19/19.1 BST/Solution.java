/**
 * file name :APi using seach tree.
 * author : harinatha reddy
 * date : 22-10-18.
 */


/**
 * solution class is here.
 */
public final class Solution {
	/**
	 * main method for the solution starts here.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {

	}
}
/**
 * Class for book.
 */
class Book {
	/**
	 * String varible bok name.
	 */
	private String bookname;
	/**
	 * String variable author.
	 */
	private String bookauthor;
	/**
	 * cost of the book .
	 */
	private Double price;
	/**
	 * Constructs the object for book class.
	 *
	 * @param      name    The name
	 * @param      author  The author
	 * @param      cost    The cost
	 */
	Book(String name, String author, Double cost) {
		this.bookname = name;
		this.bookauthor = author;
		this.price = cost;


	}
	/**
	 * getter for the book name variable.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getname() {
		return bookname;
	}

}


// /**
//  * Class for bst.
//  */
// class BST{
// 	/**
// 	 * Class for node.
// 	 */
// 	private class Node{
// 		private Key key;
// 		private Value val;
// 		private Node left;
// 		private Node right;
// 		private int  count;

// 		Node(Key book, Value val){
			
// 		}


// 	}
// }