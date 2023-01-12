package DeQue;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
	
	/*
	 * 1)Brute force O(nk)   for n elements k times each in for loop
	 * 2)priority queue element when popped then logk operation because it removes max element from queue O(nlogk)
	 * 3)Deque because elements needs to be added from one side and remove(which are not part of the window) from front side. O(n)
	 */
	
	public static void main(String[] args) {
		
		int[] ar= {1 ,3 ,-1, -3,-5 ,3, 6 ,7};
		
		List<Integer> ans=findMax(ar,3);
		System.out.println(ans);
		
	}

	private static ArrayList<Integer> findMax(int[] ar, int k) {
	
		ArrayList<Integer>  ans=new ArrayList<>();
		
		//need  DeQue of size K
		DequeUsingArrayy queue=new DequeUsingArrayy(k+1);
		
		for(int i=0;i<k;i++)
		{
			
			while(!queue.isEmpty() && queue.getRear()<ar[i])
			{
				queue.deleterear();
			}
			queue.insertAtrear(ar[i]);
		}
		
		ans.add(queue.getFront());
		
		
		for(int i=k;i<ar.length;i++)
		{
			
			//Remove all the elements which are not part of the window (contraction)
			if(queue.getFront()==ar[i-k])
			{
				
				queue.deletefront();
			}
			
			//Remove the elements which are not useful and still part of the window
			while(!queue.isEmpty() && queue.getRear()<ar[i])
			{
				queue.deleterear();
			}
			
			//add the element (Expansion)
			queue.insertAtrear(ar[i]);
			
			
			ans.add(queue.getFront());
		}
		return ans;
	}

}





 class DequeUsingArrayy {
	
static final int MAX = 10;
int ar[];
int front;
int rear;
int size;

public DequeUsingArrayy()
{
this(MAX);	
}


public DequeUsingArrayy(int size) {
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





