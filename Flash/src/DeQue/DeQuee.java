package DeQue;

import java.util.ArrayDeque;

//Deque implementation in Java
class DeQuee
{
	
	public static void main(String[] args) {

	/*	ArrayDeque<Integer> dq=new ArrayDeque<>();
		
		
		dq.offerFirst(10);
		dq.offerFirst(20);
		dq.offerFirst(30);
		dq.offerLast(100);
		dq.offerLast(200);

		dq.offerLast(300);
	
		System.out.println(dq);
		dq.pollFirst();
		dq.pollLast();
		System.out.println(dq);
*/
		
		DequeUsingArray dq=new DequeUsingArray();
		dq.insertAtfront(10);
		
		dq.insertAtfront(20);
		dq.insertAtfront(30);
		dq.insertAtrear(100);
		dq.insertAtrear(200);
		dq.insertAtrear(300);
		
		System.out.println("front:"+dq.getFront());
		System.out.println("Rear :"+dq.getRear());
		dq.deletefront();
		dq.deleterear();
		dq.display();
		System.out.println("front:"+dq.getFront());
		System.out.println("Rear :"+dq.getRear());

		}
}














class DequeUsingArray {
	
static final int MAX = 10;
int ar[];
int front;
int rear;
int size;

public DequeUsingArray()
{
this(MAX);	
}


public DequeUsingArray(int size) {
 ar = new int[size];
 front = -1;
 rear = -1;
 this.size = 0;
}







	boolean isFull() {

		if (size == ar.length || front == rear + 1)
			return true;

		return false;
	}

	
	boolean isEmpty() {
		if ((front == -1 && rear == -1) || size == 0)
			return true;

		return false;

	}

	
	
	
void insertAtfront(int key) {
 if (isFull()) {
   System.out.println("Overflow");
   return;
 }

 if (front == -1) {
   front = 0;
   rear = 0;
 }
 else if (front == 0)
 {
  
   
   
   for(int i=rear;i>=front;i--)
   {
	 ar[i+1]=ar[i];
	   
   }
   rear=rear+1;
 }
 else
   front = front - 1;

 ar[front] = key;
 
 
 size++;
}





void insertAtrear(int key) {
	
 if (isFull()) {
   System.out.println(" Overflow ");
   return;
 }

 if (front == -1) {
   front = 0;
   rear = 0;
 }
 else
   rear = rear + 1;

 ar[rear] = key;
 
 
 size++;
}

void deletefront() {
 if (isEmpty()) {
   System.out.println("Queue Underflow\n");
   return;
 }

 // Deque has only one element
 

 if (front == rear) {
   front = -1;
   rear = -1;
 } 
 else
 {
	 ar[front]=0;
   front = front + 1;
 }
 
 
 size--;
}

void deleterear() {
 if (isEmpty()) {
   System.out.println(" Underflow");
   return;
 }

 ar[rear]=0;
 if (front == rear) {
   front = -1;
   rear = -1;
 } 
 else
   rear = rear - 1;
 
 size--;
}

int getFront() {
 if (isEmpty()) {
   System.out.println(" Underflow");
   return -1;
 }
 return ar[front];
}

int getRear() {
 if (isEmpty()) {
   System.out.println(" Underflow\n");
   return -1;
 }
 return ar[rear];
}

public void display()
{
	System.out.println("front to rear 0 means empty");
for(int i:ar)
{
System.out.print(i+" ");	
}
}
}



















class Deque {
static final int MAX = 100;
int arr[];
int front;
int rear;
int size;

public Deque(int size) {
 arr = new int[MAX];
 front = -1;
 rear = 0;
 this.size = size;
}

boolean isFull() {
 return ((front == 0 && rear == size - 1) || front == rear + 1);
}

boolean isEmpty() {
 return (front == -1);
}

void insertfront(int key) {
 if (isFull()) {
   System.out.println("Overflow");
   return;
 }

 if (front == -1) {
   front = 0;
   rear = 0;
 }

 else if (front == 0)
   front = size - 1;

 else
   front = front - 1;

 arr[front] = key;
 size++;
}

void insertrear(int key) {
 if (isFull()) {
   System.out.println(" Overflow ");
   return;
 }

 if (front == -1) {
   front = 0;
   rear = 0;
 }

 else if (rear == size - 1)
   rear = 0;

 else
   rear = rear + 1;

 arr[rear] = key;
 size++;
}

void deletefront() {
 if (isEmpty()) {
   System.out.println("Queue Underflow\n");
   return;
 }

 // Deque has only one element
 if (front == rear) {
   front = -1;
   rear = -1;
 } else if (front == size - 1)
   front = 0;

 else
   front = front + 1;
 
 size--;
}

void deleterear() {
 if (isEmpty()) {
   System.out.println(" Underflow");
   return;
 }

 if (front == rear) {
   front = -1;
   rear = -1;
 } else if (rear == 0)
   rear = size - 1;
 else
   rear = rear - 1;
 
 size--;
}

int getFront() {
 if (isEmpty()) {
   System.out.println(" Underflow");
   return -1;
 }
 return arr[front];
}

int getRear() {
 if (isEmpty() || rear < 0) {
   System.out.println(" Underflow\n");
   return -1;
 }
 return arr[rear];
}


}



