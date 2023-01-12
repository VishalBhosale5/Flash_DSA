package Queue;

public class QueueUsingLinkedList {

public static void main(String[] args) {
	SinglyLinkedList_Queue list=new SinglyLinkedList_Queue();
	list.enQueue(10);
	list.enQueue(20);
	list.enQueue(30);
	list.enQueue(40);
	list.display();
	System.out.println("Top is :"+list.getFront());
	System.out.println("Element removed :"+list.deQueue());
	System.out.println("Top is :"+list.getFront());

	list.display();
	
	
}
}

class SinglyLinkedList_Queue {
	
	 class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// head and tail are pointing to null
	 Node head = null;
	 Node tail = null;
	 int size = 0;

	public int getSize()
	{
		return this.size;
	}
	
	
	//O(1)  use addLast method of linkelist
	public void enQueue(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;

		} else {
			// add node to the head

			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	

	public boolean isEmpty()
	{
		return head==null;
	}
	

	
		

//O(1)
	public void display() {
		Node current = head;   //initially head has address of first node

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;    //accessing address of next nodes and printing the data from that node
		}
		System.out.println();

	}



//use deletefront method os linkedlist
	public int deQueue() {
		// TODO Auto-generated method stub

		Node current = head;
		int ele=head.data;
		if (current == null || size==0)
			return -1;
		else if(size==1)
		{
			
			head=tail=null;
			
		}
		else
			head = current.next; //because head has address of the next node stored in next
			
			size--;
return ele;
		
	}
	
public int getFront()
{
return head.data;	
}

	


}
