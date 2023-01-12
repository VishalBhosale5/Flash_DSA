


public class Question {

	public static int swapOddEvenBits(int x) { 
		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) ); 
	}
	
	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + Integer.toBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(0xaaaaaaaa));
	}

}