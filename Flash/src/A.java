import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

interface i1
{
void run();	
}
interface i2 
{
void run();	

default void num()
{
run();	
}
}

class Parent implements i2
{
int a;
int b;
private int c;

void display()
{
	System.out.println(a+" "+b+" "+c);
}

@Override
public void run() {
	// TODO Auto-generated method stub
	System.out.println("hi");
	//return 0;
}



}
class child extends Parent
{
	
int c;


}
public class A {

	public static void main(String[] args) {
	/*Parent p=new Parent();
	p.a=20;
	p.b=30;
	Parent cc=new child();
	i1 i=new Parent();
	i.run();
System.out.println();*/
		Parent p=new Parent();
		p.num();

	}

}
