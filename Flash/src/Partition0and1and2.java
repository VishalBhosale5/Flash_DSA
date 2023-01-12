
public class Partition0and1and2 {
	
	public static void main(String[] args) {
		int ar[]= {0,2,1,1,2,2,0,0,2,1};
		
		partition2(ar,ar.length);
		for(int i:ar)
			System.out.print(" "+i);
	}
	
	public static void partition2(int[] ar,int length)
	{
		
		
		
		int i=0,left=0,right=length-1;
		
		while(i<=right)
		{
			
			if(ar[i]==0)
			{
				swap(ar,i,left);
				i++;
				left++;
			}
			else if(ar[i]==2)
			{
				swap(ar,i,right);
				right--;
			}
			else
				i++;
			
		}
	}
	
	public static void swap(int[] ar,int a,int b)
	{
		int temp=ar[a];
		ar[a]=ar[b];
		ar[b]=temp;
	}

}
