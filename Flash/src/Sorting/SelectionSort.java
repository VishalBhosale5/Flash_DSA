package Sorting;

/**
 * Selection sort time complexity:O(n2)
 * 
 * @author Vishal Bhosale
 *
 */
public class SelectionSort {

	public static void main(String args[]) {

		int[] arr = { 11, 41, 5, 6, 9, 8,0,-33 };
		selectionsortt(arr);
		for (int i : arr)
			System.out.println(i);

	}

	private static void selectionsort(int[] arr, int length) {
		// TODO Auto-generated method stub

		for (int i = 0; i < length; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

	}
	
	
	
	public static void selectionsortt(int[] ar)
	{
		
		
		
		for(int i=0;i<ar.length-1;i++)
		{
			
			int min=i;
			
			for(int j=i+1;j<ar.length;j++)
			{
				if(ar[min]>ar[j])
				{
					min=j;
					
				}
			}
			int temp=ar[min];
			ar[min]=ar[i];
			ar[i]=temp;
			
		}
	}
	
	


}
