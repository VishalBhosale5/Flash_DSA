package Searching;

public class BinarySearch {
	/**
	 *
	 * Binary search
	 * time O(logn)
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar= {1,2,3,4,5,6,7,99,3};  //array should be sorted
		System.out.println(bsearch(ar,0,ar.length-1,4));
	}
	
	public static int bsearch(int[] ar,int left,int right,int key)
	{
		
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			
			if(ar[mid]==key)
				return mid;
			else if(key>ar[mid])
				left=mid+1;
			else
				right=mid-1;			
		}
return -1;
	}

}

