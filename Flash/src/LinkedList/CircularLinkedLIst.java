package LinkedList;

public class CircularLinkedLIst {

		class Node
		{
			
			int data;
			Node next;
	
			
			
			Node(int data)
			{
				this.data=data;
				this.next=null;
			
			}
			
			
		}
		

		Node tail=null;
		int size=0;
		
		
		public void addNodeAtStart(int item)
		{
			Node nn=new Node(item);
			
			if(tail==null)
			{
				tail=nn;
				tail.next=nn;
				
			}
			else
			{
				nn.next=tail.next;
				tail.next=nn;
				
			}
			
			size++;
		}
		
		public void addNodeAtEnd(int item)
		{
			Node nn=new Node(item);
			
			if(tail==null)
			{
				tail=nn;
				tail.next=nn;
				
			}
			else
			{
				nn.next=tail.next;
				tail.next=nn;
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
			
			CircularLinkedLIst list=new CircularLinkedLIst();
			
			list.addNodeAtEnd(100);
			list.addNodeAtEnd(200);
			list.addNodeAtEnd(300);
			list.display();
			System.out.println(list.size);
			list.addNodeAtStart(10);
			list.display();
			list.deleteNodeAtEnd();
			list.deleteNodeAtStart();
			//list.deleteNodeAtEnd();
			//list.display();
			//System.out.println(list.size);
			//list.deleteNodeAtStart();
			//list.display();
			//System.out.println(list.size);
		
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
			else if(tail.next==tail)
			{
				tail=null;
			}
			else
			{
				Node curr=tail.next;
				
				while(curr.next!=tail)
				{
					curr=curr.next;
				}
				
				curr.next=tail.next;
				tail=curr;
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
			else if(size==1 || tail.next==tail)
			{
				ele=tail.data;
				tail=null;
				
			}
			else
			{
				ele=tail.next.data;
				tail.next=tail.next.next;
				
				 
			}
			
			size--;
			
			return ele;
		}
		
		

	}
