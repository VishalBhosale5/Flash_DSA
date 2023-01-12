package OOPandStacks;

public class StackUsingQueue {
	public static void main(String[] args) {
		
		StackUsingQueuePushEfficient stack=new StackUsingQueuePushEfficient();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		//System.out.println("top of stack: "+stack.primary.ar[stack.topIndex()]);
		stack.display();
		System.out.println("top : "+stack.top());
		stack.display();
	/*	while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");*/
		System.out.println();
	/*	stack.pop();
	
		stack.pop();
		System.out.println("top"+stack.top());*/

		
		//stack.display();
		
		
	/*	StackUsingQueuePopEfficient stack=new StackUsingQueuePopEfficient();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		//System.out.println("top of stack: "+stack.primary.ar[stack.topIndex()]);
		System.out.println("top"+stack.top());
		
		stack.pop();
	
		stack.pop();
		System.out.println("top"+stack.top());

		//while(!stack.isEmpty())
			//System.out.print(stack.pop()+" ");
		stack.display();*/
	}

}




class StackUsingQueuePushEfficient
{
	
	CircularQueueUsingArray primary;
	CircularQueueUsingArray secondary;
	int top;
	int size=0;
	
	public StackUsingQueuePushEfficient()
	{
		this(10);
	
	}


	public StackUsingQueuePushEfficient(int size ) {
		this.primary=new CircularQueueUsingArray(size);
		this.secondary=new CircularQueueUsingArray(size);
		this.top=-1;
		
	}

	
	//check if Queue is empty
	public boolean isEmpty()
	{
		
		if(this.primary.isEmpty())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isFull()
	{
		if(this.primary.isFull())
			return true;
		
		return false;
	}


	public void push(int val)
	{
		if(this.primary.isFull())
			return;
		
		this.primary.enQueue(val);
		top++;
		size++;
	}

	
	public int topIndex()
	{
		return this.primary.front;
	}
	
	
	public int pop()
	{
		
		if(this.primary.isEmpty())
			return -1;
		
		
		while(this.primary.size!=1)
		{
			this.secondary.enQueue(this.primary.deQueue());
		}
		int ele=this.primary.deQueue();
		
		while(this.secondary.size!=0)
		{
			this.primary.enQueue(this.secondary.deQueue());
		}
		
		size--;
		top--;
		return ele;
	
		
	}
	
	
	public int top()
	{
		
		if(this.primary.isEmpty())
			return -1;
		
		
		while(this.primary.size!=1)
		{
			this.secondary.enQueue(this.primary.deQueue());
		}
		int ele=this.primary.deQueue();
		
		this.secondary.enQueue(ele);
		
		while(this.secondary.size!=0)
		{
			this.primary.enQueue(this.secondary.deQueue());
		}
		
		return ele;
	
		
	}
	
	
	public void display()
	{
		
		/*for(int i=this.front;i<=this.rear;)
		{
			System.out.print(this.ar[i]+" ");
			i=(i+1)%this.ar.length;
		}*/
		/*System.out.println();
		while(this.primary.size!=0)
		{
			System.out.print(this.primary.deQueue()+" ");
		}
		*/
		this.primary.display();
	}


}



class StackUsingQueuePopEfficient
{
	
	CircularQueueUsingArray primary;
	CircularQueueUsingArray secondary;
	int top;
	int size=0;
	
	public StackUsingQueuePopEfficient()
	{
		this(10);
	
	}


	public StackUsingQueuePopEfficient(int size ) {
		this.primary=new CircularQueueUsingArray(size);
		this.secondary=new CircularQueueUsingArray(size);
		this.top=-1;
		
	}

	
	//check if Queue is empty
	public boolean isEmpty()
	{
		
		if(this.primary.isEmpty())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isFull()
	{
		if(this.primary.isFull())
			return true;
		
		return false;
	}

 //O(n)
	public void push(int val)
	{
		if(this.primary.isFull())
			return;
		
		
		while(!this.primary.isEmpty())
		{
			this.secondary.enQueue(this.primary.deQueue());
		}
		this.primary.enQueue(val);
		while(!this.secondary.isEmpty())
		{
			this.primary.enQueue(this.secondary.deQueue());
		}
		top++;
		size++;
	}

	
	public int topIndex()
	{
		return this.primary.front;
	}
	
	//O(1)
	public int pop()
	{
		
		if(this.primary.isEmpty())
			return -1;
		
		int ele=this.primary.deQueue();
		
		size--;
		top--;
		return ele;
	
		
	}
	
	//O(1)
	public int top()
	{
		
		if(this.primary.isEmpty())
			return -1;
		
		
		int ele=this.primary.ar[this.primary.front];
		
		
		return ele;
	
		
	}
	
	
	public void display()
	{
		
		/*for(int i=this.front;i<=this.rear;)
		{
			System.out.print(this.ar[i]+" ");
			i=(i+1)%this.ar.length;
		}*/
		/*System.out.println();
		while(this.primary.size!=0)
		{
			System.out.print(this.primary.deQueue()+" ");
		}
		*/
		this.primary.display();
	}


}






class CircularQueueUsingArray
{
	int[] ar=null;
	int front;
	int rear;
	int size;
	
	public CircularQueueUsingArray()
	{
		this(10);
		this.size=0;
	}


	public CircularQueueUsingArray(int size ) {
		ar=new int[size];
		front=-1;
		rear=-1;
		
	}

	
	//check if Queue is empty
	public boolean isEmpty()
	{
		//if((this.front==-1 && this.rear==-1) || this.front>this.rear)
		//or
		if(size==0)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isFull()
	{
		//if((this.rear+1)%this.ar.length==this.front)
		//or
		if(size==ar.length)
			return true;
		
		return false;
	}


	public void enQueue(int val)
	{
		if(isFull())
		{
			return;
		}
		else if(isEmpty())
		{
			this.front=this.rear=0;
		}
		else
			this.rear=(this.rear+1)%this.ar.length;
		
		ar[this.rear]=val;
		size++;
	}

	
	public int topIndex()
	{
		return this.rear;
	}
	
	
	public int deQueue()
	{
		int element=0;
		if(isEmpty())
		{
			return -1;
		}
		else
		{
			element=this.ar[front];
			this.front=(this.front+1)%this.ar.length;
		}
		size--;
		return element;
	
		
	}
	
	
	public void display()
	{
		/*
		System.out.println("\n Queue front to rear");
		for(int i=this.front;(i+1)%this.ar.length<=this.rear;i=(i+1)%this.ar.length)
		{
			System.out.print(this.ar[i]+" ");
			
		}*/
		
		
		if(isEmpty())
			System.out.println("Queue is Empty");
		else
		{
			int i;
			for( i=front;i!=rear;i=(i+1)%ar.length)
			{
				System.out.print(ar[i]+" ");
			}
			System.out.print(ar[i]);
		}
		
		System.out.println();
		
	}


}
