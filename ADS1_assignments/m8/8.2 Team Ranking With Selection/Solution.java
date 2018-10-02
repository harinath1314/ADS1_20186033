/**
 * Solution for insertion method.
 * author :harinath reddy
 * date: 2/10/18.
 */
import java.util.Scanner;
/**
 * Class for tournament.
 */
class Selection implements Comparable<Selection> {
    /**
     * declaration of teamName.
     */
    private String teamName;
    /**
     * declaration of win.
     */
    private int wins;
    /**
     * declaration of losses.
     */
    private int losses;
    /**
     * declaration of draw.
     */
    private int draws;
    /**
     * Constructs the object.
     */
    Selection() {
    }
    /**
     * Constructs the object.
     *
     * @param      name  The name
     * @param      win   The window
     * @param      loss  The loss
     * @param      draw  The draw
     */
    Selection(final String name, final int win,
              final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.teamName;
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the loss.
     *
     * @return     The loss.
     */
    public int getLoss() {
        return this.losses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * compare method.
     *time complexity is constant of O(1) for all the three cases.
     * @param      that  The that
     *
     * @return  integer.
     */
    public int compareTo(final Selection that) {
        if (this.getWins() > that.getWins()) {
            return 1;
        } else if (this.getWins() < that.getWins()) {
            return -1;
        }
        if (this.getLoss() < that.getLoss()) {
            return 1;
        } else if (this.getLoss() > that.getLoss()) {
            return -1;
        }
        if (this.getDraws() > that.getDraws()) {
            return 1;
        } else if (this.getDraws() < that.getDraws()) {
            return -1;
        }
        return 0;
    }

}
/**
 * Class for insertion sort.
 */
class SelectionSort {
    /**
     *  teamlist.
     */
    private Selection[]teamlist;
    /**
     *  size.
     */
    private int size;

    /**
     * Constructs the object.
     */
    SelectionSort() {
        this.size = 0;
        this.teamlist = new Selection[2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2];
    }
    /**
     * size method.
     *
     * @return size of array.
     */
    public int size() {
        return size;
    }
    /**
     * add method.
     *
     * @param      game  The game
     */
    public void add(final Selection game) {
        teamlist[size++] = game;
    }
    /**
     * sorting of elements using insertion sort.
     * time complexity is N^2 for worst case;
     * for best case it is n iterations and zero swaps since
     * it is a sorted array.
     */
    public void insertionsort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (teamlist[j].compareTo(teamlist[j - 1]) == 1) {
                    swap(teamlist, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    /**
     * swap method.
     *
     * @param      a array.
     * @param      i integer.
     * @param      j integer.
     */
    public void swap(final Comparable[] a, final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        int k = 0;
        String str = "";
        int h = 0;
        while (k < size - 1) {
            str += teamlist[k].getName() + ",";
            k++;
        }
        str += teamlist[k].getName();
        return str;
    }
}
/**
 *client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method starts here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SelectionSort s = new SelectionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            s.add(new Selection(tokens[0], Integer.parseInt(tokens[1]),
            Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1])));
        }
        s.insertionsort();
        System.out.println(s);
    }
}
