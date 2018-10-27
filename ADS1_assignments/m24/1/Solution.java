/**
 * assingment 24 Ads-1 week-4.
 * author harinatha reddy.
 * date: 27-10-18.
 */
import java.util.Scanner;
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
     * main method starts here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        LinearProbingHashST<String, Student> lphs = new
        LinearProbingHashST<String, Student>();
        for (int i = 0; i < input; i++) {
            String data = sc.nextLine();
            String[] stud = data.split(",");
            lphs.put(stud[0], new
                     Student(stud[1], Double.parseDouble(stud[2])));



        }
        int input2 = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < input2; j++) {
            String[] query = sc.nextLine().split(" ");

            switch (query[2]) {
            case"1":
                Student s = lphs.get(query[1]);
                if (s == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(s.getname());
                }
                break;
            case"2":
                s = lphs.get(query[1]);
                if (s == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(s.getmarks());
                }
                break;
            default:
                break;




            }

        }

    }
}
/**
 * Class for student.
 */
class Student {

    /**
     * varible of string type to describe the name.
     */
    private String name;
    /**
     * marks obtained by a student.
     */
    private Double marks;

    /**
     * Constructs the object for student class.
     *
     * @param      nameoS     The name
     * @param      mark    The marks
     */
    Student(final String nameoS, final Double mark) {
        this.name = nameoS;
        this.marks = mark;

    }
    /**
     * getter for student name.
     *
     * @return     student name.
     */
    public String getname() {
        return name;
    }
    /**
     * getter for marks of a student.
     *
     * @return     marks of a student.
     */
    public Double getmarks() {
        return marks;
    }
}
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * init capacity to resize.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * n no of  values.
     */
    private int n;
    /**
     * m is keys.
     */
    private int m;
    /**
     * keys array.
     */
    private Key[] keys;
    /**
     * values array.
     */
    private Value[] vals;


    /**
     * Initializes an empty symbol table.
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * hash to getnerate hash.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        final int has = 0x7fffffff;
        return (key.hashCode() & has) % m;
    }

    /**
     * resize function.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp = new
        LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value  symbol table, overwriting the old
     * value with the new value if the symbol  contains the specified key.
     * Deletes the specified key (and its associated value)  this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(" get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /**
     * Removes the specified key and its associated  this symbol table.
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("delte() s null");
        }
        if (!contains(key)) {
            return;
        }

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / (2 + 2 + 2 + 2)) {
            resize(m / 2);
        }

        assert check();
    }
    /**
     * check function.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {

        // check that hash table is at most 50% full
        if (m < 2 * n) {
            System.err.println("Hash table size m = "
                               + m + "; array size n = " + n);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < m; i++) {
            if (keys[i] == null) {
                continue;
            } else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = "
                                   + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }

}
