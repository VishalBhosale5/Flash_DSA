package Recursion;

public class Patternusingrecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pattern(5,1,1);

	}
//with for loop
	private static void printpattern(int i,int count) {
		
		
		if(i!=0)
		{
		int st=count;
		while(st>0)
		{
			System.out.print("*");
			st--;
		}
		System.out.println();
		
		printpattern(i-1, count+1);
		}
		

	}
	
	//without for loop
	private static void pattern(int N,int row,int col) {
		System.out.println("call: ("+N+","+row+","+col+")");
		
		if(row>N)
			return;
		
		if(col>row)
		{
			System.out.println();
			pattern(N, row+1, 1);
			return;
			
		}
		System.out.print("*");
		pattern(N, row, col+1);
		

	}

}
