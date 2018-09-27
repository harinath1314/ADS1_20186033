import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private Solution() {

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.nextLine();
        while (input.hasNext()) {
            char[] brac = input.nextLine().toCharArray();
            System.out.println(isbalanced(brac));
            
        }


    }
    public static String isbalanced(char[] brac){
        Stack s = new Stack();

        for (char each : brac) {
                if (each == '{' || each == '[' || each == '(') {
                    s.push(each);
                } else {
                    if (!s.isempty()) {
                        char top = s.gettop();
                        if ((top == '{' && each == '}') || (top == '[' && each == ']') || (top == '(' && each == ')')) {
                            s.pop();
                        } else {
                            return"NO";
                        }
                    } else {
                        return "NO";
                    }
                }
            }
            if (s.isempty()) {
                return "YES";
            } else {
                return "NO";
            }

    }
}
class Stack {
    char [] brackets;
    int size;
    public Stack() {
        brackets = new char[10];
        size = 0;

    }
    public void push(char bracket) {
        if(isfull()){
            brackets = Arrays.copyOf(brackets,brackets.length*(2));
        }
        brackets[size++] = bracket;

    }
    public char pop() {
        return brackets[--size];

    }
    public boolean isempty() {
        return size == 0;
    }
    public char gettop() {
        return brackets[size - 1];
    }
    public boolean isfull(){
        return size==brackets.length;
    }

}