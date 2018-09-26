import java.util.Arrays;
import java.util.Scanner;
public final class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int one = input.nextInt();
        int two = input.nextInt();
        String[] first = input.next().split(",");
        String[] second = input.next().split(",");
        String[] oner, twoer;
        if (first.length > second.length) {
            oner = second;
            twoer = first;
        } else {
            oner = first;
            twoer = second;
        }
        int [] sorted = new int[oner.length + twoer.length];
        int k = oner.length - 1;
        int j = twoer.length - 1;
        int p = sorted.length - 1;
        for (int i = p; i > 0; i-- ) {
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

    }
}