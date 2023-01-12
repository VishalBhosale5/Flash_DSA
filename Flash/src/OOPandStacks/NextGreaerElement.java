package OOPandStacks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaerElement {
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
	int[] ar= {2,5,9,3,1,12,6,8,7};
	printGreatorRight(ar);
	printGreatorLeft(ar);
		//printGreatorLeft(ar);
		
	}

	private static void printGreatorRight(int[] ar) {
		// TODO Auto-generated method stub
		Stack<Integer> s=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<>();
		
		//need to reverse the output
		
		for (int i = ar.length-1; i>=0; i--) {
			
			
			if(s.isEmpty())
				ans.add(-1);
			else if(!s.isEmpty() && s.peek()>ar[i])
			{
				
				ans.add(s.peek());
			}
			else if(!s.isEmpty() && s.peek()<=ar[i])
			{
				while(!s.isEmpty() && s.peek()<=ar[i])
				{
					s.pop();
				}
				if(s.isEmpty())
					ans.add(-1);
				else
					ans.add(s.peek());
				
				
			}
			
			s.push(ar[i]);
			
		}
		
		
		Collections.reverse(ans);
		System.out.println(ans);
	}
		
		
		private static void printGreatorLeft(int[] ar) {
			// TODO Auto-generated method stub
			Stack<Integer> s=new Stack<>();
			
			ArrayList<Integer> ans=new ArrayList<>();

			
			for (int i =0;i< ar.length; i++) {
				
				
				if(s.isEmpty())
					ans.add(-1);
				else if(!s.isEmpty() && s.peek()>ar[i])
				{
					
					ans.add(s.peek());
				}
				else if(!s.isEmpty() && s.peek()<=ar[i])
				{
					while(!s.isEmpty() && s.peek()<=ar[i])
					{
						s.pop();
					}
					if(s.isEmpty())
						ans.add(-1);
					else
						ans.add(s.peek());
					
					
				}
				
				s.push(ar[i]);
				
			}
			//no need to reverse the output
			System.out.println(ans);
		}
		
		
		
		
		
		
		
		/*for (int i = 0; i < ar.length; i++) {
			
			
			
			if(s.isEmpty())
			{
				s.push(ar[i]);
			}
			else
			{
				if(s.peek()<ar[i])
				{
					while(!s.isEmpty())
					{
					System.out.println(ar[i]);
					s.pop();
					}
					s.push(ar[i]);
					
				}
				else
					s.push(ar[i]);
			}
			
		}
		
		
		while(!s.isEmpty())
		{
			s.pop();
			System.out.println(-1);
		}*/
	

}
