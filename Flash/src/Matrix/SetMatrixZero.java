package Matrix;

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ar[]= {{1,1,1},{1,0,1},{1,1,1}};
		
	display(ar);
		
		/**
		 * 0 0 0
		 * 1 0 1
		 * 0 0 0
		 */
	
	boolean fr=false;
	boolean fc=false;
	
	for (int i = 0; i < ar.length; i++) {
		if(ar[0][i]==0)
			fr=true;
		
	}
	for (int i = 0; i < ar.length; i++) {
		if(ar[i][0]==0)
			fc=true;
		
	}
		
		int rl=ar.length,cl=ar[0].length;
		
		for (int i = 1; i < rl; i++) {
			for (int j = 1; j <cl; j++) {
				if(ar[i][j]==0)
				{
					ar[0][j]=0;
					ar[i][0]=0;
				}
			}
			
		}
		
		
		for (int i = 1; i < rl; i++) {
			for (int j = 1; j <cl; j++) {
				if(ar[0][j]==0 || ar[i][0]==0)
				{
					ar[i][j]=0;
				}
			}
			
		}
		
		if(fr)
		{
		for (int i = 0; i < ar.length; i++) {
			ar[0][i]=0;
		}
		}
		if(fc)
		{
		for (int i = 0; i < ar.length; i++) {
			ar[i][0]=0;
		}
		}
		
		System.out.println();
		display(ar);


	}
	
	public static void display(int ar[][])
	{
		for(int[] i:ar)
		{
			for(int j:i)
			{
				System.out.print(j+" ");
			}
			System.out.println();
			
			
		}
	}


}
