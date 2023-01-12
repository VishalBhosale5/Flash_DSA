package Queue;

import java.util.HashMap;
import java.util.Scanner;

public class FindFirstNegativeIntegerInAArrayOfSizeK {
public static void main(String[] args) {
	int[] ar= {10,-1,30,-5,-3,4,-6,-3,-6,9};
	find(ar,3);
}

private static void find(int[] ar,int K) {

	CircularQueueUsingArra queue=new CircularQueueUsingArra();
	

		for(int i=0;i<ar.length;i++)
			queue.enQueue(ar[i]);
		
		queue.display();
		
	while(!queue.isEmpty())
	{
		
		boolean flg=false;
		for(int i=queue.front;i<K+queue.front && queue.front<ar.length-2;i++)
		{
			if(queue.ar[i]<0)
			{
				System.out.println(queue.ar[i]);
				flg=true;
				break;
			}
			
		}
		
		if(!flg)
			System.out.println("No");
		
		queue.deQueue();
		
	}
	
	
}

}
class CircularQueueUsingArra
{
	int[] ar=null;
	int front;
	int rear;
	int size;
	
	public CircularQueueUsingArra()
	{
		this(10);
		this.size=0;
	}


	public CircularQueueUsingArra(int size ) {
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
