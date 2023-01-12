package Leetcode;

import java.util.HashMap;

/**
 * 
 * 
 * https://leetcode.com/problems/two-sum/
 * 1)in brute force approach we traverse the array one by one an then check if 1st element is 2 then we search for target-2 number in entire array it takes 
 * O(n^2)  but we can improve it using hashmap  to 
 * time complexity:O(n) and space O(1)   as hashmap takes O(1) to insert and lookup
 * @author USER
 *
 */

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int target=13;
	int ar[]= {1,4,5,10,8};
	
	for(int i:twosum(ar,ar.length,target))
	{
		System.out.println(i);
	}

	}

	private static int[] twosum(int[] ar, int length,int target) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,Integer> m=new HashMap<>();
		int a=0,n=0;
		for (int i = 0; i < ar.length; i++) {
			
			if(m.containsKey(target-ar[i]))     //if it present then return the indexes else add it in hashmap
			{
				return new int[] {i,m.get(target-ar[i])};
			}
			else
				m.put(ar[i], i);
		}
		
		return new int[] {-1,-1};   //if not found then return -1 -1
		
	}

}
