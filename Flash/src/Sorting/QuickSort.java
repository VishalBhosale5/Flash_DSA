package Sorting;


/**
 * fast and efficient
 * average case O(nlogn)
 * O(n2) in worst case
 * In place sorting algorithm having constant memory space for sorting
 * @author USER
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 802, 7, 6, 5, 4, -3, -2, 1, 101 };
		Quicksort(arr, 0,8);
		for (int i : arr)
			System.out.println(i);
	}
	
	private static void Quicksort(int[] arr, int low, int high) {
		// TODO
		if (low < high) {
			int j = partition(arr, low, high);
			Quicksort(arr, low, j-1 );
			Quicksort(arr, j + 1, high);
		}

	}

	private static int partition(int[] arr, int low, int high) {
		// TODO

		int pivot = arr[low];
		int i = low, j = high;
try
{
		while (i < j) {
			while (i<j && arr[i] <= pivot)
				i++;

			 while (arr[j] > pivot)
				 j--;

			if (j > i) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
}catch(Exception e) {
	e.printStackTrace();
}
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;

		return j;
	}
  
  }
	
	
/*	public static void quickSort(int[] ar,int l,int h)
	{
		
		
		
		if(l<h)
		{
			int p=partition(ar,l,h);
			quickSort(ar, l, p-1);
			quickSort(ar, p+1, h);
			
			
		}
	}


	private static int partition(int[] ar, int l, int h) {
		// TODO Auto-generated method stub
		int pivot=ar[l];
		int pindex=l;
		while(l<h)
		{
			do
			{
				l++;
			}while(ar[l]<pivot);
			
			do
			{
				h--;
			}while(ar[h]>=pivot);
			
			
			int temp=ar[l];
			ar[l]=ar[h];
			ar[h]=temp;
		}
		int t=ar[pindex];
		ar[pindex]=ar[h];
		ar[h]=pivot;
		return h;
	}
	*/

	/*private static void Quicksort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int j = partition(arr, low, high);
			Quicksort(arr, low, j - 1);
			Quicksort(arr, j + 1, high);
		}

	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub

		int pivot = arr[high];
		int pindex = low;
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot)  {
					int temp = arr[i];
					arr[i] = arr[pindex];
					arr[pindex] = temp;
					pindex++;

				}
			}


		int temp = arr[pindex];
		arr[pindex] = arr[high];
		arr[high] = temp;

		return pindex;
	}*/



// abdul bari


	