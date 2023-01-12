package LinkedList;

public class DetectionOfLoopInLinkedList {
	public static void main(String[] args) throws Exception {
		SinglyLinkedlistdummy list=new SinglyLinkedlistdummy();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNODE(list.getNodeAt(2));
		
		
		Boolean hasloop=detectLoop(list);
		removeLoop(list);
		hasloop=detectLoop(list);
		System.out.println(hasloop);
		list.display();
	}

	private static Boolean detectLoop(SinglyLinkedlistdummy list) {
		//in brute force approch we can use hasset and everytime adding address of node and checing before adding new one
		//below is better than above approach as it doesn't uses extra space
		
		SinglyLinkedlistdummy.Node sloptr=list.head;
		SinglyLinkedlistdummy.Node fastptr=list.head;
		
		while(fastptr.next!=null && fastptr.next.next!=null)
		{
			sloptr=sloptr.next;
			fastptr=fastptr.next.next;
			if(sloptr==fastptr)
			{
				return true;
			}
			
			
		}
		
		
		return false;
	}
	
	
	 static void removeLoop(SinglyLinkedlistdummy list) {
		//in brute force approch we can use hasset and everytime adding address of node and checing before adding new one
		//below is better than above approach as it doesn't uses extra space
		
		SinglyLinkedlistdummy.Node sloptr=list.head;
		SinglyLinkedlistdummy.Node fastptr=list.head;
		
		while(fastptr.next!=null && fastptr.next.next!=null)
		{
			sloptr=sloptr.next;
			fastptr=fastptr.next.next;
			if(sloptr==fastptr)
			{
				break;
			}
			
			
		}
		
		fastptr=list.head;
		
		while(sloptr.next!=fastptr.next)
		{
			sloptr=sloptr.next;
			fastptr=fastptr.next;
		}
		
		//this code is also fine
		/*SinglyLinkedlistdummy.Node point=sloptr;
		
		while(fastptr.next!=sloptr)
		{
			fastptr=fastptr.next;
		}*/
		
		sloptr.next=null;
	}

}
