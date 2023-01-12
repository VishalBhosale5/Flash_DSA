package OOPandStacks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
public class NextSmallerElement {

	public static void main(String[] args) {
		int[] ar=new int[]{8, 4, 6, 2, 3};
		
		System.out.println(printNextSmaller(ar));

	}

	private static ArrayList<Integer> printNextSmaller(int[] ar) {
		
		ArrayList<Integer> ans=new ArrayList<>();
		
		Stack<Integer> st=new Stack<>();
		
		for(int i=ar.length-1;i>=0;i--)
		{
			if(st.isEmpty())
			{
				//st.push(ar[i]);
				ans.add(ar[i]);
			}
			else
			{
			while(!st.isEmpty())
			{
				if(st.peek()<=ar[i])
					break;
				else
					st.pop();
				
			}
			
			if(st.isEmpty())
				ans.add(ar[i]);
			else
				ans.add(st.peek());
			
			}
			
			st.push(ar[i]);
		}
		Collections.reverse(ans);
		return ans;
	}

}
