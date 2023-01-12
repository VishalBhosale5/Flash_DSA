package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class SumAtKthLevel {

    public static void main(String args[]) {
		GenericTree_d tree=new GenericTree_d();
		//tree.display();
		Scanner sc=new Scanner(System.in);
		
		System.out.println(tree.findLevelSum(tree.root,tree.k));
    }



	
}

class GenericTree_d {

	 class Node {

		int data;

		ArrayList<Node> children;

		Node(int data) {

			this.data = data;

			this.children = new ArrayList<>();

		}

	}

	 Node root;

	private int size;
int k=0;
	public GenericTree_d() {
		Scanner sc = new Scanner(System.in);
		this.root = buildTree(sc, null, 0);
		this.k=sc.nextInt();
	}

	private Node buildTree(Scanner sc, Node parent, int ithChild) {

		if (parent == null) {
			//System.out.println("Enter the data for the root node:");
		} else {
			//System.out.println("Enter the data for the " + ithChild + "th child of the root node" + parent.data);
		}

		int nodedata = sc.nextInt();
		Node node = new Node(nodedata);
		this.size++;
		//System.out.println("Enter the no of childs for the root node " + node.data);
		int child = sc.nextInt();
		for (int i = 0; i < child; i++) {
			Node children = buildTree(sc, node, i);
			node.children.add(children);
		}

		return node;
	}
	



	public int findLevelSum(Node node,int level)
	{
		int sum=0;
		if(level==0)
		{
			sum=node.data;
		
		}

		for(Node child:node.children)
		{
			sum+=findLevelSum(child,level-1);
		}

			return sum;
	}
	
	public void display()
	{
		this.display(this.root);
	}

	private void display(Node node) {
		
		String str=node.data+"=> ";
		
		for(int i=0;i<node.children.size();i++)
		{
			str+=node.children.get(i).data+",";
		}
		str+="END";
		System.out.println(str);
		for(int i=0;i<node.children.size();i++)
		{
			this.display(node.children.get(i));
		}
		
		
	}

}