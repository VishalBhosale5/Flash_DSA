package LinkedList;

import LinkedList.SinglyLinkedlistdummy.Node;

public class FindIntersectionPointOfTwoLinkedList {
	
	public static void main(String[] args) throws Exception {
		SinglyLinkedlistdummy list1=new SinglyLinkedlistdummy();
		SinglyLinkedlistdummy list2=new SinglyLinkedlistdummy();
		//In naive approach we can use two for loops of size m and n  hence O(n*n)
		//better approach
		list1.addNode(10);
		list1.addNode(20);
		list1.addNode(30);
		list1.addNode(40);
		list1.addNode(50);
		list1.addNode(60);
		
		SinglyLinkedlistdummy.Node n=list1.getNodeAt(3);

		list2.addNode(100);
		list2.addNode(200);
		list2.addNode(300);
		list2.addNode(400);
		list2.addNode(500);
		list2.addNODE(n);
		
		list1.display();
		list2.display();

		SinglyLinkedlistdummy.Node sec=find(list1,list2);
		System.out.println(sec.data);
	}

	private static Node find(SinglyLinkedlistdummy list1, SinglyLinkedlistdummy list2) {
		
		
		int l1=0;
		int l2=0;
		
		
		Node curr1=list1.head;
		Node curr2=list2.head;
		
		while(curr1!=null)
		{
			l1++;
			curr1=curr1.next;
		}
		
		while(curr2!=null)
		{
			l2++;
			curr2=curr2.next;
		}
		Node c1=list1.head;
		Node c2=list2.head;
		
		int diff=0;
		if(l1<l2)
		{
			Node temp=c1;
			c1=c2;
			c2=temp;
			diff=l2-l1;
		}else
		diff=l1-l2;
		
		for(;diff>0;diff--)
			c1=c1.next;
		
		
		while(c1!=c2)
		{
			c1=c1.next;
			c2=c2.next;
		}
		
		return c1;
		
		
		
		
		
	}

}
