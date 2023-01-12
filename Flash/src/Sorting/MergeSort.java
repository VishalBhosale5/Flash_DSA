package Sorting;

/**
 * O(nlogn) m+n=O(m+n) notation for merge
 * 
 * @author USER not in-place sorting algorithm as it required O(n) space
 *         complexity and not constant time
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -3, 5, -6, 4, 9, 0 };
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(" "+i);
	}

	private static void mergeSort(int[] arr, int[] tempar, int lowerindex, int upperindex) {

		if (lowerindex >= upperindex) {
			return;
		}

		// divide code
		int mid = (lowerindex + upperindex) / 2;
		mergeSort(arr, tempar, lowerindex, mid);
		mergeSort(arr, tempar, mid + 1, upperindex);

		// merge code
		int l = lowerindex;
		int ls = mid;
		int us = mid + 1;
		int ust = upperindex;
		int count = lowerindex;  //make sure it is lower and not the 0

		while (l <= ls && us <= ust) {

			if (arr[l] < arr[us]) {
				tempar[count++] = arr[l++];
			} else
				tempar[count++] = arr[us++];

		}

		while (l <= ls)
			tempar[count++] = arr[l++];

		while (us <= ust)
			tempar[count++] = arr[us++];

		for (int i = lowerindex; i <= upperindex; i++)  //make sure to use lower and higher instead of i=0 and i<ar.length
			arr[i] = tempar[i];

	}
	 

	
}
