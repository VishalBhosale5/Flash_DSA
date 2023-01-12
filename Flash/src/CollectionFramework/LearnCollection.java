package CollectionFramework;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class LearnCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * Java provides collection framwork which defines several classes and interfaces to represent a group of objectsas a single unit.
		 * Array Limitations-not dynamic,contains duplicates
		 * 
		 * Iterable(interface):iterator
		 *		 Collection(interface):(size(),isEmpty(),add(element),addAll(Collection),remove(element),removeAll(Collection),retainAll(Collection),contains(element),containsAll(Collection),clear())
		 * 				List(interface)(Ordered):(add(Object o),get(int index),set(int index,Object o),indexOf(Object o),astIndexOf(Object o),subList(int fromindex,int toindex)
		 * 					ArrayList(class)
		 * 					LinkedLIst(class)
		 * 					Vector(class)
		 * 						Stack(class)
		 * 				Set(interface)(unique):
		 * 					[Unsorted]
		 * 						HashSet(class)
		 * 						LinkedHashSet(class)
		 * 					[Sorted]
		 * 						TreeSet(class)
		 * 				Queue(interface):
		 * 						PriorityQueue(class)
		 * 					[Deque]
		 * 						ArrayDeque(class)
		 * 	
		 * 				Map(interface):
		 * 					[Unsorted]
		 * 						HashMap(class)
		 * 						LinkedHashMap(class)
		 * 					[Sorted]
		 * 						TreeMap(class)
		 * 			
		 */
		
		//ArrayList
	/*	ArrayList<Integer> l=new ArrayList<>();  //initial capacity is 10. when it exceeds then arraylist call grow method which adds oldcapacity+(oldcapacity>>1)   means 10+5= 15
		l.add(1);
		l.add(11);
		l.add(12);
		l.add(13);
		
		ArrayList<Integer> l2=new ArrayList<>(); 
		l2.add(11);
		l.addAll(l2);
		
		System.out.println(l);
		System.out.println(l.subList(1, 4));
		System.out.println(l.set(1,21));
		System.out.println(l);
		
		
		Iterator<Integer> it=l.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		*/
		
		//LinkedLIst   -doublyLinkedLIst by default  ,non contegious storage
		
		
/*		LinkedList<Integer> list=new LinkedList<>();
		list.add(1);
		list.add(11);
		list.add(12);
		list.add(13);
		
		list.add(4,14);
	
		//ArrayList<Integer> l2=new ArrayList<>(); 
		//l2.add(21);
		//list.addAll(l2);
		
		//System.out.println(list);
		//System.out.println(list.subList(1, 4));
		//System.out.println(list.set(1,21));
		System.out.println(list.get(0));
		//removeFirstOccurance,removeLastOuucrance,poll,peek,polllast,pollfirst
		
		//random insertion is not possible
		Iterator<Integer> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		ArrayList<Integer> ar=new ArrayList<>();
		ar.add(5);
		ar.add(10);
		ar.add(88);
		//ar.add(5,6);
		
		System.out.println(ar);
		//VECTOR		
		//indexed,thread safe,resizable
		//initial capacity=10,, arraylist=initial+initial>>1   means devide by 2
		//vector double the original size
		//vector is used in multithreading and it is slow as compared to list
		Vector v=new Vector<>();
		v.ensureCapacity(20);
		v.add(5);
		v.add(10);
		v.add(30);
		//v.add(5,6);
		
		ListIterator<Integer> l=v.listIterator();
		while(l.hasNext())
		{
			System.out.println(l.next());
		}
		
		while(l.hasPrevious()) { 
			System.out.println(l.previous());
			}
		*/
		
		
		//difference between araylist,vector and linkedlist
		
		/*indexed:arraylist,vector
		multithreading:vector
		adding at midle,first and lst:linkedlist
		access: arraylist and vector
		insertion ---linkedlist
		
		
		operation            linkedlist   arraylist               vector
		add					O(1)         O(1),O(N) (amortized)     O(1),O(N)(amortized in case of arrayfull)
		
		ad(index,object)    O(N)          O(N)                     O(N)
		
		get(index)          O(N)          O(1)                     O(1)
		 
		remove(object)      O(N)          O(N)                     O(N)                (shifting)
		
		remove(int)         O(N)          O(N)                     O(N)             (shifting)
*/ 
		
		
		//set
		
		//uses hashmap internally
		//not indexed,unique,sorted
		//hashset,
		//linkedhashset(preserves order) uses linkedhashmap which uses doubly linkedlist to preserve order
		//treeset(sorted) not using hashing,uses treemap internally which uses red black tree(self balancing)(logn)   
		//slower than hashset and linkedhashset
		
/*		
		HashSet<Integer> set=new HashSet<>();
		set.add(1);
		set.add(5);
		set.add(6);
		set.add(8);
		
		
		
		Iterator itr=set.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		
		LinkedHashSet<Integer> ls=new LinkedHashSet<>();
		ls.add(1);
		ls.add(2);
		ls.add(4);
		
		
		TreeSet<String> trset=new TreeSet<>();
		trset.add("z");
		trset.add("bb");
		trset.add("ab");
		trset.add("aa");
		
		System.out.println(trset);
		
		SortedSet<String> s=trset.headSet("n");
		System.out.println(s);
		SortedSet<String> ss=trset.tailSet("n");
System.out.println(ss);
System.out.println(trset.pollFirst());*/
		
		
		
		//Queue
		//interface follows FIFO 
		//implemented by linkedlist or priority queue
		//queue peek+remove=poll
		/*
		
		Queue que=new LinkedList<>();
		que.add(1);
		que.add(2);
		que.add(5);
		System.out.println(que.peek());
		System.out.println(que.remove());
		System.out.println(que.poll());
		System.out.println(que);
		
		
		
		Queue q=new PriorityQueue<>();
		q.add(5);
		q.add(8);
		q.add(3);
		q.add(7);
		q.add(1);
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
	*/
		
		
		//Stack is class
		//stack follws LIFO
		//extends vector means thread safe
		/*
		Stack<Integer> s=new Stack<>();
		s.add(1);
		s.add(5);
		s.add(6);
		System.out.println(s.pop());
		System.out.println(s.push(10));*/
		
		//MAP
		// come under collection framework ,   doesn't inherit collection interface
		//sorted and unsorted map
		
		//Hashmap
		//uses hashing,fast lookup time
		//each object has hashcode method,hashcode of key is calculated not of value
		// hashcode & (n-1)    n is size of bucket
		//bucket can be trees from java  8 to efficient look up time
		
		
		/*HashMap<String,String> map=new HashMap<>();
		
		map.put(null, null);
		map.put("nul", "B");
		map.put("A", "B");
		System.out.println(map);*/
		
		
		//linkedhashmap  ,,uses doubly linked list internally and maintains the order
		//array of buckrt inside which node has before and after pointer which keeps track of next and prev element
		
		
		LinkedHashMap<Integer, String> map=new LinkedHashMap<>();
		map.put(1, "Hi");
		
		//Treemap
		//does not use hashing
		//elements sorted on basis of keys natural order
		//uses red black tree (self balancing tree)
		//comparator can be used to change sorting order
		//slower logn time for all operation
		
		
		TreeMap<Integer,String> t=new TreeMap<>();
		t.put(1, "one");
		t.put(2, "Two");
		t.put(5, "hi");
		System.out.println(t.keySet());
		System.out.println(t.values());
		System.out.println(t.tailMap(2));
		
		
	}

}
