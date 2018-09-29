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
    // public static LinkedList addLargeNumbers
    // (LinkedList list1, LinkedList list2) {

    // }
}