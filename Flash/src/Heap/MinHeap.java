package Heap;

import java.util.ArrayList;

public class MinHeap {
	
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
		if(data.get(childidx)< data.get(parentidx))
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
	
	private void downHeapify(int parent) {
	
		
		int leftchildindex=2*parent+1;
		int rightchildindex=2*parent+2;
		int minidx=parent;
		
		if(leftchildindex <this.data.size())
		{
		
		if(data.get(leftchildindex)<data.get(minidx))
			minidx=leftchildindex;
		}
		
		if(rightchildindex <this.data.size())
		{
		if(data.get(rightchildindex)<data.get(minidx))
			minidx=rightchildindex;
		}
		if(minidx!=parent)
		{
		swap(minidx,parent);
		downHeapify(minidx);
		}
		
	}

	
	public int get()
	{
		return this.data.get(0);
	}

	public static void main(String[] args) {
		
		MinHeap minHeap=new MinHeap();
		
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
		minHeap.display();
	}
}
