import java.util.Comparator;
import java.util.Scanner;

/**
 * Class for selection.
 * author harinatha reddy
 * date 7/10/18.
 */

/**
 * Class for solution.
 */
class Student {
    /**
     * student name.
     */
    private String name;
    /**
     * student date of birth.
     */
    private String doB;
    /**
     * students sub1 marks.
     */
    private int sub1marks;
    /**
     * students sub3 marks.
     */
    private int sub2marks;
    /**
     * students sub3 marks.
     */
    private int sub3marks;
    /**
     * students total marks.
     */
    private int totalmarks;
    /**
     * student category.
     */
    private String reservation;
    /**
     * Constructs the object.
     */
    Student(String[] details) {
        this.name = details[0];
        this.doB = details[1];
        this.sub1marks = Integer.parseInt(details[2]);
        this.sub2marks = Integer.parseInt(details[2 + 1]);
        this.sub3marks = Integer.parseInt(details[2 + 2]);
        this.totalmarks = Integer.parseInt(details[2 + 2 + 1]);
        this.reservation = details[2 + 2 + 2];




    }

    /**
     * getter for student name.
     *
     * @return     name of the student.
     */
    public String getname() {
        return name;
    }
    /**
     * getter for students date of birth.
     *
     * @return     date of birth of student.
     */
    public String getdoB() {
        return doB;
    }
    /**
     * getter for student sub1 marks.
     *
     * @return     students sub1 marks.
     */
    public int getsub1marks() {
        return sub1marks;
    }
    /**
     * getter for student sub2 marks.
     *
     * @return     students sub2 marks.
     */
    public int getsub2marks() {
        return sub2marks;
    }
    /**
     * getter for student sub3 marks.
     *
     * @return     students sub3 marks.
     */
    public int getsub3marks() {
        return sub3marks;
    }
    /**
     * getter for student totoal  marks.
     *
     * @return     students totoal marks.
     */
    public int gettotalmarks() {
        return totalmarks;
    }
    /**
     * getter for students category.
     *
     * @return     student category.
     */
    public String getreservation() {
        return reservation;
    }
    public void settotal( int reserv){
            this.sub3marks = 0;
    }


}

public final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nofStu_Qual = input.nextInt();
        int nof_vacants = input.nextInt();
        int nof_UR = input.nextInt();
        int nof_BC = input.nextInt();
        int nof_SC = input.nextInt();
        int nof_ST = input.nextInt();
        int size = 0;
        Sorting s = new Sorting();
        Student[] students_arr = new Student[nofStu_Qual];

        input.nextLine();
        for (int i = 0; i < nofStu_Qual; i++) {
            String student_details = input.nextLine();
            String[] det_arr = student_details.split(",");
            Student student = new Student(det_arr);
            students_arr[size++] = student;



        }
        s.sort(students_arr);
        s.show(students_arr);
        System.out.println();
        s.sortreversation(students_arr);
        s.fillvacancies(students_arr, nof_vacants, nof_UR, nof_BC, nof_SC, nof_ST);





    }

}


class Sorting {
    Sorting() {

    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Student[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j].gettotalmarks(), a[min].gettotalmarks())) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }


    // is v < w ?
    private static boolean less(int v, int w) {
        return (v < w);
    }
    //ihere is the greatness.
    private static boolean less(String v, String w) {
        int one = Integer.parseInt(v.replaceAll("-",""));
        int two = Integer.parseInt(w.replaceAll("-",""));
        return one > two;






    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    // print array to standard output
    public void show(Student[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i].getname() + "," + a[i].gettotalmarks() + "," + a[i].getreservation());
        }
    }
    public void sortreversation(Student[] a){

        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if ((a[j].gettotalmarks() < a[min].gettotalmarks())) {
                    min = j;
                }else if((a[j].gettotalmarks() == a[min].gettotalmarks())){
                    if(a[j].getsub3marks() < a[min].getsub3marks()){
                        min = j;
                    } else if(a[j].getsub3marks() == a[min].getsub3marks()){
                        if(a[j].getsub2marks() < a[min].getsub2marks()){
                            min = j;
                        }else if(a[j].getsub2marks() == a[min].getsub2marks()){
                            if(a[j].getsub1marks() < a[min].getsub1marks()){
                                min = j;
                            }else if(a[j].getsub1marks() == a[min].getsub1marks()){
                                if(less(a[j].getdoB(), a[min].getdoB())) {
                                    min = j;
                                }
                            }
                        }
                    }
                }
            }
            exch(a, i, min);
        }

    }
    public void fillvacancies(Student[] a,int posts,int ur,int bc, int sc, int st){
            Student[] filled = new Student[posts];
                for (int j = a.length-1; j > a.length - 1-ur; j--) {
                        a[j].settotal(0);

                        System.out.println(a[j].getname()+","+ a[j].gettotalmarks()+","+a[j].getreservation());

                }
                
            // for (int i = 0; i< bc; i++) {
                int busy = 0;
                for (int j = a.length-1; j > 0; j--) {
                    if(busy == st){
                        break;
                    }
                    else if (a[j].getreservation().equals("ST") && (a[j].getsub3marks() != 0)) {
                        a[j].settotal(0);

                        System.out.println(a[j].getname()+","+ a[j].gettotalmarks()+","+a[j].getreservation());
                        busy++;
                    }

                }

            // }
            int busysc = 0;
                for (int j = a.length-1; j > 0; j--) {
                    if(busysc == sc){
                        break;
                    }
                    else if (a[j].getreservation().equals("SC") && (a[j].getsub3marks() != 0)){
                        a[j].settotal(0);

                        System.out.println(a[j].getname()+","+ a[j].gettotalmarks()+","+a[j].getreservation());
                        busysc++;
                    }

                }
            int busyst = 0;
                for (int j = a.length-1; j > 0; j--) {
                    if(busyst == bc){
                        break;
                    }
                    else if (a[j].getreservation().equals("BC") && (a[j].getsub3marks() != 0)){
                        a[j].settotal(0);

                        System.out.println(a[j].getname()+","+ a[j].gettotalmarks()+","+a[j].getreservation());
                        busyst++;
                    }

                }
                if((bc+sc+st) != posts) {

                }
    }


}


