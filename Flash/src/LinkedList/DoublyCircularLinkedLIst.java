package LinkedList;

import LinkedList.CircularLinkedLIst.Node;

public class DoublyCircularLinkedLIst {

	
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
			tail.next=nn;
			head.prev=nn;
			
		}
		else
		{
		/*	nn.next=head;
			nn.prev=head.prev;
			head.prev=nn;
			nn.prev.next=nn;
			head=nn;*/
			
			tail.next=nn;
			nn.prev=tail;
			nn.next=head;
			head.prev=nn;
			head=nn;
		/*	head.prev.next=nn;
			nn.prev=tail;
			nn.next=head;
			head.prev=nn;*/
			
		
		}
		
		size++;
	}
	
	public void addNodeAtEnd(int item)
	{
		Node nn=new Node(item);
		
		if(head==null)
		{
			head=tail=nn;
			tail.next=nn;
			head.prev=nn;
			
		}
		else
		{
			tail.next.prev=nn;
			nn.next=head;
			tail.next=nn;
			nn.prev=tail;
			tail=nn;
		}
		
		size++;
	}
	
	

	
	
	
	
	
	
	
	public void display()
	{
		
	Node curr=tail.next;
	while(curr!=tail)
	{
		System.out.print(curr.data+" -> ");
		curr=curr.next;
	}
		System.out.println(curr.data);
		
	}
	
	
	
	public static void main(String[] args) {
		
		DoublyCircularLinkedLIst list=new DoublyCircularLinkedLIst();
		
		list.addNodeAtEnd(100);
		list.addNodeAtEnd(200);
		list.addNodeAtEnd(300);
		list.display();
		list.addNodeAtStart(50);
		list.display();
		list.deleteNodeAtEnd();
		list.display();
		list.deleteNodeAtStart();
		list.display();
		System.out.println(list.size);

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
			head.prev=tail.prev;
			tail.prev.next=head;
			
			tail=tail.prev;
			
	
			
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
			tail.next=tail.next.next;
			head.next.prev=head.prev;
			head=head.next;
			
			
			 
		}
		
		size--;
		
		return ele;
	}
	
	

}
