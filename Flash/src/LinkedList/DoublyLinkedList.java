package LinkedList;

public class DoublyLinkedList {
	
	class Node
	{
		
		int data;
		Node next;
		Node prev;
		
		
		Node(int data)
		{
			this.data=data;
			this.next=null;
			this.prev=null;
		}
		
		
	}
	

	Node head=null;
	Node tail=null;
	int size=0;
	
	
	public void addNodeAtStart(int item)
	{
		Node nn=new Node(item);
		
		if(head==null)
		{
			head=tail=nn;
			
		}
		else
		{
			nn.next=head;
			head.prev=nn;
			head=nn;
		}
		
		size++;
	}
	
	public void addNodeAtEnd(int item)
	{
		Node nn=new Node(item);
		
		if(head==null)
		{
			head=tail=nn;
			
		}
		else
		{
			tail.next=nn;
			nn.prev=tail;
			tail=nn;
		}
		
		size++;
	}
	
	
	public void reverse()
	{
		
		
		
		//approach
		//make next of head to prev of head and prev of head to next of head
		Node curr=head;
		Node tempPrev=null;
		
		
		if(curr==null || curr.next==null)
			return;
		
		while(curr!=null)
		{
			tempPrev=curr.prev;
			curr.prev=curr.next;
			curr.next=tempPrev;
			
			
			
			
			curr=curr.prev;
		}
		
		
		//check if list has only one node then temp should not be null
		//if list has 1 element then temp will be null and temp.prev will give nullpointer exception hecne better to check now or starting of code as if(size==1) then return 
		if(tempPrev!=null)
			head=tempPrev.prev;
	}
	
	public void SortedInsert(int item)
	{
		
		Node nn=new Node(item);
		
		Node curr=head;
		
		if(curr==null)
		{
			head=tail=nn;
		}
		else if(head.data>=item)
		{
			nn.next=head;
			head.prev=nn;
			head=nn;
		}
		else
		{
			while(curr.next!=null && curr.next.data < item)
			{
	
				curr=curr.next;
				
			}
			
			//it means at end we can insert
			
			if(curr.next==null)
			{
				System.out.println("end");
				nn.prev=tail;
				tail.next=nn;
				tail=nn;
			}
			else
			{
				System.out.println("in");
				nn.next=curr.next;
				curr.next.prev=nn;
				nn.prev=curr;
				curr.next=nn;
			}
			
			
			
			
		}
		
	}
	
	
	
	
	
	public void display()
	{
		
	Node curr=head;
	while(curr!=null)
	{
		System.out.print(curr.data+" -> ");
		curr=curr.next;
	}
		System.out.println();
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		DoublyLinkedList list=new DoublyLinkedList();
		
		list.addNodeAtEnd(100);
		list.addNodeAtEnd(200);
		list.addNodeAtEnd(300);
		list.display();
		list.revers();;
		list.display();
		//System.out.println(list.size);
		//list.deleteNodeAtEnd();
		//list.display();
		//System.out.println(list.size);
		//list.deleteNodeAtStart();
		//list.display();
		//System.out.println(list.size);
		//list.SortedInsert(250);
		//list.display();
		//list.reverse();
		//list.display();

	}
	
	
	//test

	public void revers()
	{
		Node curr=this.head;


		Node temp=null;
		Node next=curr;

		while(curr!=null)
		{
			next=curr.next;
			curr.next=temp;
			curr.prev=next;
			temp=curr;
			curr=next;
		}
		this.head=temp;
	}
	
	
	
	public int deleteNodeAtEnd()
	{
		
		int ele=tail.data;
		if(tail==null)
		{
			return -1;
			
		}
		else
		{
			tail=tail.prev;
			tail.next=null;
		}
		
		size--;
		
		return ele;
	}
	public int deleteNodeAtStart()
	{
		int ele=0;
	
		if(tail==null)
		{
			return -1;
			
		}
		else if(size==1)
		{
			ele=head.data;
			head=tail=null;
			
		}
		else
		{
			ele=head.data;
			head=head.next;
			head.prev=null;
			 
		}
		
		size--;
		
		return ele;
	}
	
	

}
