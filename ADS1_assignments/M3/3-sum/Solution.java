/**.
 * author : harinatha reddy.
 * date : 26:9:18
 * name : threesum probelm.
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for solution of threesum problem.
 */
public class Solution {
    /**
     * Constructs the object of solution.
     */
    private Solution() {

    }
    /**
     * main function is here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int arrdim = input.nextInt();
        int[] threesum = new int[arrdim];
        for (int i = 0; i < arrdim; i++) {
            threesum[i] = input.nextInt();
        }
        Arrays.sort(threesum);
        int count = 0;
        for (int i = 0; i < arrdim - 2; i++) {
            int j = i + 1;
            int k = arrdim - 1;
            if (threesum[i] + threesum[j] + threesum[k] == 0) {
                count++;
                j++;
                k--;
            } else if (threesum[i] + threesum[j] + threesum[k] < 0) {
                j++;

            } else {
                k--;
            }

        }
        System.out.println(count);

    }
}
