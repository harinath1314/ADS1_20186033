/**
 * hashing with chaing problem.
 * this hasing is done to improve the complexity of instead.
 * of usinf RB BST the complexity of hashing with chaining is log N.
 * the hashing has no ordered operations.
 * author harinatha reddy
 * date 25/10/18
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for hash table.
 */
class HashTable {
    /**
     * Class for node.
     */
    class Node {
        /**
         * word as key.
         */
        private String key;
        /**
         * count as value.
         */
        private Integer val;
        /**
         * next node.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         * @param      n     { parameter_description }
         */
        Node(final String k, final Integer v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**
         * retunrs key.
         *
         * @return     { description_of_the_return_value }
         */
        String getkey() {
            return this.key;
        }
        /**
         * Gets the value.
         *
         * @return     The value.
         */
        Integer getValue() {
            return this.val;
        }
        /**
         * sets value.
         *
         * @param      v     { parameter_description }
         */
        void setvalue(final Integer v) {
            this.val = v;
        }
    }
    /**
     * nodes table.
     */
    private Node[] st;
    /**
     * size.
     */
    private int s = (2 * (2 + 2 + 1)) * (2 * (2 + 2 + 1));
    /**
     * Constructs the object.
     */
    HashTable() {
        st = new Node[s];
    }
    /**
     * hash.
     * this generaetes a hash value for the key.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    int hash(final String k) {
        return (k.hashCode() & 0x7fffffff) % s;
    }
    /**
     * resizes.
     */
    public void resize() {
        st = Arrays.copyOf(st, 2 * s);
    }
    /**
     * insert method.
     * complexity of insert method is log N in average and worst CASE.
     *
     * @param      k     { parameter_description }
     * @param      v     { parameter_description }
     */
    public void insert(final String k, final Integer v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(x.getValue() + 1);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    /**
     * search method return the key value from th earray.
     * the comlexity of search is typically 3-5 in average case
     * the comlexity of search is typically log N in worst case.
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean search(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
/**
 * Solution class.
 */
final class Solution {
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] words = sc.nextLine().split(" ");
        HashTable h = new HashTable();
        for (int i = 0; i < m; i++) {
            h.insert(magazine[i], 1);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!h.search(words[i])) {
                flag = false;
                System.out.println("No");
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
    }
}
