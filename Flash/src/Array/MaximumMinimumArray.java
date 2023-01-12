package Array;
/**
 * time complexity O(n)
 */
import java.util.Arrays;

public class MaximumMinimumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {5,4,6,3,2,1,7};
		Arrays.sort(arr);
		for(int i:arr)
			System.out.print(i+" ");
		
		System.out.println();
		reverse(arr);
		
		MaxMinForm(arr, arr.length);
	

	}
	
	public static void MaxMinForm(int[] a,int length)
	{
		int i,j;
		for(i=0,j=length-1;i<=j; i++,j--)
		{
			System.out.print(a[i]+" "+a[j]+" ");
			
		}
	}
	
	public static void reverse(int[] a)
	{
		
		for(int i=0,j=a.length-1;i<j;i++,j--)
		{
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}

}
