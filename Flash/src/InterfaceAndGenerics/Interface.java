package InterfaceAndGenerics;

import java.awt.DisplayMode;
import java.util.Comparator;

public class Interface {

	
/*	1) we cannot use new with interface means we cannot intantiate interface (if we could then it is not useful because it doesnt contains concrete methods)
 * 	2) Interface does not have constructor
 * 	3) all methods are public abstract
 * 	4) all vairables are public static final   //means it should be initialized  //access it using interface name
 *  5)classes implements interface and it should be implemented in class
 *  6) one interface can extend other interfaces //can extend multiple interfaces //classes cannot do it
 *  7) multiple inheritance can be achieved using interfaces
*/	
	
	
	
	
	
	//Generics
	// it will word for object types only not primitive
	public static void main(String[] args) {
		//String arr[]= {"Avi","Anil","NASA"};
		//display(arr);
		
		//Integer[] ar= {4,5,6,7,8,5};
		//display(ar);
		
		int[] arr= {9,4,3,5,23,6,8,-10,0};
		Student[] c=new Student[5];
		c[0]=new Student("A",3,300);
		c[1]=new Student("B",2,400);
		c[2]=new Student("C",1,500);
		c[3]=new Student("D",4,200);
		c[4]=new Student("E",5,100);

		
		bubblesortComparable(c);
		System.out.println();
		bubblesortComparator(c, new MarkComparator());
		System.out.println();
		bubblesortComparator(c, new RankComparator());
		
		
		Pair<String> p=new Pair();
		p.one="A";
		p.tow="ABc";
		
		
		Pairtwo<Integer,String,Float> pp=new Pairtwo();
		pp.three=10.0F;
		
		
	}

	//we do not need to write display functionn for every type
	public static <T> void display(T[] arr)
	{
		
		for(T s:arr)
			System.out.print(s);
		
		System.out.println();
	}
	
	
	
	
	
	//Generic bubble sort
	
	
	
	
	private static <T extends Comparable<T>> void bubblesortComparable(T[] arr) {
	
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j].compareTo(arr[j+1]) > 0)
				{
					T temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
		
		for(T i:arr)
			System.out.println(i+" ");
	
}
	private static <T> void bubblesortComparator(T[] arr,Comparator<T> comparator) {
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(comparator.compare(arr[j],arr[j+1]) >0)
				{
					T temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
		
		for(T i:arr)
			System.out.println(i+" ");
	
}
	
}


class Student implements Comparable<Student>
{
	// when we want to compare 1 thing then use comparable(compareTo) , it want to compare multiple things then comparator(compare).
	String name;
	int rank;
	int mark;
	
	
	
	Student(String name,int rank,int mark)
	{
		this.name=name;
		this.rank=rank;
		this.mark=mark;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rank=" + rank + ", mark=" + mark + "]";
	}
	@Override
	public int compareTo(Student o) {
		/*
		 * if this has more priority then return +ve value otherwise -ve value
		 * in this case if this rank is smaller then it has greater priority then i should return +ve value how can i return positive then
		 * if this rank is smaller then minus it from o's rank so that it will give -ve value
		 * if smaller value has hihgh priority then other.var-this.var
		 * if greater value has high priority then this.var-other.var
		 */
		return o.rank-this.rank;
	}
	
	
	

}


//if we do not wants to use comparable which only uses one logic to compare we can use comparator which can be used with multiple logic
//in case you want the comparison for 2 strings then use inbuilt sting.compareTo(string2) method in compare(String 1,string 2) method of comparatorr

 class RankComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		
		return o2.rank-o1.rank;
	}
	}
 class MarkComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.mark-o2.mark;
	}
	}

 
 //generic classes 
 // when we wants or know the member types 
 
 class Pair<T>
 {
	 T one;
	 T tow;
	 
	 
 }
 
 class Pairtwo<K,V,E>
 {
	 K one;
	 V two;
	 E three;
	 
 }
