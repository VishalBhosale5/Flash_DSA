package OOPandStacks;

public class OOP {

	
	
	/*
	 * 
	 * C is procedural language/structural lang
	 * c++ is a object oriented language
	 * Java came due to Platform independance and oops
	 * 
	 * we can't describe everything in functions thats why OOPS came after C language
	 * 
	 * NOUN-- create classes
	 * VERB-- create functions   what can they do like /jump/run/
	 * Adjective--members    //colour,size
	 */
	public static void main(String[] args) {
		Student s=new Student();
		/*
		 * 1) first oop class checks the dependancy 
		 * 2) student class blueprint is brought into heap first than oop
		 * 3)new keyword allocates the memory in heap with default initializations at some memory address 2k which is retured to LHS s  //instance
		 * 4)now s (in stack memory) has the address of a memory location of heap which has that student object  //reference variable
		 * 5) we assigned type as Student to s because s is pointing to a memery locatin which has the data of type Student
		 * when we use . operator to call object methods then this (context) is passed to the function with the values same as instance
		 * this is only used with class data members not with local function variables
		 */
	}
	
	
	/*
	 * 
	 * Constructor are used to initialize the object
	 * no return type
	 *   1)memory allocation in heap with default values
	 *   2)parser //check the class member initialization explicit values  stirng name="abc";
	 *   3)construct call   //then it will assign its values this.val=val;
	 *   
	 *   constructor overloading means we write parameterized constructor
	 */
	
	
}


class Student
{
String name;
int age;

}