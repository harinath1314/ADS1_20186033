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
                // System.out.println("hi mamam how are you");
                break;
            case"get":
                System.out.println(bst.get((new Book(tokens[1],
                                                     tokens[2], Double.parseDouble(tokens[2 + 1])))));
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



}
/**
 * Class for Binary Search Table.
 */
class Bst {

    /**
     * Class for node.
     */
    private class Node {
        /**
         *  key.
         */
        private Book key;
        /**
         * value.
         */
        private Integer value;
        /**
         * left link.
         */
        private Node left;
        /**
         * right.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      book    The book
         * @param      volume  The volume
         */
        Node(final Book book, final Integer volume) {
            this.key = book;
            this.value = volume;
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
            x.value = volume;
        }
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
        return (gethelp(root, book)).value;

    }
    /**
     * gethelp.
     *
     * @param      x     { parameter_description }
     * @param      book  The book
     *
     * @return     { description_of_the_return_value }
     */
    private Node gethelp(final Node x, final Book book) {
        if (x == null) {
            return x;
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


