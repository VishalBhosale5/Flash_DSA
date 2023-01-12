package Hashing;

import java.util.HashMap;

public class CheckSubArrayWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] inp= {3, 2, 3, 1, 6};
		
		System.out.println("Subarray with zero sum is present in array:"+isContain(inp));
		

	}

	
	
	
	/*
	 * the idea is P[j]-P[i]+ar[i]  will be the subarray sum
	 * p[j]-p[i]==sum[i+1,j]
	 * if the prefix sum is already present then it means the numbers in between are with 0 sum
	 */
	private static boolean isContain(int[] inp) {
		
		HashMap<Integer, Boolean> map=new HashMap<>();
		
		int prefixsum=0;
		for(int i=0;i<inp.length;i++)
		{
			
			prefixsum=prefixsum+inp[i];
			
			if(prefixsum==0 || map.containsKey(prefixsum))
				return map.get(prefixsum);
			
			map.put(prefixsum, true);
			
		}
		
		return false;
	}

}
