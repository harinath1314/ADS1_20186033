/**
 * class Solution
 * autor : c harinatha reddy
 * date  : 27:9:18
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * class solution object constructor.
     */
    private Solution() {

    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.nextLine();
        while (input.hasNext()) {
            char[] brac = input.nextLine().toCharArray();
            System.out.println(isbalanced(brac));

        }


    }
    /**
     * is balanced function.
     *
     * @param      brac  The brac
     *
     * @return     { description_of_the_return_value }
     */
    public static String isbalanced(final char[] brac) {
        Stack s = new Stack();

        for (char each : brac) {
            if (each == '{' || each == '[' || each == '(') {
                s.push(each);
            } else {
                if (!s.isempty()) {
                    char top = s.gettop();
                    if ((top == '{' && each == '}')
                        || (top == '[' && each == ']')
                        || (top == '(' && each == ')')) {
                        s.pop();
                    } else {
                        return "NO";
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
/**
 * List of class.
 */
class Stack {
    /**
     * { var_description }.
     */
    char[] brackets;
    /**
     * .size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Stack() {
        brackets = new char[2+2+2+2+2];
        size = 0;

    }
    /**.
     * { function_description }
     *
     * @param      bracket  The bracket
     */
    public void push(final char bracket) {
        if (isfull()) {
            brackets = Arrays.copyOf(brackets, brackets.length * (2));
        }
        brackets[size++] = bracket;

    }
    /**.
     * .pop function
     *
     * @return     { description_of_the_return_value }
     */
    public char pop() {
        return brackets[--size];

    }
    /**
     * is empty function.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean isempty() {
        return size == 0;
    }
    /**
     * gettop function.
     *
     * @return     { description_of_the_return_value }
     */
    public char gettop() {
        return brackets[size - 1];
    }
    /**
     * isfull function.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean isfull() {
        return size == brackets.length;
    }

}
