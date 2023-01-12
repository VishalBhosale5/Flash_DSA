
public class PartitionByRange {
	
	public static void main(String[] args) {
		int ar[]= {8,9,55,44,33,89,9,76,2,1,5};
		
		partitionbyrange(ar,ar.length,25,50);
		for(int i:ar)
			System.out.print(" "+i);
	}
	
	public static void partitionbyrange(int[] ar,int length,int l,int h)
	{
		
		
		
		int i=0,left=0,right=length-1;
		
		while(i<=right)
		{
			
			if(ar[i]<=l)
			{
				swap(ar,i,left);
				i++;
				left++;
			}
			else if(ar[i]>=h)
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
