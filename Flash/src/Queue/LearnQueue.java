package Queue;

public class LearnQueue {
	public static void main(String[] args) {
		//linear data structure
		//LIFO
		//last in first out
		//enqueue,dequeue
		//async operations,process scheduling,time based jobs
		
		
		//precedence
		/*1) ()
		2)  ^           right to left    
        3) *, /          left to right     associativity is useful when both the operators have same precedance
         4) +,-    Left to right associativity
         */
		
		
		
		CircularQueueUsingArray queue=new CircularQueueUsingArray();
		//System.out.println(queue.isEmpty());
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		//System.out.println(queue.size);
		//queue.display();
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(10);
		System.out.println(queue.isEmpty());

		//System.out.println("Size: "+queue.size);
		//queue.display();
		/*queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(20);*/
		//System.out.println("Size: "+queue.size);
	
		//System.out.println(queue.isFull());
		//queue.display();
		queue.enQueue(30);
		//System.out.println(queue.isFull());
		//queue.display();
		queue.enQueue(20);
		queue.enQueue(50);
		queue.enQueue(50);
		System.out.println(queue.isFull());
		//queue.enQueue(10);
		//queue.enQueue(50);
		//queue.display();
		//System.out.println("Size: "+queue.size);
//queue.deQueue();
//System.out.println("Size: "+queue.size);

while(queue.size!=0)
{
System.out.println(queue.deQueue());	
}
		//queue.display();

/*		queue.enQueue(40);
		queue.enQueue(50);
		queue.display();
		System.out.println(queue.isFull());
		queue.display();
		queue.enQueue(60);
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		System.out.println(queue.isEmpty());
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
		System.out.println(queue.isEmpty());*/
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
		return this.front;
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
		
		System.out.println("\n Queue front to rear");
		/*for(int i=this.front;i<=this.rear;)
		{
			System.out.print(this.ar[i]+" ");
			i=(i+1)%this.ar.length;
		}*/
		
		
	}


}
