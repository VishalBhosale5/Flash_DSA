package Queue;

public class QueueUsingStacks {
public static void main(String[] args) throws Exception {
	/*QueueUsingStackEnQueueEfficient queue=new QueueUsingStackEnQueueEfficient();
	
	queue.enQueue(10);
	queue.enQueue(20);
	queue.enQueue(30);
	queue.enQueue(40);
	queue.enQueue(10);
	queue.enQueue(20);
	queue.enQueue(30);
	System.out.println(queue.size);
	queue.display();
	queue.deQueue();
	System.out.println();
	queue.display();
	System.out.println();
	System.out.println(queue.front());
	System.out.println(queue.size);*/
	
	
	
QueueUsingStackDeQueueEfficient queue=new QueueUsingStackDeQueueEfficient();
	
	queue.enQueue(10);
	queue.enQueue(20);
	queue.enQueue(30);
	queue.enQueue(40);
	queue.enQueue(10);
	queue.enQueue(20);
	queue.enQueue(30);
	System.out.println(queue.size);
	queue.display();
	queue.deQueue();
	System.out.println();
	queue.display();
	System.out.println();
	System.out.println(queue.front());
	System.out.println(queue.size);
	
	
}
}

class QueueUsingStackEnQueueEfficient
{
	
	
	/*
	 * 
	 * This is Enqueue efficent because takes O(1) time
	 * and Dequeue inefficient because need to shift element from primary to secondary O(n)
	 */
	Stack primary=null;
	Stack secondary=null;
	int front;
	int rear;
	int size;
	
	public QueueUsingStackEnQueueEfficient() throws Exception {
		primary=new Stack();
		secondary=new Stack();
		this.size=0;
		this.front=-1;
		this.rear=-1;
	}

	public void display()
	{
		
		for(int i=0;i<primary.size();i++)
		{
			System.out.print(primary.data[i]+" ");
		}
	}
	//check if Queue is empty
		public boolean isEmpty()
		{
			//if((this.front==-1 && this.rear==-1) || this.front>this.rear)
			//or
		/*	if(size==0)
			{
				return true;
			}*/
			
			//or
			if(this.primary.isEmpty())
				return true;
			
			return false;
		}
		
		public boolean isFull()
		{
			//if((this.rear+1)%this.ar.length==this.front)
			//or
			if(primary.isFull())
				return true;
			
			return false;
		}

		//O(1)
		public void enQueue(int val) throws Exception
		{
			if(this.primary.isFull())
			{
				return;
			}
			
			this.primary.push(val);

			size++;
		}

		//O(n) 	
		public int front() throws Exception
		{
			while(primary.size()!=1)
			{
				secondary.push(primary.pop());
			}
			int ele=primary.top();
			
			while(!secondary.isEmpty())
			{
				primary.push(secondary.pop());
			}
			return ele;
		}
		
		//O(n)
		public int deQueue() throws Exception
		{
			
			if(this.primary.isEmpty())
			{
				return -1;
			}
			while(primary.size()!=1)
			{
				secondary.push(primary.pop());
			}
			int ele=primary.pop();
			
			while(!secondary.isEmpty())
			{
				primary.push(secondary.pop());
			}
			size--;
			return ele;
		
			
		}
		





}




class QueueUsingStackDeQueueEfficient
{
	
	
	/*
	 * 
	 * This is DeQueue efficent because takes O(1) time
	 * and EnQueue inefficient because need to shift element from primary to secondary O(n)
	 */
	Stack primary=null;
	Stack secondary=null;
	int front;
	int rear;
	int size;
	
	public QueueUsingStackDeQueueEfficient() throws Exception {
		primary=new Stack();
		secondary=new Stack();
		this.size=0;
		this.front=-1;
		this.rear=-1;
	}

	public void display()
	{
		
		for(int i=primary.size()-1;i>=0;i--)
		{
			System.out.print(primary.data[i]+" ");
		}
	}
	//check if Queue is empty
		public boolean isEmpty()
		{
			//if((this.front==-1 && this.rear==-1) || this.front>this.rear)
			//or
		/*	if(size==0)
			{
				return true;
			}*/
			
			//or
			if(this.primary.isEmpty())
				return true;
			
			return false;
		}
		
		public boolean isFull()
		{
			//if((this.rear+1)%this.ar.length==this.front)
			//or
			if(primary.isFull())
				return true;
			
			return false;
		}

		//O(N)
		public void enQueue(int val) throws Exception
		{
			if(this.primary.isFull())
			{
				return;
			}
			
			while(!this.primary.isEmpty())
			{
				secondary.push(primary.pop());
			}
			this.primary.push(val);
			
			while(!this.secondary.isEmpty())
			{
				primary.push(secondary.pop());
			}

			size++;
		}

		//O(1) 	
		public int front() throws Exception
		{
			
			return this.primary.top();
		}
		
		//O(1)
		public int deQueue() throws Exception
		{
			
			if(this.primary.isEmpty())
			{
				return -1;
			}
			
			int ele=this.primary.pop();
			
			
			size--;
			return ele;
		
			
		}
		





}





class Stack  { 

protected int[] data; 

protected int top; 

  

final static int DEFAULT_CAPACITY = 10; 

  

public Stack() throws Exception  

{ 

this(DEFAULT_CAPACITY); 

} 

  

public Stack(int capacity) throws Exception { 

  

if (capacity < 1) 

throw new Exception("Invalid capacity"); 

this.data = new int[capacity]; 

this.top=-1; 

  

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

 

public int size() 

{ 

return this.top+1;          //top is index so top+1 gives size 

} 

public boolean isEmpty() 

{ 

return this.size()==0; 

} 

 public boolean isFull()
 {
	 if(this.size()==data.length)
		 return true;
	 
	 return false;
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
