/**
 * class for selection method.
 * author harinatha reddy.
 * date : 02/10/18.
 */

import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method starts from here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Selection s = new Selection();
        Selection[] teams = new Selection[2 + 2 + 2 + 2 + 2 + 2];
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (input.hasNextLine()) {
            String teamDetails = input.nextLine();
            teams[i++] = (new Selection(teamDetails));
        }

        for (int j = 0; j < i; j++) {
            for (int k = j + 1; k < i; k++) {
                if (teams[k].getwins() > teams[j].getwins()) {
                    Selection temp = teams[k];
                    teams[k] = teams[j];
                    teams[j] = temp;


                } else if (teams[k].getwins() == teams[j].getwins()) {

                    if (teams[k].getloses() < teams[j].getloses()) {
                        Selection temp = teams[k];
                        teams[k] = teams[j];
                        teams[j] = temp;
                    } else if (teams[k].getloses() == teams[j].getloses()) {
                        if (teams[k].getdraws() > teams[j].getdraws()) {
                            Selection temp = teams[k];
                            teams[k] = teams[j];
                            teams[j] = temp;

                        }

                    }
                }

            }
        }
        s.toString(teams, i);

    }
}

/**
 * Class for selection.
 */
class Selection {
    /**
     * Constructs the object.
     */
    Selection() {

    }
    /**
     * String teamname;.
     */
    private String teamname;
    /**
     * int wins;.
     */
    private int wins;
    /**
     * itn loses.
     */
    private int loses;
    /**
     * int draws.
     */
    private int draws;
    /**
     * Constructs the object for selection class.
     *
     * @param      data  The data
     */
    Selection(final String data) {
        String[] details = data.split(",");
        this.teamname = details[0];
        this.wins = Integer.parseInt(details[1]);
        this.loses = Integer.parseInt(details[2]);
        this.draws = Integer.parseInt(details[2 + 1]);
    }

    /**
     * getter for teamname.
     *
     * @return     { description_of_the_return_value }
     */
    public String getteam() {
        return teamname;
    }
    /**
     * getter for wins.
     *
     * @return     { description_of_the_return_value }
     */
    public int getwins() {
        return wins;
    }
    /**
     * getter for loses.
     *
     * @return     { description_of_the_return_value }
     */
    public int getloses() {
        return loses;
    }
    /**
     * getter for draws.
     *
     * @return     { description_of_the_return_value }
     */
    public int getdraws() {
        return draws;
    }
    /**
     * output format to be printed.
     *
     * @param      teams  The teams
     * @param      i      { parameter_description }
     */
    public void toString(final Selection[] teams, final  int i) {
        int j;
        for (j = 0; j < i - 1; j++) {
            System.out.print(teams[j].getteam() + ",");
        }
        System.out.print(teams[j].getteam());
    }
}
