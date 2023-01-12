package Array;

/**
 * 
 * 
 * @author Vishal time complexity:O(n*d)
 */

public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 5, 6, 1, 2, 3, 9, 8 };// data

		int[] ar = rotate(arr, 2, arr.length);
		for (int i : ar)
			System.out.println(i);

	}

	private static int[] rotate(int[] arr, int d, int length) {
		// TODO Auto-generated method stub
		for (int i = 0; i < d; i++)
			leftrotate(arr, length);

		return arr;
	}

	private static void leftrotate(int[] arr, int length) {
		// TODO Auto-generated method stub
		int temp = arr[0];
		int i;
		for (i = 0; i < length - 1; i++)
			arr[i] = arr[i + 1];

		arr[i] = temp;
	}

}
