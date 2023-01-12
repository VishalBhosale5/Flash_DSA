package LinkedList;

import LinkedList.SinglyLinkedlistdummy.Node;

public class MergeTwoSortedLinkedList {
	
	public static void main(String[] args) {
		SinglyLinkedlistdummy list1=new SinglyLinkedlistdummy();
		
		list1.addNode(10);
		list1.addNode(20);
		list1.addNode(50);
		SinglyLinkedlistdummy list2=new SinglyLinkedlistdummy();
		
		list2.addNode(15);
		list2.addNode(30);
		list1.addNode(60);
		
		SinglyLinkedlistdummy.Node nn=mergeExtraSpace(list1.head,list2.head);
		
		Node curr=nn;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr=curr.next;
		}
		
	}

	private static Node mergeExtraSpace(SinglyLinkedlistdummy.Node l1, SinglyLinkedlistdummy.Node l2) {
		
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		
		if(l1.data>l2.data)
		{
			Node temp=l1;
			l1=l2;
			l2=temp;
		}
		
		
		Node res=l1;
		
		
		
		while(l1!=null && l2!=null)
		{
			
			
			Node temp=null;
			
			while(l1!=null && l1.data<=l2.data)
			{
				temp=l1;
				l1=l1.next;
			}
			
			
			temp.next=l2;
			
			
			
			Node t=l1;
			l1=l2;
			l2=t;
			
			
			
			
			
			
			
		}
		
		
		
		
		return res;
	}

}



