import java.util.Arrays;
import java.util.Scanner;
public final class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int one = input.nextInt();
		int two = input.nextInt();
		String[] first = input.next().split(",");
		String[] second = input.next().split(",");

		String[] oner,twoer;
		if (first.length > second.length) {
			oner = second;
			twoer = first;
		} else {
			oner = first;
			twoer = second;
		}
		int [] sorted = new int[oner.length + twoer.length];

		// System.out.println(Arrays.toString(oner));
		// System.out.println(Arrays.toString(twoer));

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

		// } else {
		// 	int k = first.length-1;
		// 	int j = second.length-1;
		// 	int p = sorted.length-1;
		// 	for (int i = 0; i < sorted.length-2; i++ ) {
		// 		if (Integer.parseInt(second[j]) >= Integer.parseInt(first[k])) {
		// 			sorted[p] = Integer.parseInt(second[j]);
		// 			p--;
		// 			j--;
		// 		} else if (Integer.parseInt(second[j]) < Integer.parseInt(first[k])) {
		// 			sorted[p] = Integer.parseInt(first[k]);
		// 			p--;
		// 			k--;
		// 		}




		// 	}

		// }
		System.out.println(Arrays.toString(sorted));

	}
}