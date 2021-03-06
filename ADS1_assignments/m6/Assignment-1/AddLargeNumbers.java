import java.util.Scanner;
import java.util.Iterator;
import java.util.Stack;
/**
 * Class for adding large numbers.
 */
public final class AddLargeNumbers {
    /**
     * for check style.
     */
    private AddLargeNumbers() {

    }
    /**
     * numbertoDigits converts number to linked lists.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList<String> p = new LinkedList<>();
        String st = number;
        String[] numString = st.split("");
        for (String each : numString) {
            p.addAtTail(each);

        }
        return p;
    }

    /**
     * digits to numbers function converts the linked list to a string.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    static String r = "";
    /**
     * digits to number are converted here from linked list.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        for (Iterator<String> c = list.iterator();
            c.hasNext();
                System.out.print((c.next())));
        return r;

    }
    /**
     * this function adds two linked lists.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        Stack<Integer> one = new Stack<Integer>();
        Stack <Integer>two = new Stack<Integer>();
        LinkedList three = new LinkedList();
        for (Iterator<String> pr = list1.iterator();
            pr.hasNext();
                one.add(Integer.parseInt(pr.next())));
        for (Iterator<String> hr = list2.iterator();
            hr.hasNext();
                two.add(Integer.parseInt(hr.next())));
        // three.add(Integer.parseInt(one.pop())+Integer.parseInt(two.pop()));
            String[] crazy;
        String carry="0";
            while(!one.empty() && !two.empty()){
                crazy = String.valueOf((one.pop()+two.pop())+Integer.parseInt(carry)).split("");
                if(crazy.length == 2){
                    three.addAtHead(crazy[1]);
                    carry= crazy[0];

                }else{
                    three.addAtHead(crazy[0]);
                    carry=String.valueOf(0);
                }
            }
            while(!one.empty()){
                three.addAtHead(String.valueOf(one.pop()+Integer.parseInt(carry)));
                carry = "0";
            }
            while(!two.empty()){
                three.addAtHead(String.valueOf(two.pop()+Integer.parseInt(carry)));
                carry = "0";
            }

            if(!carry.equals("0")){
                three.addAtHead(carry);
            }

        return three;

    }

}

