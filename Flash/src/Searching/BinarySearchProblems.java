package Searching;


/*
 * 
 * Whenever you see sorted array there you should try to apply binary search.
 */
public class BinarySearchProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = { 1, 3, 4, 10, 10, 10, 10, 15, 18 };
		// findFirstOccurance(ar,0,ar.length-1,10);
		System.out.println("first occurance of 10 is at index:" + findFirstOccurance(ar, 0, ar.length, 10));
		System.out.println("last occurance of 10 is at index:" + findLastOccurance(ar, 0, ar.length, 10));
		System.out.println("count of 10 in an array is :" + findCountofelement(ar, 0, ar.length, 10));

	}

	// find first occurance of element
	private static int findFirstOccurance(int[] ar, int start, int end, int ele) {
		// TODO Auto-generated method stub
		int temp = -1;
		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (ar[mid] == ele) {
				temp = mid;
				end = mid - 1;
			} else if (ele > ar[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return temp;

	}

	// find last occurance of element
	private static int findLastOccurance(int[] ar, int start, int end, int ele) {
		// TODO Auto-generated method stub
		int temp = -1;
		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (ar[mid] == ele) {
				temp = mid;
				start = mid + 1;
			} else if (ele > ar[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return temp;

	}
	//find the count of number in an sorted array
	private static int findCountofelement(int[] ar, int i, int length, int j) {
		int firstocc = findFirstOccurance(ar, i, length, j);
		int lastocc = findLastOccurance(ar, i, length, j);
		return lastocc - firstocc + 1;
	}

}
