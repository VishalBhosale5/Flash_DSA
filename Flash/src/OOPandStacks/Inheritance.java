package OOPandStacks;

public class Inheritance {
	public static void main(String[] args) {
		
	//Every class is a child of Object class
		Object P=new P(); //valid
		//data members are resolved differently and function resolved differently
		//when we write code control is in compiler's hand which checks left hand side of expression but it runtime jvm's hand which checks right hand rhs side of expression.
		//if parrent and child has same vairables then parent's variable is picked //ambiguity resolved by reference which is of parent
		//if partent and child has same methods then childs method executed
		//
		P p=new C();
		System.out.println(p.d1);
		System.out.println(((C)p).d1);  //to execute childs variable in case of collision by type casting
		System.out.println(((P)p).d1);
		p.fun();
		((P)p).fun();
		/*compiler checks left side and JVM checks right side
		 * 
		 * 
		//variables of P are access an functions of child
		in above statement 
		if want to execute parents method then no ways than making P p=new P();
		as typecast will not work to access parent class method\
		((P)p).fun(); //will still execute clilds method because runtime has child's data in heap
		((P).d)   then parent var is acessed in case of collitions as well
		*/
		//When collitions happened with variables then resolved by reference varaible(P in above case and variables of P class access)
	//when collition happen for methods then childs picked 
		
		
		//p.d3 is givind error because p class don't have d3 variable so we need to ask compiler to stay quit using casting

		//System.out.println(((C)p).d3);
		//
		//when main class has some object defenition then jvm checks the dependancy and loads it into the heap memory
		//then object assigned values and called using . operators
		
		
		//System.out.println("case 1");
		//P pp=new P();
		//pp has all access to all the P class data members and functions 
		//System.out.println("case 2");
		//P obj=new C();
		//obj has access to P's data members and functions +C's data member and functions
		//but when same functionn in child and parent then variables are picked from parent and function are executed from child but when child dont have that method then parents executed
		
		
		//System.out.println("case 3");
		//C c=new P();
		
		//above line is not allowd because runtime error is worst than compile time
		//here memeory allocated to all the P members but not of C hence error
		
		
		//System.out.println("case 4");
		//C cc=new C();
		
		//all the P's and C's data is available
		//variables are of C and functions are of C if not found then P as well because it is parent
	
		
		//
		
		
		
		
		
		
		
		
		
		
		//method overloading possible using below condition
	/*	1)no of arguments
		2)type of arguments
3)not on the basis of return type*/
		
		//for any function at max one variable arguments can be possible and it should br at last parameter
		//variable arguments are nothing but arrays and we can pass array to that function as wll
	/*	//public void sum(int... args)
		{
			int sum=0;
			for(int i:args)
				sum+=i;
			
			System.out.println(sum);
		}*/
	}
	

}


class P
{
int d=10;
int d1=100;

public void fun()
{
System.out.println("P fun()");	
}
public void fun1()
{
System.out.println("P fun()1");	
}
}


class C extends P
{
int d1=20;
int d2=200;
int d3=900;
public void fun()
{
System.out.println("C fun()");	
}
public void fun1()
{
System.out.println("C fun()1");	
}
}