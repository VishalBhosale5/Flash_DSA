package Array;

/**
 * Kadane’s Algorithm:
 * O(n)
 * @author USER
 *
 */

public class LargestSumContegiousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  arr= {1,-2,3,4,-4,6,-4,3,2};
		
		System.out.println(csum(arr,arr.length));

	}

	private static int csum(int[] arr, int length) {
		
		int max=0,maxend=0;
		for(int i=0;i<length;i++)
		{
			maxend=maxend+arr[i];
			
			if(maxend<0)
				maxend=0;
			else if(max<maxend)   //optimization if maxend>0 then only check this condition
				max=maxend;
			
			
		}
		
		return max;
	}

}
