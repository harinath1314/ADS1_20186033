import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int number = input.nextInt();
		int [] check = new int[number];
		for (int i = 0; i < number; i++) {
			check[i] = input.nextInt();

		}
		Arrays.sort(check);

		int search = input.nextInt();
		System.out.printf("the nearest element in search index is %d"
			,bisearch(check, 0, number, search));
		System.out.println();

	}
	static int bisearch(int[] arr, int first, int last, int search) {
		if (first < last) {
			int middle = (first + last) / 2;
			if (arr[middle] == search) {
				int k = middle;
				while (arr[k] == arr[k - 1]) {
					k--;
				}
				return k;
			} else if (search < arr[middle]) {
				return bisearch(arr, first, middle - 1, search);
			} else {
				return bisearch(arr, middle + 1, last, search);
			}
		}
		return -1;
	}
}