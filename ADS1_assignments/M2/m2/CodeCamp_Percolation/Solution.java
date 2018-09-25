// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * n-by-n matrix, with all sites blocked
     */
    int [][] matrix;
    int countofopen;

    /**
     * Constructs the object.
     *
     * @param      n    dimension of matrix.
     */
    Percolation(int n) {
        matrix = new int[n][n];
        countofopen = 0;

    }
    /**
     * open function to creat open sites in matrix.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(int row, int col) {
        if (!isopen(row, col)) {
            matrix[row][col] = 1;
            countofopen += 1;

        }

    }
    /**
     * isopen function.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     boolean type.
     */
    public boolean isopen(int row, int col) {
        return matrix[row][col] == 1;

    }
    /**
     * is full function to check is block is ful or open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return      boolean type.
     */
    public boolean isfull(int row, int col) {
        return matrix[row][col] == 2;

    }
    /**
     * percolates function.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        return true;
    }



}




// h
// a
// r
// i
/**
 * class for the solution to find pecolation.
 */
public final class Solution {

    private Solution() {


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dim = input.nextInt();

        Percolation p = new Percolation(dim);

        while (input.hasNextInt()) {
            int row = input.nextInt();
            int col = input.nextInt();
            p.open(row, col);
        }
        try {
            if (p.countofopen < dim) {
                throw new Exception("does not percolate");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(p.percolates());
    }

}