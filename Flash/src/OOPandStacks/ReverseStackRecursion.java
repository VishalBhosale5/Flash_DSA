package OOPandStacks;
import java.util.Stack;

public class ReverseStackRecursion {
public static void main(String[] args) {
	Stack<Integer> s=new Stack<>();
	s.push(10);
	s.push(20);
	s.push(30);
	s.push(40);
	System.out.println(s);
	reverse(s);
	
	System.out.println(s);
}
public static void reverse(Stack<Integer> s)
{
	if(s.size()==1)
		return;

int temp=s.pop();
reverse(s);
insertAtBottom(s, temp);


}
private static void insertAtBottom(Stack<Integer> s, int i) {
	// TODO Auto-generated method stub
	if(s.isEmpty())
	{
		s.push(i);
		return;
	}
	
	
	int temp=s.pop();
	insertAtBottom(s, i);
	s.push(temp);
	
}
}
