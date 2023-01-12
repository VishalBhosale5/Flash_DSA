package Sorting;

/**
 * Bubble sort time complexity:O(n2)
 * 
 * @author Vishalbhosle
 *
 */

public class BubbleSort {
	static boolean flag = true;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 88,77,66,55,44 };
		bubblesort1(arr);
		for (int i : arr)
			System.out.println(i);
		
	}

	private static void bubbleesort(int[] arr, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n - 1 && flag; i++) {
			flag=false;

			for (int j = 0; j < n - i - 1; j++) // efficient code as if no swap then no pass best case O(n)
			{

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag=true;
				}
			}

		}
	}
	
	public static void bubblesort1(int[] ar)
	{
		
	for(int i=0;i<ar.length-1;i++)
	{
		for(int j=0;j<ar.length-i-1;j++)
		{
			if(ar[j]>ar[j+1])
			{
				
				int temp=ar[j];
				ar[j]=ar[j+1];
				ar[j+1]=temp;
			}
		}
	}
	}

		
		
		
		
	

}
