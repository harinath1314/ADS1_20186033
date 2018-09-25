// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }

/**
 *author harinatha reddy
 *date:25/9/28
 *percolation.
 */
// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * n-by-n matrix, with all sites blocked
     *
     */
    /**
     * final row.
     */
    private int [] finalrow;
    /**
     * matrix.
     */
    private boolean[] matrix;
    /**
     * countopen.
     */
    private int countofopen;
    /**
     * dimension.
     */
    private int dimension;
    /**
     * weight union.
     */
    private WeightedQuickUnionUF uf;
    /**
     * Constructs the object.
     *
     * @param      n    dimension of matrix.
     */
    Percolation(final int n) {
        matrix = new boolean[n * n];
        countofopen = 0;
        finalrow = new int[n];
        dimension = n;
        uf = new WeightedQuickUnionUF(n * n + 2);


    }
    /**
     * open function to creat open sites in matrix.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(final int row, final int col) {
        if (!isopen(row, col)) {
            matrix[(row * dimension) + col] = true;
            countofopen += 1;
            if (row - 1 >= 0 && isopen(row - 1, col)) {
                uf.union((row * dimension) + col, ((row - 1)
                * dimension) + col);


            }
            if ((row + 1 < dimension) && isopen(row + 1, col)) {
                uf.union((row * dimension) + col, ((row + 1)
                * dimension) + col);

            }
            if (col - 1 >= 0 && isopen(row, col - 1)) {
                uf.union((row * dimension) + col, ((row) * dimension)
                    + (col - 1));


            }
            if (col + 1 < dimension && isopen(row, col + 1)) {
                uf.union((row * dimension)
                    + col, ((row) * dimension) + (col + 1));


            }
            if (row == 0) {
                uf.union(row * dimension + col, dimension * dimension);

            }
            if (row == dimension - 1) {
                uf.union(row * dimension + col, dimension * dimension + 1);

            }



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
    public boolean isopen(final int row, final int col) {
        if(matrix[row * dimension + col]){
            return true;
        }
        return false;

    }


    /**
     * percolates function.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        return uf.connected(dimension * dimension, dimension * dimension + 1);
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
    /**
     * Constructs the object.
     */
    private Solution() {


    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int dim = input.nextInt();

        Percolation p = new Percolation(dim);

        while (input.hasNextInt()) {
            int row = input.nextInt();
            int col = input.nextInt();
            p.open(row - 1, col - 1);
        }
        System.out.println(p.percolates());
    }

}

