package Leetcode;

public class DutchNationalFlag012 {

	
		//Dutch national flag algorithm to sort using 2 pointers
	//time: O(n)  space:O(1)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ar= {0,2,1,1,0,0,2,1,0};
		sort(ar);
		for(int i: ar)
		System.out.println(i);

	}

	private static void sort(int[] ar) {
		// TODO Auto-generated method stub
		
		int low=0, mid=0;int high=ar.length-1;
		
		while(mid<=high)
		{
			if(ar[mid]==0)
			{
				swap(ar,mid,low);
				low++;
				mid++;
			}else if(ar[mid]==1)
			{
			mid++;
			}
			else
			{
				swap(ar,mid,high);
				high--;
			}
		}
		
	}

	private static void swap(int[] ar,int i, int j) {
		// TODO Auto-generated method stub
		int temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
	}

}
