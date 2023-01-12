package Queue;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingChracterInAStream {
	public static void main(String[] args) {
		//String str="GeeksforGekks";
		//int index=find(str);
		//System.out.println(index);
		findefficient();
	}

	
	//O(n^2)  approach
	private static int find(String str) {
		
		
		
		HashMap<Character,Integer> map=new HashMap<>();
		
		
		for(int i=0;i<str.length();i++)
		{
			
			if(map.containsKey(str.charAt(i)))
			{
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			else
			{
				map.put(str.charAt(i),1);

			}
		}
		System.out.println(map);
		
		
		for(int i=0;i<str.length();i++)
		{
			
			if(map.get(str.charAt(i))==1)
			{
				return i;
			}
		}
		return 0;
	}


//O(n)
public static void findefficient()
{
	
	CircularQueueUsingArr queue=new CircularQueueUsingArr();
	
	HashMap<Character,Integer> map=new HashMap<>();
	Scanner sc=new Scanner(System.in);
	char ch=sc.next().charAt(0);
	//System.out.println("steop 1");

	while(ch!='.')
	{
		
		queue.enQueue(ch);
		System.out.println("Queue----");
		queue.display();
		System.out.println("----");

		if(map.containsKey(ch))
		{
			
			map.put(ch, map.get(ch)+1);
		}
		else
			map.put(ch, 1);
		
		//System.out.println("steop 2");

		
		while(!queue.isEmpty())
		{
			//System.out.println("steop 3");
			//System.out.println(queue.ar[queue.topIndex()]);
		if(map.get(queue.ar[queue.topIndex()])==1)
		{
			System.out.println(queue.ar[queue.front]);
			break;
		}
		else
		{
			queue.deQueue();
		}
		}
		
		if(queue.isEmpty())
			System.out.println("-1");
		
		ch=sc.next().charAt(0);
		
	}







}



}









class CircularQueueUsingArr
{
	char[] ar=null;
	int front;
	int rear;
	int size;
	
	public CircularQueueUsingArr()
	{
		this(10);
		this.size=0;
	}


	public CircularQueueUsingArr(int size ) {
		ar=new char[size];
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


	public void enQueue(char val)
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
