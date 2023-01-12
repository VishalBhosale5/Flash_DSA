package OOPandStacks;


public class Learn {
	public static void main(String[] args) throws Exception {
		// references are stored in stack
		// objects are stored in heap
		// when objects created then member variables are initialized with default
		// values.

		// class name Noun //student
		// data members Adjectives //name,age
		// functions verb //setname
		
		//time complexity of all the stack operations are O(1)  except display
		//stack is used in browser  forward and backward
		/*Stack s=new DynamicStack();
		System.out.println("----Stack of size:"+s.size()+"-------");
		s.push(10);
		s.push(20);
		s.push(25);
		s.push(30);
		s.push(10);
		s.push(20);
		s.push(25);
		s.push(30);
		s.push(10);
		s.push(20);
		s.push(25);
		s.push(30);
		s.display();*/
		/*Stack helper=new Stack();
		s.reverseStack(s, helper, 0);
		s.display();*/
		/*s.pop();
		s.display();
		System.out.println(s.top());
		s.pop();
		s.display();*/
		
		//System.out.println(s.top);
		
		int[] ar= {2,1,3,8,6,7,5};
	//	printNextGreator(ar);
	}
	
	
	

}

class Stack {
	protected int[] data;
	protected int top;

	final static int DEFAULT_CAPACITY = 10;

	public Stack() throws Exception {
		// TODO Auto-generated constructor stub
		this(DEFAULT_CAPACITY);
	}

	public Stack(int capacity) throws Exception {

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
		
		this.top++;
		this.data[this.top]=val;
		
		
	}
	
	
	public int pop() throws Exception
	{
		//check if stack is empty or not
		if(this.isEmpty())
			throw new Exception("Stack is empty");
		int element=this.data[this.top];
		this.data[this.top]=0;
		this.top--;
		return element;
		
	}
	
	public int top() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack is empty");
		
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
	
	
	public static void reverseStack(Stack s,Stack helper,int index) throws Exception
	{
		if(s.size()==0)
			return;
		
		int item=s.pop();
		reverseStack(s, helper,index+1);
		helper.push(item);
		if(index==0)
			while(!helper.isEmpty())
				s.push(helper.pop());
	}

}

class DynamicStack extends Stack
{

	public DynamicStack() throws Exception {
		this(DEFAULT_CAPACITY);
		// TODO Auto-generated constructor stub
	}
	public DynamicStack(int capacity) throws Exception
	{
		
		super(capacity);
	}

	
	//Everything else is same but we need to override the push funcition
	
	public void push(int item) throws Exception
	{
		if(this.size()==this.data.length)
		{
			int[] data=new int[2*this.data.length];
			
			for(int i=0;i<this.size();i++)
				data[i]=this.data[i];
			
			this.data=data;
		}
		super.push(item);
		
		
		
	}
}