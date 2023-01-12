package Hashing;


public class GenericLinkedLIst<T> {
	class Node {
		T data;
		Node next;

		public Node(T data) {
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
	
	
	//O(n)
	public void addNode(T data) {
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
	
	
	public void addNODE(Node n)
	{
		if (head == null) {
			head = n;
			tail = n;
			size++;

		} else {
			// add node to the last

			tail.next = n;
			tail = n;
			size++;
		}
	}
	
	
	
	//O(1)
	public void addNodeatStart(T data) {
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
	public T getFirst() throws Exception
	{
		if(this.head!=null)
			return this.head.data;
		else
			throw new Exception("LL is empty");  //since this is dangerous function we should mark it same as throws
	}
	
	
	//O(1)
	public T getLast() throws Exception
	{
		if(this.tail!=null)
			return this.tail.data;
		else
			throw new Exception("LL is empty");  //since this is dangerous function we should mark it same as throws
	}
	
	//O(n)
	//O(1)
		public T getAt(int idx) throws Exception
		{
			
			if(this.size==0 && idx>=size && idx<0)
				return null;
			Node curr=head;
			int i =0;
			
			while(curr!=null)
			{
				
				if(i==idx)
					return curr.data;
				i++;
				curr=curr.next;
			}
			return null;
		}
		
		public T deleteFirst() {
			// TODO Auto-generated method stub

			Node current = head;
			T ele=head.data;
			if (current == null || size==0)
				return null;
			else if(size==1)
			{
				
				head=tail=null;
				
			}
			else
				head = current.next; //because head has address of the next node stored in next
				
				size--;
	return ele;
			
		}

		 Node getNodeAt(int idx) throws Exception
		{
			
			if(this.size==0 && idx>=size && idx<0)
				return null;
			
			Node curr=head;
			int i =0;
			
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
		public void AddNodeAt(T item,int idx)throws Exception
		{
			if(idx>size || idx<0)
				return;
			
			
			if(idx==0)
				addNodeatStart(item);
			else if(idx==this.size)
				addNode(item);
			else
			{
				
			Node prev=getNodeAt(idx-1);
			
			Node newnode=new Node(item);
			
			newnode.next=prev.next;
			
			prev.next=newnode;
			
			
			
			}
			this.size++;
		}
/*	private void addsortedinsert(T i) {
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

	}*/

	public void display() {
		Node current = head;   //initially head has address of first node

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		while (current != null) {
			System.out.print(current.data);
			current = current.next;    //accessing address of next nodes and printing the data from that node
		}
		System.out.println();

	}

	public int search(T key) {
		Node current = head;
		int pos = 0;
		
		while (current != null) {
			if (current.data.equals(key)) {
				return pos;
			}
			pos++;
			current = current.next;
		}

		return -1;

	}
	
	public static void main(String[] args) {
		
		
				
	}
	
	public T deleteNodeByIndex(int idx) throws Exception {
		Node curr = head;
		T ele;
		if (idx<0 && idx>=size)
			return null;
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
}
