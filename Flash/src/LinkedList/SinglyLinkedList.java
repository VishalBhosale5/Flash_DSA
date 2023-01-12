package LinkedList;

class SinglyLinkedList {
	
	//private because authority to create Node is for SinglyLinkedList class only , no any client class should create node 
	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// head and tail are pointing to null
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public int getSize()
	{
		return this.size;
	}
	
	
	
	
	public void reverseR(Node p)
	{
		if(p.next==null)
		{
			head=p;
			return ;
		}
		
		reverseR(p.next);
		Node q=p.next;       //or p.next.next=p;  
		q.next=p;
		p.next=null;
		
	
		
	}
	
	
	
	
	
	
	//O(n)
	public void addNode(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;

		} else {
			// add node to the last

			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	//O(1)
	public void addNodeatStart(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;

		} else {
			// add node to the last
			newNode.next = head;
			head = newNode;
			size++;

		}
	}
	
	//O(1)
	public int getFirst() throws Exception
	{
		if(this.head!=null)
			return this.head.data;
		else
			throw new Exception("LL is empty");  //since this is dangerous function we should mark it same as throws
	}
	
	
	//O(1)
	public int getLast() throws Exception
	{
		if(this.tail!=null)
			return this.tail.data;
		else
			throw new Exception("LL is empty");  //since this is dangerous function we should mark it same as throws
	}
	
	//O(n)
	//O(1)
		public int getAt(int idx) throws Exception
		{
			
			if(this.size==0 && idx>=size && idx<0)
				return -1;
			Node curr=head;
			int i =0;
			
			while(curr.next!=null)
			{
				
				if(i==idx)
					return curr.data;
				i++;
				curr=curr.next;
			}
			return -1;
		}
		
		
		// if not private then client will access the address of nodes and modify it which is not a good thing
		//this should be a helper method which helps others methods in linkedlist class to get node at particular index
		private Node getNodeAt(int idx) throws Exception
		{
			
			if(this.size==0 && idx>=size && idx<0)
				return null;
			
			Node curr=head;
			int i=0;
			
			while(curr!=null)
			{
				
				if(i==idx)
					return curr;
				i++;
				curr=curr.next;
			}
			return null;
		}
	
			
			//O(n)
		public void AddNodeAt(int item,int idx)throws Exception
		{
			if(idx>size || idx<0)
				return;
			
			
			if(idx==0)
				addNodeatStart(item);
			else if(idx==this.size)
				addNode(idx);
			else
			{
				
			Node prev=getNodeAt(idx-1);
			
			Node newnode=new Node(item);
			
			newnode.next=prev.next;
			
			prev.next=newnode;
			
			
			
			}
			this.size++;
		}
	private void addsortedinsert(int i) {
		// TODO Auto-generated method stub
		Node newnode = new Node(i);
		Node current = head;

		if (current == null || current.data > i) {
			newnode.next = head;
			head = newnode;
			size++;
			return;
		}

		while (current.next != null && current.next.data < i) {
			current = current.next;
		}
		newnode.next = current.next;
		current.next = newnode;
		size++;

	}

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

	public int search(int key) {
		Node current = head;
		int pos = 0;
		;
		while (current != null) {
			if (current.data == key) {
				return pos;
			}
			pos++;
			current = current.next;
		}

		return -1;

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();    //head=null;tail=nu;;,size=0; because default value of class is NULL(Node)
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(4);
		//list.addNode(1);
		list.addNode(6);
		list.display();
		//list.head=list.removeDuplicates(list.head);
			//Node l=list.tail;
		//list.head=list.reverseLinkedList(list.head);
		//System.out.println(list.head.data);
		//list.head=l;
	//list.display();
		//list.reverseR(list.head);
		//list.display();
		/*System.out.println("Linkedlist------------------");
		list.display();
		System.out.println("Linkedlist after 8 is added to start------------------");

		list.addNodeatStart(8);
		list.display();
		System.out.println("Linkedlist after sorted insert of 10------------------");

		list.addsortedinsert(10);
		list.display();
		System.out.println("Linkedlist after deletion of first node------------------");
		System.out.println("size" + list.size);

		list.deleteFirst();
		list.display();

		System.out.println("size" + list.size);
		list.deleteNodeByValue(7);
		System.out.println("Linkedlist after deletion of  node by value 7------------------");
		list.addsortedinsert(55);

		list.display();
		list.deleteAllOccurances(55);
		System.out.println("Linkedlist after deletion of all occurances of 55");
		list.display();
		System.out.println("Search of 0:" + list.search(0));*/
		
		//list.deleteLinkedList();
	
		//list.reverseLinkedList();
		//list.head=list.reverseLinkedListRecirsively(list.head,null);
		////System.out.println("----");
		//list.display();
		//list.addsortedinsert(10);
		//System.out.println();
		//list.display();
		
		//System.out.println("Get first: "+list.getFirst());
		//System.out.println("Get Last: "+list.getLast());
	/*	System.out.println("Get At index 1: "+list.getAt(1));
		list.display();
		list.AddNodeAt(100, 2);
		System.out.println();*/
		//System.out.println(list.deleteFirst());
		///System.out.println("Get first: "+list.getFirst());
		//System.out.println("Get Last: "+list.getLast());
		//list.display();
		//System.out.println("Get first: "+list.getFirst());
		//System.out.println("Get Last: "+list.getLast());
		//list.deleteLast();
		//System.out.println("Get first: "+list.getFirst());
		//System.out.println("Get Last: "+list.getLast());
		//list.deleteNodeByIndex(1);
		//list.display();
		//list.reverseData();
		//list.display();
		//System.out.println(list.deleteNodeByValue(7));
		//list.display();
		list.getMid();
		
	}

