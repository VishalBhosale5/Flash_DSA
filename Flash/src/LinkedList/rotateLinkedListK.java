package LinkedList;

import LinkedList.SinglyLinkedlistdummy.Node;

public class rotateLinkedListK {
	public static void main(String[] args) {
		//rotateLinkedListK o=new rotateLinkedListK();
		SinglyLinkedlistdummy list=new SinglyLinkedlistdummy();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.display();
		//o.rotate(list.head,3);
		//list.head=n;
		Node n=list.rotate(list.head, 2);
		list.head=n;
		list.display();
		
		
	}

	private  void rotate(Node head, int k) {
		
		if(head==null)
			 ;
		
		Node tail=head;
		
		while(tail.next!=null)
			tail=tail.next;
		
		
		for(int i=0;i<k;i++)
		{
			
			//SinglyLinkedlistdummy.Node temp=new Node(head.data);
			//tail.next=temp;
			tail=tail.next;
			head=head.next;
			
			
			
		}
		
		
		
	}

}
