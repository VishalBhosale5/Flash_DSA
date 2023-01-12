package Recursion;

import java.util.Arrays;

public class Allindicesofelementfromarray {
	static int index=0;
	static int[] n= {-1,-1,-1,-1,-1};
	public static void main(String[] args) {
	int[] ar= {1,2,8,4,5,8,5,6,8};
	returnindices(ar, 0, 8);
	for(int j:n)
	{
		System.out.println(j);
	}

	}

	private static void returnindices(int[] ar, int i,int data) {
		// TODO Auto-generated method stub
		
		if(i<ar.length)
		{
		if(ar[i]==data)
		{
			n[index++]=i;
		}
		returnindices(ar, i+1, data);
		}
		
	
	}

}
