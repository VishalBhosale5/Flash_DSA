package Array;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10;
		int b=16;
		
		System.out.println(GCD(a,b));

	}
	
	public static int GCD(int a,int b)
	{
		if(a>b)
			return GCD(a-b,b);
		else if(b>a)
			return GCD(a,b-a);
		else
			return a;
	}

}
