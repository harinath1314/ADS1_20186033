import java.util.Arrays;
import java.util.Scanner;
/**
 * author harinath.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor not used
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int one = input.nextInt();
        int two = input.nextInt();
        String[] first;
        if (one != 0) {
            first = input.next().split(",");
        } else {
            first = new String[0];
        }
        String[] second = input.next().split(",");
        String[] oner, twoer;
        if (one > two) {
            oner = second;
            twoer = first;
        } else {
            oner = first;
            twoer = second;
        }
        int[] sorted = new int[oner.length + twoer.length];
        int k = oner.length - 1;
        int j = twoer.length - 1;
        int p = sorted.length - 1;
        if (k != -1) {
            for (int i = p; i > 0; i--) {
                if (Integer.parseInt(oner[k]) > Integer.parseInt(twoer[j])) {
                    sorted[p] = Integer.parseInt(oner[k]);
                    p--;
                    k--;
                } else {
                    sorted[p] = Integer.parseInt(twoer[j]);
                    p--;
                    j--;
                }
            }
            if (Integer.parseInt(
                        oner[0]) > Integer.parseInt(twoer[0])) {
                sorted[0] = Integer.parseInt(twoer[0]);
            } else {
                sorted[0] = Integer.parseInt(oner[0]);
            }
            System.out.println(
                Arrays.toString(sorted).replaceAll("[^0-9,]", ""));
        } else {
            System.out.println(Arrays.toString(twoer)
                               .replaceAll("[^0-9,]", ""));
        }


    }
}
