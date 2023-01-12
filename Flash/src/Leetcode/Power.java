package Leetcode;

public class Power {
	public static void main(String[] args) {
		System.out.println(power(2,5));
	}

	
	//general power funtion takes O(n) time but with this we are mking efficient to O(logn)
	private static int power(int i, int j) {
		// TODO Auto-generated method stub
		
		
		if(j==0)
			return 1;
		
		int pnb2=power(i,j/2);
		if(j % 2==1)
		{
			return pnb2*pnb2*i;
		}
		else
			return pnb2*pnb2;
			
	}

}
