package Recursion;

public class CheckifArraySorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int []ar= {3,4,5,6,7,10};
			//checksorted(ar,0);
			System.out.println(checksorted(ar, 0));
	}

	private static boolean checksorted(int[] ar, int i) {
		
		if(i==ar.length-1)
			return true;
		if(ar[i]>ar[i+1])
		{
			return false;
		}
		else
		{
			return checksorted(ar, i+1);
		}
		
	}

}
