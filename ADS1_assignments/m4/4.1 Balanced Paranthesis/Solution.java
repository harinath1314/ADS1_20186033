import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private Solution() {

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.nextLine();
		Stack s = new Stack();
		char[] brac = input.nextLine().toCharArray();
		for (char each : brac) {
			if(each == '{' || each == '[' || each == '(') {
				s.push(each);
			}else{
				if(!s.isempty()){
					char top = s.gettop();
					if((top == '{'&&each == '}')||(top == '['&&each == ']')||(top == '('&&each == ')')){
						s.pop();
					} else{
						System.out.println("NO");
					}
				}else{
					System.out.println("NO");
				}
			}
		}
		if(s.isempty()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}


	}
	// public static boolean isbalanced(){

	// }
}
class Stack {
	char [] brackets;
	int size;
	public Stack() {
		brackets = new char[10];
		size = 0;

	}
	public void push(char bracket) {
		brackets[size++] = bracket;

	}
	public char pop() {
		return brackets[--size];

	}
	public boolean isempty() {
		return size == 0;
	}
	public char gettop(){
		return brackets[size-1];
	}

}