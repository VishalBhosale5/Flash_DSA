package Heap;

import java.util.ArrayList;

public class MaxHeap {
	
	//we can use arraylist instead of array 
	
	ArrayList<Integer> data=new ArrayList<>();
	
	
	public void add(int item)
	{
		
		
		data.add(item);
		//as we have added data at last 
		upHeapify(data.size()-1);
	}


	private void upHeapify(int childidx) {
		//base case not req.
		
		
		int parentidx=(childidx-1)/2;
		if(parentidx>=0)
		{
		if(data.get(childidx) > data.get(parentidx))
		{
			swap(childidx,parentidx);
			upHeapify(parentidx);
		}
		
		}
	/*	display();
		System.out.println(data.size());*/
		
	}
	
	public void display()
	{
		System.out.println(data);
	}
	
	public int size()
	{
		return data.size();
	}
	public boolean isEmpty()
	{
		return this.size()==0;
	}

	private void swap(int i,int j)
	{
		int ith=data.get(i);
		int jth=data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
		
	}
	
	
	
	public int delete()
	{
		
		swap(0,this.data.size()-1);
		int rm=this.data.remove(this.data.size()-1);
		
		downHeapify(0);

		
		
		return rm;
	}
	
	
	 int[] heap_sort(int Arr[ ])
	    {
	        
	        MaxHeap heap=new MaxHeap();
	        
	        for(int i :Arr)
	        {
	        	heap.add(i);
	        }
	        int[] ans=new int[Arr.length];
	        for(int i = Arr.length-1; i>0 ; i-- )
	        {
	          
	            ans[i]=heap.delete();
	        }
	        
	        return ans	;
	    }
	
	private void downHeapify(int parent) {
	
		
		int leftchildindex=2*parent+1;
		int rightchildindex=2*parent+2;
		int maxidx=parent;
		
		if(leftchildindex <this.data.size())
		{
		
		if(data.get(leftchildindex)>data.get(maxidx))
			maxidx=leftchildindex;
		}
		
		if(rightchildindex <this.data.size())
		{
		if(data.get(rightchildindex)>data.get(maxidx))
			maxidx=rightchildindex;
		}
		if(maxidx!=parent)
		{
		swap(maxidx,parent);
		downHeapify(maxidx);
		}
		
	}

	
	public int get()
	{
		return this.data.get(0);
	}

	public static void main(String[] args) {
		
		MaxHeap maxheap=new MaxHeap();
		int[] ar=maxheap.heap_sort(new int[] {9,5,2,3,10,59,32,5});
		
		for(int j:ar)
			System.out.print(j+" ");
		/*
		minHeap.add(10);
		minHeap.display();
		minHeap.add(20);
		minHeap.display();

		minHeap.add(30);
		minHeap.display();

		minHeap.add(5);
		minHeap.display();

		minHeap.add(0);
		minHeap.display();
		
		minHeap.delete();
		minHeap.display();
		minHeap.delete();
		minHeap.display();
		minHeap.delete();
		minHeap.display();*/
		
		
	}
}
