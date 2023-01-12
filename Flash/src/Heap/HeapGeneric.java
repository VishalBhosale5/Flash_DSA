package Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class HeapGeneric<T extends Comparable<T>> {
	
	//we can use arraylist instead of array 
	
	ArrayList<T> data=new ArrayList<>();
	
	
	//for graph
	
	public HashMap<T,Integer> map=new HashMap<>();
	
	public void add(T item)
	{
		
		
		data.add(item);
		//as we have added data at last 
		map.put(item, this.data.size()-1);
		upHeapify(data.size()-1);
	}


	public void upHeapify(int childidx) {
		//base case not req.
		
		
		int parentidx=(childidx - 1)/2;
	
		if(isLarger(data.get(childidx),data.get(parentidx))>0)
		{
			swap(childidx,parentidx);
			upHeapify(parentidx);
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
		T ith=data.get(i);
		T jth=data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
		map.put(ith, j);
		map.put(jth, i);
	}
	
	
	
	public T delete()
	{
		
		swap(0,this.data.size()-1);
		T rm=this.data.remove(this.data.size()-1);
		
		downHeapify(0);

		map.remove(rm);
		
		return rm;
	}
	
	private void downHeapify(int parent) {
	
		
		int leftchildindex=2*parent+1;
		int rightchildindex=2*parent+2;
		int minidx=parent;
		
		if(leftchildindex <this.data.size())
		{
		
		if(isLarger(data.get(leftchildindex),data.get(minidx))>0)
			minidx=leftchildindex;
		}
		
		if(rightchildindex <this.data.size())
		{
		if(isLarger(data.get(rightchildindex),data.get(minidx))>0)
			minidx=rightchildindex;
		}
		if(minidx!=parent)
		{
		swap(minidx,parent);
		downHeapify(minidx);
		}
		
	}
	
	public int isLarger(T t1,T t2)
	{
		//min heap
		return t2.compareTo(t1);
		
		//max heap
		//return t1.compareTo(t2);
	}

	public void updatePriority(T pair)
	{
		
		int idx=map.get(pair);
		
		upHeapify(idx);
		
		
	}
	public T get()
	{
		return this.data.get(0);
	}

	public static void main(String[] args) {
		
	
	Car car=new Car("BMW",2000,"Blue");
	Car car1=new Car("Honda",1000,"White");
	Car car2=new Car("SUZUKI",800,"Green");
	Car car3=new Car("Mercedezes",1200,"ORANGE");
	Car car4=new Car("TATA",1500,"Blue");
	HeapGeneric<Car> heap=new HeapGeneric<Car>();
	heap.add(car);
	heap.add(car1);
	heap.add(car2);
	heap.add(car3);
	heap.add(car4);
	
	while(heap.size()!=0)
		System.out.println(heap.delete());
	
	}
}
