package Array;


/**
 * Index array Time complexity=O(n)
 * space complexity=O(n)
 * developed by vishal
 * @author USER
 *
 */
public class IndexArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8,-1,6,1,9,3,2,7,4,-1 };
		for (int i : indexar(arr,arr.length))
		{
			if(i==0)
			System.out.print(-1+" ");
			else
				System.out.print(i+" ");
		}

	}
	
	
	public static int[] indexar(int[] a,int length)
	{
		int[] arrr=new int[length];

		for(int i=0;i<length;i++) {
			
			if(a[i]<length && a[i]>=0)
			arrr[a[i]]=a[i];
		

				
				
		}
		
		return arrr;
		
	}

}
