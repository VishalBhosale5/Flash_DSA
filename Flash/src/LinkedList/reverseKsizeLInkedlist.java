package LinkedList;

import LinkedList.SinglyLinkedlistdummy.Node;

public class reverseKsizeLInkedlist {
	public static void main(String[] args) {
		SinglyLinkedlistdummy list=new SinglyLinkedlistdummy();
		
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNode(60);
		list.addNode(70);
		list.addNode(80);
	
		list.addNode(90);
		list.addNode(100);
		list.addNode(110);
		
	
	list.display();
	
	
	
	Node n=reverseLinkedListK(list.head,3);
	list.head=n;
	list.display();
	
		

	}
	
	
	public static Node reverseLinkedListK(Node head,int k)
	{
		
		//iterative approach O(n)
		Node curr=head;
		Node next=null;
		Node prev=null;
		int count=0;
		while(curr!=null && count<k)
		{
			
			 next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		
		if(next!=null)
			head.next=reverseLinkedListK(next, k);
		
		
		return prev;
	}

}
