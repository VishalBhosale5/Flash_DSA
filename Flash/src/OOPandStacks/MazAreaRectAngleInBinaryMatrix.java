package OOPandStacks;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * 
 * time: O(row*col)
 * space: O(col)  for stack and arrays
 */
public class MazAreaRectAngleInBinaryMatrix {
	
	public static void main(String[] args) {
		int[] ar[]= {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
		System.out.println(MaxArea(ar));
	}

	private static int MaxArea(int[][] ar) {
	
		
		//1)calcute individual histogram
		int[] v1=new int[ar[0].length];
		for(int j=0;j<ar[0].length;j++)
		{
			v1[j]=ar[0][j];
		}
		System.out.println("----"+Arrays.toString(v1));
		int max=histogram(v1);
		
		
		for(int i=1;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				
				
				if(ar[i][j]==0)
				{
					v1[j]=0;
				}
				else
					v1[j]=v1[j]+ar[i][j];
			}
			System.out.println("----"+Arrays.toString(v1));
			max=Math.max(max,histogram(v1));
		}
		
		return max;
	}
	
	public static int histogram(int ar[])
	{
		ArrayList<Integer> nsr=NearestSmallerRight(ar);
		ArrayList<Integer>  nsl=NearestSmallerLeft(ar);
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<ar.length;i++)
		{
			
			int width=nsr.get(i)-nsl.get(i)-1;
			ans.add(ar[i]*width);
		}
		
		
		return Collections.max(ans);
		
	}
	
	
	public static ArrayList<Integer> NearestSmallerLeft(int[] ar)
	{
		
		Stack<Integer> st=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		
		for(int i=0;i<ar.length;i++)
		{
			
			
			while(!st.isEmpty() && ar[st.peek()]>=ar[i])
				st.pop();
			
			
			if(st.isEmpty())
				ans.add(-1);
			else
				ans.add(st.peek());
			
			
			st.push(i);
		}
		System.out.println("nsl "+ans);
		return ans;
		
	}
	
	public static ArrayList<Integer> NearestSmallerRight(int ar[])
	{
		Stack<Integer> st=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		
		for(int i=ar.length-1;i>=0;i--)
		{
			
			
			while(!st.isEmpty() && ar[st.peek()]>=ar[i])
				st.pop();
			
			
			if(st.isEmpty())
				ans.add(ar.length);
			else
				ans.add(st.peek());
			
			
			st.push(i);
		}
		
		Collections.reverse(ans);

		System.out.println("nsr "+ans);

		return ans;
		
		
	}

}
