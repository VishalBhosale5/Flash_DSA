package Hashing;

//User  defined  type of data in linkedlist of hashtable
public class HashMapConstruct<K, V> {

	public class HTPair {

		K key;
		V value;

		public HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		
		public boolean equals(Object other)
		{
			
			HTPair otherpair=(HTPair)other;
			//keys compared
			return this.key.equals(otherpair.key);
		}
		
		public String toString()
		{
			return "{"+this.key+"-"+this.value+"}";
		}

	}
public static final int DEFAULT_CAPACITY1=10;
	private GenericLinkedLIst<HTPair>[] bucketArray;
	public int size;
	public HashMapConstruct() {
		this(DEFAULT_CAPACITY1);
	}
	public HashMapConstruct(int defaultCapacity1) {
		
		this.bucketArray=(GenericLinkedLIst<HTPair>[]) new GenericLinkedLIst[defaultCapacity1];
	}
	
	
	
	public void put(K key,V value) throws Exception
	{
		int index=HashFunction(key);
		
		GenericLinkedLIst<HTPair> bucket=this.bucketArray[index];
		HTPair pair=new HTPair(key, value);
		if(bucket==null)
		{
			bucket=new GenericLinkedLIst<HTPair>();
			
			bucket.addNode(pair);
			bucketArray[index]=bucket;
			size++;
		}else
		{
			int find=bucket.search(pair);
			
			if(find!=-1)
			{
				
			HTPair pairr=bucket.getAt(find);
			pairr.value=value;
			}
			else
			{
				bucket.addNode(pair);
				this.size++;
			}
		}
		
		
		
		
		double lambda=(this.size*1.0)/this.bucketArray.length;
		//practically labda is 0.75  means when more than 3/4 elements are filled then rehashing is done
		//hence O(1)
		if(lambda>2)
		{
			System.out.println("rehasing is --------");
			this.rehash();
		}
		
	}
	private void rehash() throws Exception {
		
		
	GenericLinkedLIst<HTPair>[] oba= this.bucketArray;
	this.bucketArray=(GenericLinkedLIst<HTPair>[]) new GenericLinkedLIst[3*oba.length];
	this.size=0;
	
	
	for(GenericLinkedLIst<HTPair> list:oba)
	{
		while(list!=null && list.size!=0)
		{
			HTPair pair=list.deleteFirst();
			this.put(pair.key, pair.value);
		}
		
	}
		
	}
	private int HashFunction(K key) {
			int hashcode=key.hashCode();
			
		return Math.abs(hashcode) % this.bucketArray.length;
	}
	
	
	
	public void display()
	{
		
		for(GenericLinkedLIst<HTPair> l:this.bucketArray)
		{
			/*GenericLinkedLIst<HashMapConstruct<K, V>.HTPair>.Node curr=l.head;
			
			while(curr.next!=null)
			{
				System.out.print(curr+"  ");
				curr=curr.next;
				
			}*/
			if(l!=null && l.size!=0)
			l.display();
			else
				System.out.println("NULL");
			System.out.println("---------------------------------");
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$---");
	}
	
	public V remove(K key) throws Exception
	{
		int hashcode=HashFunction(key);
		
		GenericLinkedLIst<HTPair> list=bucketArray[hashcode];
		HTPair ptf=new HTPair(key,null);
		
		if(list==null)
		{
			return null;
		}
		else
		{
			int idx=list.search(ptf);
			HTPair pair=list.getAt(idx);
			list.deleteNodeByIndex(idx);
			this.size--;
			return pair.value;
		}
		
		
	}
	
	
	
	public V get(K key) throws Exception
	{
		
		int hashcode=HashFunction(key);
		
		GenericLinkedLIst<HTPair> list=bucketArray[hashcode];
		HTPair ptf=new HTPair(key,null);
		
		
		if(list==null)
		{
			return null;
		}
		else
		{
			int idx=list.search(ptf);
			
			HTPair pair=list.getAt(idx);
			
			return pair.value;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		HashMapConstruct<String , Integer> map=new HashMapConstruct<String, Integer>(2);
		
		
		map.put("USA", 1000);
		map.put("Sweden", 300);
		map.put("India", 1200);
		map.put("China", 350);
		
	//	System.out.println(map);
		map.display();
		//System.out.println(map.get("USA"));
		
		//map.remove("Sweden");
		System.out.println("------------");
		map.put("China", 456);
		map.put("RSA", 100);
		map.display();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
