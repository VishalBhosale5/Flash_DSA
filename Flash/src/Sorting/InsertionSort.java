package Sorting;
/**
 * 
 * average and worst case time complexity:O(n2)
 * best case O(n)
 * @author USER
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 6, 4, 9,10,99,55,6666,78,33,0,-9};
		insertionsortt(arr, arr.length);
		for (int i : arr)
			System.out.println(i);
	}

	/*private static void insertionSort(int[] arr, int length) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<length;i++)
		{
			int value=arr[i];
			int hole=i;
			while(hole>0 && arr[hole-1]>value)
			{
				
				arr[hole]=arr[hole-1];
				hole--;
			}
			
			arr[hole]=value;
			
		}
		
	}*/
	
	
	public static void insertionSort(int[] ar,int l)
	{
		int temp,j;
		for(int i=1;i<=l;i++)
		{
			 temp=ar[i];
			
			for(j=i;j>0 && temp<ar[j-1];j--)
			{
				
					
					ar[j]=ar[j-1];
					
				
				
			}
			ar[j]=temp;
		}
		
		
		
	}
	
	
	private static void insertionSort1(int[] arr, int length) {
	
	for(int i=1;i<length;i++)
	{
		int value=arr[i];
		int hole=i;
		while(hole>0 && arr[hole-1]>value)
		{
			
			arr[hole]=arr[hole-1];
			hole--;
		}
		
		arr[hole]=value;
		
	}
	
}
	


	//cosingbloc
	
	public static void insertionsortt(int[] ar,int len)
	{
	for(int i=1;i<len;i++)
	{
		int val=ar[i];
		int j=i;
		while(j>0 && ar[j-1]>val)
		{
			ar[j]=ar[j-1];
			j--;
		}
		
		ar[j]=val;
		
		
		
	}
	
	
	}

}
