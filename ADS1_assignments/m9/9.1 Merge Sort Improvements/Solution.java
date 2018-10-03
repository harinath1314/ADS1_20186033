/**
 * Solution for merge sort.
 * author : harinath reddy
 * date: 3/10/18
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class.
 */
public final class Solution {
	/**
	 * for check style.
	 */
	private Solution() {

	}
	/**
	 * main method starts here.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String arrayinput = input.nextLine();

			Mergesort m = new Mergesort(arrayinput);
			System.out.println(Arrays.toString(m.merge()));

		}

	}
}
/**
 * Class for mergesort.
 */
class Mergesort {
	/**
	 * comparable array a.
	 */
	private String[] a;
	private int[] b;
	/**
	 * comparable array aux.
	 */
	private int[] aux;
	/**
	 * variavble low.
	 */
	private int low;
	/**
	 * variable high.
	 */
	private int high;
	/**
	 * variable mid.
	 */
	private int mid;

	/**
	 * Constructs the object for class Mergesort.
	 *
	 * @param      aa      { parameter_description }
	 * @param      auxx    The auxx
	 * @param      lower   The lower
	 * @param      higher  The higher
	 * @param      middle  The middle
	 */
	Mergesort(final String data) {
		b=new int[a.length];
		this.a = data.split(",");
		for (int i = 0; i < a.length; i++) {
			b[i] = Integer.parseInt(a[i]);
		}
		this.aux = new int[b.length];
		this.low = 0;
		this.high = b.length;
		this.mid = (low+high)/2;

	}
	/**
	 * getaa is getter for a.
	 *
	 * @return      comparable type.
	 */
	public int[] getaa() {
		return b;
	}
	/**
	 * getter for aux.
	 *
	 * @return      comparable type.
	 */
	public int[] getaux() {
		return aux;
	}
	/**
	 * getter for low.
	 *
	 * @return      int type.
	 */
	public int getlow() {
		return low;
	}
	/**
	 * getter for high.
	 *
	 * @return      int type.
	 */
	public int gethigh() {
		return high;
	}
	/**
	 * getter for mid.
	 *
	 * @return      int type.
	 */
	public int getmid() {
		return mid;
	}
	// public boolean compareTo(int a , int aux) {
	// 	return true;

	// }
	public int[] merge() {
		assert isSorted(b, low, mid) : "Test whether the array is already in order";
		assert isSorted(b, mid + 1, high) : "Test whether the array is already in order";

		for (int k = low; k <= high; k++) {
			aux[k] = b[k];

		}
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) b[k] = aux[j++];
			else if (j > high) b[k] = aux[i++];
			else if (less(aux[j] , aux[i])) b[k] = aux[j++];
			else 							b[k] = aux[i++];
		}
		return b;

	}

	public boolean isSorted(int[] one, int low, int high) {
		return true;
	}
	public boolean less(int one, int two){
		return true;
	}

}







// class Insertion{----------------------------------------------------------------------------------------------------------------------------------------------------------
// 	public void insertionsort() {
//         for (int i = 0; i < size; i++) {
//             for (int j = i; j > 0; j--) {
//                 if (teamlist[j].compareTo(teamlist[j - 1]) == 1) {
//                     swap(teamlist, j, j - 1);
//                 } else {
//                     break;
//                 }
//             }
//         }
//     }
// }
// ----------------------------------------------------------------------------------------------------------------------------------------------------------