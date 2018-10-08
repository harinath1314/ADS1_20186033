/**
 * Solution to find given array is a minheap or not.
 * author : harinath reddy
 * date : 08/11/18.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for minheap.
 */
class Minheap {
    /**
     *
     * @param      array     comparable array.
     *
     * @return     True if heap, False otherwise.
     */
    public boolean isHeap(final Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            if (2 * i + 1 < array.length && 2 * i + 2 < array.length) {
                if (array[i].compareTo(array[2 * i + 1]) > 0
                        || array[i].compareTo(array[2 * i + 2]) > 0) {
                    return (0 > 1);
                }
            }

        }
        return (1 > 0);
    }
}


/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        int nooftestcases = sc.nextInt();
        Minheap m = new Minheap();
        sc.nextLine();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.length() == 0) {
                System.out.println("false");
            } else {
                String[] input = line.split(",");
                switch (type) {

                case "Integer":
                    size = 0;
                    Integer[] intheap = new Integer[input.length];
                    for (int j = 0; j < input.length; j++) {
                        intheap[size++] = Integer.parseInt(input[j]);
                    }
                    System.out.print(m.isHeap(intheap));
                    System.out.println();
                    break;
                case "String":
                    size  = 0;
                    String[] stringheap = new String[input.length];
                    for (int j = 0; j < input.length; j++) {
                        stringheap[size++] = input[j];
                    }
                    System.out.print(m.isHeap(stringheap));
                    System.out.println();
                    break;
                case "Float":
                    size = 0;
                    Float[] floatheap = new Float[input.length];
                    for (int j = 0; j < input.length; j++) {
                        floatheap[size++] = Float.parseFloat(input[j]);
                    }
                    System.out.print(m.isHeap(floatheap));
                    System.out.println();
                    break;
                case "Double":
                    size = 0;
                    Double[] doubleheap = new Double[input.length];
                    for (int j = 0; j < input.length; j++) {
                        doubleheap[size++] = Double.parseDouble(input[j]);
                    }
                    System.out.print(m.isHeap(doubleheap));
                    System.out.println();
                    break;
                default:
                    break;
                }
            }
        }
    }
}
