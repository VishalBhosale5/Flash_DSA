package LinkedList;


public class ReverseLinkedLIst {
	
public static void main(String[] args) throws Exception {
	SinglyLinkedlistdummy list=new SinglyLinkedlistdummy();
	list.addNode(10);
	list.addNode(20);
	list.addNode(30);
	list.addNode(40);
	list.display();
	reversePinter(list);
	list.display();
	
}


public static void reverseData(SinglyLinkedlistdummy list) throws Exception
{
int left=0;
int right=list.size-1;
while(left<right)
{
	LinkedList.SinglyLinkedlistdummy.Node ln=list.getNodeAt(left);
	LinkedList.SinglyLinkedlistdummy.Node rn=list.getNodeAt(right);
	
	
	int temp=ln.data;
	ln.data=rn.data;
	rn.data=temp;
left++;
right--;
}

}




public static  void reversePinter(SinglyLinkedlistdummy list)
{
	LinkedList.SinglyLinkedlistdummy.Node prev=list.head;
	LinkedList.SinglyLinkedlistdummy.Node curr=prev.next;
	
	while(curr!=null)
	{
		
		LinkedList.SinglyLinkedlistdummy.Node ahead=curr.next;
		curr.next=prev;
		
		
		prev=curr;
		curr=ahead;
	}
	LinkedList.SinglyLinkedlistdummy.Node temp=list.head;
	list.head=list.tail;
	list.tail=temp;
	
	
	list.tail.next=null;

}






}



