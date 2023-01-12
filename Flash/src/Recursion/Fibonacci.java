package Recursion;

public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fibo(10));
	}

	private static int fibo(int i) {
		// TODO Auto-generated method stub
		
		if(i==0)
			return 0;
		
		if(i==1)
			return 1;
		
		
		return fibo(i-1)+fibo(i-2);
	}

}
