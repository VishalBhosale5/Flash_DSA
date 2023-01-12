package LinkedList;

public class GetMidOfLinkedlist {
public static void main(String[] args) {
	
	SinglyLinkedlistdummy list=new SinglyLinkedlistdummy();
	list.addNode(10);
	list.addNode(20);
	list.addNode(30);
	list.addNode(40);
	list.addNode(50);
	list.addNode(60);
	list.display();
	SinglyLinkedlistdummy.Node mid=getMid(list);
	System.out.println(" mid Node data: "+mid.data+" next :"+mid.next);
	
}

private static SinglyLinkedlistdummy.Node getMid(SinglyLinkedlistdummy list) {
	SinglyLinkedlistdummy.Node slowptr=list.head;
	SinglyLinkedlistdummy.Node Fastptr=list.head;
	
	//for odd and even length linkedlist size
	while(Fastptr.next!=null && Fastptr.next.next!=null)
	{
		slowptr=slowptr.next;
		Fastptr=Fastptr.next.next;
		System.out.println("call: slow"+slowptr.data+" fast data :"+Fastptr.data);
	}
	
	return slowptr;
	
	
	
}
}
