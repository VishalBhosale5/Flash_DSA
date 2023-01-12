package Recursion;

public class Searchandreturnlastindex {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int []ar= {5,4,8,6,8,8,8};
			//checksorted(ar,0);
			System.out.println(indexreturn(ar, 0,5));
	}

	private static int indexreturn(int[] ar, int i,int data) {
		
		if(i==ar.length)
			return -1;
		
		int index=indexreturn(ar, i+1, data);
		if(index==-1)
		{
			if(ar[i]==data)
				return i;
			else
				return index;
			
		}
		else
		{
			return index;
		}
		
		
	}

}
