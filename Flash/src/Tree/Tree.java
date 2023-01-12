package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree {

	/*
	
	*/

	public static void main(String[] args) {
		GenericTree tree = new GenericTree();
		tree.display();
	}

}

class GenericTree {

	private class Node {

		int data;

		ArrayList<Node> children;

		Node(int data) {

			this.data = data;

			this.children = new ArrayList<>();

		}

	}

	private Node root;

	private int size;

	public GenericTree() {
		Scanner sc = new Scanner(System.in);
		this.root = TakeInput(sc, null, 0);
	}

	private Node TakeInput(Scanner sc, Node parent, int ithChild) {

		if (parent == null) {
			System.out.println("Enter the data for the root node:");
		} else {
			System.out.println("Enter the data for the " + ithChild + "th child of the root node" + parent.data);
		}

		int nodedata = sc.nextInt();
		Node node = new Node(nodedata);
		this.size++;
		System.out.println("Enter the no of childs for the root node " + node.data);
		int child = sc.nextInt();
		for (int i = 0; i < child; i++) {
			Node children = TakeInput(sc, node, i);
			node.children.add(children);
		}

		return node;
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