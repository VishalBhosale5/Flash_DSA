package Array;

public class Factorial {

	public static void main(String[] args) {
	//	 long n=10l;
		
		//System.out.println(factorial(n));
		//for(int i=1;i<=100;i++)
		//System.out.println(fact(i));
		
	}
	
	public static long factorial(long n)
	{
		if(n<=1)
			return 1;
		else
			return n*factorial(n-1);
		
	}
	
	public static int fact(int n)
	{
		
		if(n==0 || n==1)
			return 1;
		
		return fact(n-1)+fact(n-2);
		
	}
}