	private int deleteFirst() {
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
	
	
	//O(n)
	private int deleteLast() throws Exception {
		// TODO Auto-generated method stub

		Node curr=head;
		int ele=tail.data;
		
		if (curr == null || size==0)
			return -1;
		else if(size==1)
		{
			head=tail=null;
		}
		else
		{
		
			
			Node n=getNodeAt(size-2); 
			tail=n;
			tail.next=null;
			
			
			//OR
			/*while(curr.next!=tail)
			{
			
				curr=curr.next;
			}
			curr.next=null;
			tail=curr;*/
			
		}
			
			size--;
		return ele;
		
	}

	public int deleteNodeByValue(int del) {
		Node curr = head;
		if (curr == null)
			return -1;

		if (curr.data == del) {
			head = head.next;
			size--;
			return curr.data;
		}

		while (curr != null) {
			if (curr.next.data == del) {
				int ele=curr.next.data;
				curr.next = curr.next.next;
				size--;

				return ele;
			}
			curr = curr.next;
		}

		return -1;
	}

	
	
	
	
	//O(n)
	public int deleteNodeByIndex(int idx) throws Exception {
		Node curr = head;
		int ele;
		if (idx<0 && idx>=size)
			return -1;
		else if(size==1 && idx==0)
		{
			 ele=head.data;
			head=tail=null;
		}
		else if(idx==size-1)
		{
			ele=tail.data;

			Node n=getNodeAt(size-2); 
			tail=n;
			tail.next=null;
		}
		else
		{
			Node n=getNodeAt(idx-1);
			 ele=n.next.data;
	       n.next=n.next.next;
		}
size--;
		return ele;
	}
	
	
	
	
	
	
	
	public void deleteAllOccurances(int key) {
		Node curr = head;
		Node nextnode;
		if (curr == null)
			return;
		
		
//if first node needs to be deleted
		if (curr != null && curr.data == key) {
			head = curr.next;
			size--;
			curr = head;
		}

		while (curr != null) {
			nextnode = curr.next;
			if (nextnode != null && nextnode.data == key) {
				size--;
				curr.next = nextnode.next;
			} else
				curr = nextnode;
		}

	}
	
	
	//to delete linkedlist just mark head to null
	public void deleteLinkedList()
	{
		head=null;
		size=0;
	}
	
	
	public Node reverseLinkedList(Node head)
	{
		   
	        Node prev=null;
	        Node curr=null;
	        
	        Node nextnode=head;
	        
	        
	        while(nextnode!=null)
	        {
	            curr=nextnode;
	            nextnode=nextnode.next;
	            curr.next=prev;
	            prev=curr;
	        
	        }
	        
	        return curr;
	        
		
		/*//iterative approach O(n)
		Node curr=head;
		Node next=null;
		Node prev=null;
		while(curr!=null)
		{
			 next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;*/
		
		/*if(head==null)
	        return null;
	        
	        
	        Node n=reverseLinkedList(head.next);
	        System.out.println("inside "+head.data);
	        if(n!=null)
	        n.next=head;
	        
	        return head;*/
	}
	
	
	public Node reverseLinkedListRecirsively(Node head,Node prev)
	{
		
		//Recursive approach O(n),space O(n)  for every call stack
		if(head==null)
			return prev;
		
			 Node next=head.next;
			head.next=prev;
			prev=head;
			head=next;
			
			return reverseLinkedListRecirsively(head, prev);
	
	}
	public void reverseData() throws Exception
	{
	int left=0;
	int right=this.size-1;

	while(left<right)
	{
	Node ln=getNodeAt(left);
	Node rn=getNodeAt(right);
	System.out.println(ln);
	System.out.println(rn);
		int temp=ln.data;
		ln.data=rn.data;
		rn.data=temp;
	left++;
	right--;
	}

	}
	
/*	public void removeDuplicates()
	{
		
		Node curr=head;   // 5 0 9 8 9
		
		while(curr!=null)
		{
			addsortedinsert(curr.data);
			curr=curr.next;
		}
		Node currr=head;
		while(currr!=null)
		{
			if(currr.data==currr.next.data)
			{
				currr.next=currr.next.next;
			}else {
				currr=currr.next;
			}
			
		}
		
		
		
	}
	*/
	public Node removeDuplicates(Node head) 
    {
         // Your code here
         if(head==null)
         return head;
                      Node prev=head;

         Node curr=head;
         
         while(curr!=null && curr.next!=null)
         {
             Node temp=curr.next;
             prev=curr;
             while(temp!=null)
             {
                 
                 if(curr.data==temp.data)
                 {
                     prev.next=temp.next;
                     temp=temp.next;
                 }
                 else
                 {
                 temp=temp.next;
                 
                 prev=prev.next;
                 }
             }
         curr=curr.next; 
             
         }
         
         return head;
    }

public void getMid()
{
	Node curr=this.head;
	Node next=curr;


	while(next!=null && next.next!=null)
	{
		curr=curr.next;
		next=next.next.next;
	}
	System.out.println(curr.data);
}

}
