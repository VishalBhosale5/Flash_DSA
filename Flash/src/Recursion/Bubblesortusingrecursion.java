package Recursion;

import java.util.Arrays;

public class Bubblesortusingrecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] ar= {5,4,3,2,1};
bubbleC(ar,0,ar.length-1);
System.out.println(Arrays.toString(ar));
	}

	private static void bubblesort(int[] ar, int length) {
		for(int i=0;i<length-1;i++)
		{
			for(int j=0;j<ar.length-1-i;j++)
			{
				if(ar[j]>ar[j+1])
				{
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		
	}
	
	
//my way 	
	public static void bubble(int[] ar,int i,int count)
	{
		
		if(i==ar.length-1)
		{
			i=0;
			count++;
		}
		
		if(count==ar.length)
			return;
	
		if(ar[i]>ar[i+1])
		{
			int temp=ar[i];
			ar[i]=ar[i+1];
			ar[i+1]=temp;
			
		}
		
		
		bubble(ar, i+1,count);
		
		
		
	}
	
	//more efficient way 
	public static void bubbleC(int[] ar,int i,int lastindex)
	{
		
		if(lastindex==0)
		{
			return;
		}
		
		if(i==lastindex)
		{
			bubbleC(ar, 0, lastindex-1);
			return;
		}
		if(ar[i]>ar[i+1])
		{
			int temp=ar[i];
			ar[i]=ar[i+1];
			ar[i+1]=temp;
			
		}
		
		
		bubbleC(ar, i+1,lastindex);
		
		
		
	}


}
