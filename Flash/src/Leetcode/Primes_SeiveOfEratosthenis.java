package Leetcode;

import java.util.Arrays;

public class Primes_SeiveOfEratosthenis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SOE(25);  //print prime numbers till n
	}

	
	//O(nloglogn)     less than O(nlogn)
	private static void SOE(int n) {
		// TODO Auto-generated method stub
		
		boolean[] prime=new boolean[n+1];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		
		
		
		for(int table=2;table*table<=n;table++)
		{
			
			if(prime[table]==false)
				continue;
			
			for(int multi=2;multi*table<=n;multi++)
			{
				prime[table*multi]=false;
			}
		}
		
		for(int i=0;i<=n;i++)
		{
			if(prime[i])
				System.out.println(i);
		}
		
	}

}
