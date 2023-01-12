package Searching;

/**
 * 
 * @author Vishal Bhosale Linear search time complexity=O(n)
 *
 */
public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 3, 55, 22, 44, 66, 77, 55 };
		System.out.println(search(ar, 226));

	}

	public static int search(int[] ar, int key) {
		int found = -1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == key)
				return i;

		}
		return found;

	}
}
