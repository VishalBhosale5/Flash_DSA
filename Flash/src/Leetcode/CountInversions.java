package Leetcode;

/**
 * this problem uses merge sort technique to count inversions
 * time complexity :O(nlogn)   for merge sort space:O(n)
 * @author USER
 *
 */

public class CountInversions {
	static int reversecount=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar= {8,4,2,1};
		int temp[]=new int[ar.length];
		mergeSort(ar, temp, 0, ar.length-1);
		
		for(int i:ar)
		{
			System.out.print(i+" ");
		}
		System.out.println("reversecount:"+reversecount);
	}

	
	public static void mergeSort(int[] ar,int[] temp,int lower,int higher)
	{
		
	if(lower>=higher)
		return;
	
	
	int mid=(lower+higher)/2;
	
	mergeSort(ar, temp, lower, mid);
	mergeSort(ar, temp, mid+1, higher);
	
	int ls=lower;
	int lst=mid;
	int us=mid+1;
	int ust=higher;
	
	
	int count=lower;  //make sure it should not be 0 here
	while(ls<=lst && us<=ust)
	{
		if(ar[ls]<ar[us])
		{
			temp[count++]=ar[ls++];
			reversecount+=((ust+1)-us);


		}
		else
		{
			temp[count++]=ar[us++];
			reversecount+=((lst+1)-ls);

		}
		
		
	}
	
	while(ls<=lst)
		temp[count++]=ar[ls++];
	
	while(us<=ust)
		temp[count++]=ar[us++];
	
	for (int i = lower; i <=higher ; i++) {
		
		ar[i]=temp[i];
		
		
		
	}
		
		
		
		
		
	}
	
	
}
