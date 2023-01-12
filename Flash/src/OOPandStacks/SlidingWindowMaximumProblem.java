package OOPandStacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class SlidingWindowMaximumProblem {
public static void main(String[] args) {
	
	int[] ar= {1,3,1,2,0,5};
	printGreatorRight(ar,3);
	
}




//public int[] findMaxinSlidingWindow(int[] ar)
///{
	






//}

private static void printGreatorRight(int[] ar,int k) {
	// TODO Auto-generated method stub
	Stack<Integer> s=new Stack<>();
	int[] ans=new int[ar.length];
	
	//need to reverse the output
	
	for (int i = ar.length-1; i>=0; i--) {
		
		
		if(s.isEmpty())
			ans[i]=ar.length;
		else if(!s.isEmpty() && ar[s.peek()]>ar[i])
		{
			
			ans[i]=s.peek();
		}
		else if(!s.isEmpty() && ar[s.peek()]<=ar[i])
		{
			while(!s.isEmpty() && ar[s.peek()]<=ar[i])
			{
				s.pop();
			}
			if(s.isEmpty())
				ans[i]=ar.length;
			else
				ans[i]=s.peek();
			
			
		}
		
		s.push(i);
		
	}
	
	System.out.println(Arrays.toString(ans));
	
	
	for(int i=0;i<=ar.length-k;i++)
	{
		int j=i;
		
		while(ans[j]<i+k)
		{
			j=ans[j];
		}
		
		System.out.println(ar[j]);
	}
	
	
	
	
	
}










}