/**
 * module 14.
 * assigmnet 14.2...
 * author harinatha reddy
 * date : 10-10-18
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for details.
 */
class Details {
    /**
     * name of the candiadate.
     */
    private String name;
    /**
     * date of birth of the candidate.
     */
    private String dob;
    /**
     * sub 1 masrks.
     */
    private int sub1;
    /**
     * sub2 marks.
     */
    private int sub2;
    /**
     * sub 3 marks.
     */
    private int sub3;
    /**
     * total marks obtained by the candidate.
     */
    private int total;
    /**
     * category ofthe candidate.
     */
    private String category;
    /**
     * Constructs the object.
     *
     * @param      nam     { parameter_description }
     * @param      date     { parameter_description }
     * @param      sb1    The s 1
     * @param      sb2    The s 2
     * @param      sb3    The s 3
     * @param      tot     { parameter_description }
     * @param      reservation    The rectangle
     */
    Details(final String nam, final String date, final int sb1,
            final int sb2, final int sb3,
            final int tot, final String reservation) {
        this.name = nam;
        this.dob = date;
        this.sub1 = sb1;
        this.sub2 = sb2;
        this.sub3 = sb3;
        this.total = tot;
        this.category = reservation;
    }
    /**
     * get name.
     *
     *Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get dob.
     *
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     *
     * @return     { description_of_the_return_value }
     */
    String getdob() {
        return this.dob;
    }
    /**
     * get s1.
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getsub1() {
        return this.sub1;
    }
    /**
     * get s2.
     *
     * @return     { description_of_the_return_value }
     */
    int getsub2() {
        return this.sub2;
    }
    /**
     * s3.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getsub3() {
        return this.sub3;
    }
    /**
     * total.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int gettotal() {
        return this.total;
    }
    /**
     * cat.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    String getcategory() {
        return this.category;
    }
    /**
     * get age.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getage() {
        int age = 0;
        final int year = 2018, days = 365, month = 30, ten = 10;
        String[] token = this.getdob().split("-");
        age += (year - Integer.parseInt(token[2])) * days;
        age += (ten - Integer.parseInt(token[1])) * month;
        age += Integer.parseInt(token[0]);

        return age;
    }
    /**
     * compare.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Details that) {
        if (this.gettotal() > that.gettotal()) {
            return 1;
        } else if (this.gettotal() < that.gettotal()) {
            return -1;
        } else {
            if (this.getsub3() > that.getsub3()) {
                return 1;
            } else if (this.getsub3() < that.getsub3()) {
                return -1;
            } else {
                if (this.getsub2() > that.getsub2()) {
                    return 1;
                } else if (this.getsub2() < that.getsub2()) {
                    return -1;
                } else {
                    if (this.getage() < that.getage()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }

    }
    /**
     * prints.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    String print() {
        return this.getname() + "," + this.gettotal() + ","
               + this.getcategory();
    }
}
/**
 * Class for heapsort.
 */
class Heapsort {
    /**
     * array.
     */
    private Details[] array;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      a     { parameter_description }
     * @param      n     { parameter_description }
     */
    Heapsort(final Details[] a, final int n) {
        array = a;
        size = n;
    }
    /**
     * sorts.
     * Best case: O(N)
     *  worst case: O(N)
     *  Average case: O(N)
     * @return     { description_of_the_return_value }
     */
    Details[] sort() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
        return array;
    }
    /**
     * swaps.
     *  Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void swap(final int i, final int j) {
        Details temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * heapifies.
     *  Best case: O(logN)
     *  worst case: O(logN)
     *  Average case: O(logN)
     * @param      n     { parameter_description }
     * @param      i     { parameter_description }
     */
    void heapify(final int n, final int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l].compareTo(array[largest]) < 0) {
            largest = l;
        }
        if (r < n && array[r].compareTo(array[largest]) < 0) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }
    /**
     * gets item.
     *
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    Details getitem(final int index) {
        return array[index];
    }
    /**
     * get size.
     *
     * Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    int getsize() {
        return size;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        ///function.
    }
    /**
     * contains.
     *
     * @param      arr   The arr
     * @param      val   The value
     * Best case: O(1)
     *  worst case: O(N)
     *  Average case: O(N)
     * @return     { description_of_the_return_value }
     */
    static boolean contains(final int[] arr, final int val) {
        for (int n : arr) {
            if (val == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int open = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        Details[] students = new Details[n];
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(",");
            students[i] = new Details(input[0], input[1],
                                      Integer.parseInt(input[2]),
                                      Integer.parseInt(input[2 + 1]),
                                      Integer.parseInt(input[2 + 2]),
                Integer.parseInt(input[2 + 2 + 1]), input[2 + 2 + 2]);
        }
        Heapsort heap = new Heapsort(students, n);
        students = heap.sort();
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].print());
        }
        System.out.println();
        for (int j = 0; j < open; j++) {
            System.out.println(students[j].print());
        }
        int[] indices = new int[bc + sc + st];
        int i = 0;
        for (int k = open; k < n; k++) {
            if (students[k].getcategory().equals("BC") && bc > 0) {
                indices[i++] = k;
                bc--;
            } else if (students[k].getcategory().
                       equals("SC") && sc > 0) {
                indices[i++] = k;
                sc--;
            } else if (students[k].getcategory().
                       equals("ST") && st > 0) {
                indices[i++] = k;
                st--;
            }
        }
        if (bc > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getcategory().equals("Open") && bc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        bc--;
                    }
                }
            }
        }
        if (sc > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getcategory().equals("Open") && sc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        sc--;
                    }
                }
            }
        }
        if (st > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getcategory().equals("Open") && st > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        st--;
                    }
                }
            }
        }
        Arrays.sort(indices);
        for (int k = 0; k < indices.length; k++) {
            System.out.println(students[indices[k]].print());
        }
    }
}
