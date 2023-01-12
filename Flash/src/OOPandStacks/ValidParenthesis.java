package OOPandStacks;
import java.util.HashMap;
import java.util.Stack;
public class ValidParenthesis {
	
	/*
	 * time :O(n)
	 * Space:O(n) for stack
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Character> s=new Stack<>();
		if(valid(s,"[][]()"))
			System.out.println("YES");
		else
			System.out.println("No");
		
		
		
		

	}
	
	
	public static boolean valid(Stack<Character> s,String str)
	{
		
		if(str.length()==0 || str.length()%2!=0)
			return false;
		
		HashMap<Character,Character> map=new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}','{');
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{') {
				s.push(str.charAt(i));
			}else
			{
				if(s.isEmpty() || s.peek()!=map.get(str.charAt(i)))
				{
					return false;
				}
				else
					s.pop();
				
			}
			System.out.println(i);
		}
		
		if(s.isEmpty())
			return true;
		else
			return false;
		
	}
	
	
	
	public static boolean validLength(Stack<Character> s,String str)
	{
		
		if(str.length()==0)
			return false;
		
		HashMap<Character,Character> map=new HashMap<>();
		map.put(')', '(');
		
		//map.put(']', '[');
		//map.put('}','{');
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(') {
				s.push(str.charAt(i));
			}else
			{
				if(s.isEmpty() || s.peek()!=map.get(str.charAt(i)))
				{
					return false;
				}
				else
					s.pop();
				
			}
			System.out.println(i);
		}
		
		if(s.isEmpty())
			return true;
		else
			return false;
		
	}

}
