package Array;
/**
 * Time complexity O(n)
 * avoid recursion over iteration due to stack overhead
 * @author USER
 *
 */

public class DecimalToHexadecimal {
	static String c="0123456789ABCDEF";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=12500;
decitohex(n);

	}
	
	public static void decitohex(int n)
	{
		
		char digit=(char)(n%16);
		
		n/=16;
		
		if(n!=0)
			decitohex(n);
		
		System.out.print(c.charAt(digit));
	}

}
