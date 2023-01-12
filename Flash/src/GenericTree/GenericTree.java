package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	
	private class Node
	{
		int data;
		
		ArrayList<Node> childrens;
		
		Node(int data)
		{
			this.data=data;
			childrens=new ArrayList<>();
		
		}
		
		
		
	}
	
	private Node root;
	
	
	public GenericTree() {
		Scanner sc=new Scanner(System.in);
		this.root=construct(sc,null,0);
	}


	private Node construct(Scanner sc, Node parent, int ithChild) {
		
		
		
		if(parent==null)
		{
			System.out.println("Enter the data for the root node ");
		}
		else
		{
			System.out.println("Enter the data for the "+ithChild+"th of root node "+parent.data);
		}
		
		
		int d=sc.nextInt();
		Node node=new Node(d);
		
		System.out.println("Enter the no of childs for the root node "+node.data);
		
		int noofchild=sc.nextInt();
		
		
		for(int i=0;i<noofchild;i++)
		{
			Node temp=construct(sc, node, i);
			node.childrens.add(temp);
		}
		
		
		
		
		
		
		
		return node;
	}
	
	
	//test
	public void displays(Node root)
	{
		
		System.out.print(root.data+" -> ");
		
		for(int i=0;i<root.childrens.size();i++)
		{
			System.out.print(root.childrens.get(i).data+" , ");
		} 
		System.out.println();
		
		for(int i=0;i<root.childrens.size();i++)
		{
			display(root.childrens.get(i));;
		}
		
	}
	
	 
	public void display(Node node)
	{
		
		//base case 
		
		if(node==null)
			return;
		
		
		//self work
		String str=node.data+"->";
		
		
		for(Node child:node.childrens)
		{
			str+=child.data+",";
		}
		str+=".";
		
		System.out.println(str);

		
		//smaller problem
		for(Node child:node.childrens)
		{
			display(child);
		}
	}
	////test
	
	public int sizet(Node node)
	{
		
		int count=0;
		
		
		for(int i=0;i<node.childrens.size();i++)
			count+=sizet(node.childrens.get(i));
		
		
		return count+1;
		
		
	}
	
	
	
	public int size(Node node)
	{
		
		int size=0;
		
		//size+=node.childrens.size();
		
	for(Node child:node.childrens)
	{
		size+=size(child);
	}
		
		size++;
		return size;
	}
	
	
	//test
	public int getMax(Node node)
	{
		
		int max=0;
		for(Node child:node.childrens)
		{
			int mx=getMax(child);
			if(mx>max)
				max=mx;
		}
			
		if(max<node.data)
			max= node.data;
		
			return max;
		
		
	}
	
	public int max(Node node)
	{
		int max=0;
		
		if(node.data>max)
			max=node.data;
		
		
		for(Node child:node.childrens)
		{
			int mx=max(child);
			if(mx>max)
				max=mx;
		}
		
		
		return max;
		
	}
	
	
	//test
	
	public boolean findd(Node node,int item)
	{
		if(item==node.data)
			return true;
		
		for(int i=0;i<node.childrens.size();i++)
			if(findd(node.childrens.get(i),item))
				return true;
		
		
		//do not use return findd(node.childerens.get(i),item)) because we need to decide on which result we neeed to return value in thsi case it will search
		//the product in left left only and return false if not found so, make sure to decide first on which conditions we are reurnign value
		return false;
	}
	
	
	public boolean find(Node node,int item)
	{
	
		if(node.data==item)
			return true;
		
		
		for(Node child:node.childrens)
		{
			boolean f=find(child,item);
			if(f)
				return true;
		}
		
		return false;
	}
	
	
	//test
	
	public int heightd(Node node)
	{
		
		int h=-1;
		for(int i=0;i<node.childrens.size();i++)
		{
			int ch=heightd(node.childrens.get(i));
			if(ch > h)
				h=ch;
				
				
		}
		
		
		return h+1;
	}
	
	public int height(Node node)
	{
		
		
		int height=-1;
		
		
		for(Node child:node.childrens)
		{
			int ch=height(child);
			if(ch>height)
				height=ch;
		}
		
		height++;
		
		
		return height;
	}
	
	
	
	
	//10 3 20 2 50 0 60 0 398 0 40 1 70 0 
	public static void main(String[] args) {
		GenericTree tree=new GenericTree();
		//tree.display(tree.root);
		//System.out.println("Size: "+tree.size(tree.root));
		//System.out.println("Max : "+tree.max(tree.root));
		//System.out.println("find "+tree.find(tree.root, 10));
		//System.out.println("Height: "+tree.height(tree.root));
		tree.displays(tree.root);
		System.out.println(tree.sizet(tree.root));
		System.out.println(tree.getMax(tree.root));
		System.out.println(tree.findd(tree.root, 16));
		System.out.println(tree.height(tree.root));
		System.out.println(tree.heightd(tree.root));
	}

}
