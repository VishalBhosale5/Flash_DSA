package OOPandStacks;

public class MinElementInStackWithoutExtraSpace {
public static void main(String[] args) throws Exception {
	
	
	/*int[] ar= {10,5,3,2,1,8};
	
	Stack stk=new Stack<>();
	
	Stack<Integer> extrastk=new Stack<>();
	
	findMin(stk,extrastk,ar);*/
	Stackk s=new Stackk();
	
	s.push(5);
	s.push(3);
	s.push(1);
	System.out.println(s.MIN_Element);
	s.pop();
	s.pop();
	s.push(4);
	System.out.println(s.MIN_Element);
	
}







}
class Stackk {
	protected int[] data;
	protected int top;

	int MIN_Element=0;
	
	final static int DEFAULT_CAPACITY = 10;

	public Stackk() throws Exception {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}

	public Stackk(int capacity) throws Exception {

		if (capacity < 1)
			throw new Exception("Invalid capacity");
		
		this.data = new int[capacity];
		this.top=-1;

	}
	
	
	public int size()
	{
		return this.top+1;
	}
	
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	
	public void push(int val) throws Exception
	{
		
		//check if stack is full or not
		
		if(this.size()==this.data.length)
			throw new Exception("Stack is full");
		
		
		if(this.size()==0)
		{
		
		this.top++;
		this.data[this.top]=val;
		MIN_Element=val;
		}
		else
		{
			if(val>=MIN_Element)
			{
				this.top++;
				this.data[this.top]=val;
			}
			else if(val<MIN_Element)
			{
				this.top++;
				this.data[this.top]=(2*val)-MIN_Element; //2 *x -minElement
			MIN_Element=val;
			}
				
		}
		
		
	}
	
	
	public int pop() throws Exception
	{
		//check if stack is empty or not
		int element=0;
		
		if(this.isEmpty())
			return -1;
		else
		{
			
			if(this.data[this.top]>=MIN_Element)
			{
				 element=this.data[this.top];
				this.data[this.top]=0;
				this.top--;
			}
			else if(this.data[this.top]<MIN_Element)
			{
				MIN_Element=2*MIN_Element-this.data[this.top];
				element=this.data[this.top];
				this.data[this.top]=0;
				this.top--;
			}
		}
			
		return element;
		
		}
	
		
	
	
	public int top() throws Exception
	{
		if(isEmpty())
			return -1;
		else
		{
			if(this.data[this.top]>=MIN_Element)
				return this.data[this.top];
			else if(this.data[this.top]<MIN_Element)
			{
				return MIN_Element;
			}
			
		}
		
		return this.data[this.top];
	}
	
	public void display() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack is empty");
		
		for(int i=this.top;i>=0;i--)
			System.out.println(this.data[i]);
		
		System.out.println("END");
	}
	
	


}