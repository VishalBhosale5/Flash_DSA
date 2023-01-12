package Sorting;

/**
 * O(n+k)
 * n-length, k is range
 * @author USER
 *
 */

public class BucketSort {
	public static void main(String[] args) {
		int ar[] = { 2, 6, 4, 1, 5, 8, 1, 4, 6, 1 };
		bucketSort(ar, ar.length);

		for (int i : ar)
			System.out.print(" " + i);

	}

	public static void bucketSort(int[] ar, int l) {

		int[] s = new int[10];

		for (int i = 0; i < l; i++) {
			s[ar[i]]++;
		}

		for (int j : s)
			System.out.print(" " + j);
		System.out.println();
		int m = 0;

		for (int i = 0; i < s.length; i++) {
			int k = s[i];

			while (k > 0) {
				ar[m++] = i;
				k--;
			}
		}

	}
}
