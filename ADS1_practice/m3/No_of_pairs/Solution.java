import java.util.Scanner;
import java.util.Arrays;
public class Solution{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int pair = 1;
		int total = 0;
		int number = input.nextInt();
		int [] check = new int[number];
		for (int i = 0; i < number; i++) {
			check[i] = input.nextInt();

			
		}
		Arrays.sort(check);

		for (int i = 0; i < number-1; i++) {
			if(check[i]==check[i+1]){
				count+= pair;
				total+=count;
				pair++;
			}else{
				pair = 1;
			}
			
		}
		System.out.printf("Count of pairs in the given array is %d",count);
		System.out.println();



	}
}