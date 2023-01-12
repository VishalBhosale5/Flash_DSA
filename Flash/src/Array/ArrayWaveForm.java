package Array;

import java.util.Arrays;


/**
 * time complexity: O(nlogn)
 * @author USER
 *
 */
public class ArrayWaveForm {
	
	public static void main(String args[])
	{
		
		int[] ar= {10, 90, 49, 2, 1, 5, 23};
		waveform(ar,ar.length);
		for(int i:ar)
		System.out.print(i+" ");
		int[] arr= {10, 90, 49, 2, 1, 5, 23};
System.out.println();
		waveform2(arr,arr.length);
		for(int i:arr)
			System.out.print(i+" ");
	}

	private static void waveform(int[] ar, int length) {

		Arrays.sort(ar);
		
		for(int i=0;i<length-1;i+=2)
			swap(ar,i,i+1);
	}

	private static void swap(int[] ar, int i, int j) {
		// TODO Auto-generated method stub
		int temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
	}
	
	
	public static void waveform2(int[] a,int length)
	{
		for(int i=0;i<length-1;i+=2)
		{
			
			if(a[i]<a[i+1])
			{
				swap(a,i,i+1);
			}
			else if(a[i+1]>a[i+2])
				swap(a,i+1,i+2);
		}
		
	}

}
