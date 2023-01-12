package Queue;

public class ReverseQueue {
public static void main(String[] args) {
	
	CircularQueueUsingArrayy queue=new CircularQueueUsingArrayy();
	queue.enQueue(10);
	queue.enQueue(20);
	queue.enQueue(30);
	queue.enQueue(40);
	queue.enQueue(50);
	queue.display();
	
	reverse(queue);
	
	while(!queue.isEmpty())
		System.out.println(queue.deQueue()+" ");

}

private static void reverse(CircularQueueUsingArrayy queue) {
	
	if(queue.isEmpty())
		return;
	
	int temp=queue.deQueue();
	reverse(queue);
	
	queue.enQueue(temp);
	
}
}
class CircularQueueUsingArrayy
{
	int[] ar=null;
	int front;
	int rear;
	int size;
	
	public CircularQueueUsingArrayy()
	{
		this(10);
		this.size=0;
	}


	public CircularQueueUsingArrayy(int size ) {
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
		
		System.out.println("\n Queue front to rear");
		/*for(int i=this.front;i<=this.rear;)
		{
			System.out.print(this.ar[i]+" ");
			i=(i+1)%this.ar.length;
		}*/
		
		
	}
}