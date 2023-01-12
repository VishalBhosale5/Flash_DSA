package Tree;

import java.util.ArrayList;

import javax.crypto.CipherInputStream;

import Queue.FindFirstNegativeIntegerInAArrayOfSizeK;

public class BinarySearchTree {

	//searching: In binary search tree in every level we will check one node
	//balanced BST height=O(logn)
	//left /right skewed BST height=O(n)
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
			
		}
		
		
	}
	
	private Node root;
	 	
	
	
	
	public BinarySearchTree()
	{
		int[] ar= {3,6,7,9,10,12,14};
		this.root=construct(ar,0,ar.length-1);
	}




	private Node construct(int[] ar, int low, int high) {
		if(low>high)
			return null;
		int mid=(low+high)/2;
		Node nn=new Node(ar[mid]);
		nn.left=construct(ar, low, mid-1);
		nn.right=construct(ar, mid+1, high);
		
		return nn;
	}
	
	
	
	public void inOrder(Node node)
	{
		if(node.left!=null)
			inOrder(node.left);
		
		System.out.print(node.data+" ");
		
		if(node.right!=null)
			inOrder(node.right);
		
	}
	public void preOrder(Node node)
	{
		System.out.print(node.data+" ");
		
		if(node.left!=null)
			inOrder(node.left);
		
	
		
		if(node.right!=null)
			inOrder(node.right);
		
	}
	
	
	 private void display(Node node)
	{
		if(node==null)
			return;
		
		String str="";
		
		
		if(node.left!=null)
		str+=node.left.data;
		else
			str+=".";
		str+="->"+node.data+"<-";
		
		if(node.right!=null)
		str+=node.right.data;
		else
			str+=".";
		
		System.out.println(str);
		
		
		display(node.left);
		
	
		display(node.right);
		
	}
	public void display()
	{
		this.display(this.root);
	}
	
	
	public boolean find(Node node,int val)
	{
		if(node==null)
			return false;
		
		if(node.data==val)
			return true;
		else if(node.data>val)
			return find(node.left,val);
		else
			return find(node.right,val);
		
	}
	
	
	public int findMax(Node node)
	{/*
		if(node==null)
			return 0;
		
		int max=0;
		
		if(node.data>max)
			max=node.data;
		
		int mx=findMax(node.right);
		if(mx>max)
			max=mx;
		
		return max;*/
		
		//another approach
		
		if(node.right==null)
			return node.data;
		
		return findMax(node.right);
	}
	
	
	
	public void add(Node node,int item)
	{
		
		if(item>node.data)
		{
			
			if(node.right==null)
			{
				Node nn=new Node(item);
				node.right=nn;
			}else
			{
				add(node.right,item);
			}
			
		}
		else if(item<node.data)
		{
			if(node.left==null)
			{
				Node nn=new Node(item);
				node.left=nn;
			}else
			{
				add(node.left,item);
			}
		}
		
		
		
		
	}
	
	
	//if we want to delete node then we need parent of that node and information whether it is left child of his parent or right child of his parent
	public void remove(Node node,Node parent,boolean ilc,int item)
	{
		
		
		if(node==null)
			return;
		
		if(item>node.data)
		{
			remove(node.right,node,false,item);
		}
		else if(item<node.data)
		{	
			remove(node.left,node,true,item);
		}
		else
		{
			//case 1:  when left and right of the node is null
			
			if(node.left==null && node.right==null)
			{
				
				if(ilc)
				{
					parent.left=null;
				}
				else
				{
					parent.right=null;
				}
			}
			
			
			
			//case 2: when left is null but right is not null
			
			
			else if(node.left==null && node.right!=null)
			{
	
				if(ilc)
				{
					parent.left=node.right;
				}
				else
				{
					parent.right=node.right;
				}

			}
			
			//case 3: when right is null and left is non null
			
			else if(node.left!=null && node.right==null)
			{
				if(ilc)
				{
					parent.left=node.left;
				}
				else
				{
					parent.right=node.left;
				}

			}
			
			//case 4: when left and right both are non null
			//to remove node we needs left's max and rights min
			// we will replace that left's max with current node data and 
			//recursively call to delete that left's max from left node via calling function again
			
			
			else
			{
				
				
				int max=findMax(node.left);
				node.data=max;
				
				remove(node.left,node,true,max);
				
				
				
				
			}
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	//test
	
	
	//Delete a node from BInary search tree  
	
	public void removeNode(Node node,Node parent,int d)
	{
		if(node==null)
			return;
		
		if(node.data==d)
		{
		if(node.left==null && node.right==null)
		{
			if(parent.data>node.data)
				parent.left=null;
			else
				parent.right=null;
			
			
		}
		else if(node.left==null && node.right!=null)
		{
			if(parent.data>node.data)
				parent.left=node.right;
			else
				parent.right=node.right;
		
		}
		else if(node.left!=null && node.right==null)
		{
			if(parent.data>node.data)
				parent.left=node.left;
			else
				parent.right=node.left;
			
		
		}
		else
		{
			
			int n=findMax(node.left);
			System.out.println("Max is "+n);
			
			
			removeNode(node.left,node,n);
			
			node.data=n;
			
			
			
			
		}
		}
		else
		{
		
		if(node.data<d)
		{
			removeNode(node.right, node, d);
		}
			
		if(node.data>d)
			removeNode(node.left, node, d);
		
		
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree();
		//bst.inOrder(bst.root);
		//System.out.println();
		//bst.preOrder(bst.root);
		System.out.println();
		bst.display();
		//System.out.println(bst.find(bst.root,60));
		//System.out.println(bst.findMax(bst.root));
		//System.out.println("---------------data-000000000");
	//	bst.add(bst.root, 5);
	////	bst.display();
		//bst.remove(bst.root, null, false, bst.root.data);
	//	System.out.println("---new---");
	//	bst.display();
		//System.out.println("------------");
		//bst.removeNode(bst.root, null, 40);
		//bst.remove(bst.root, null, false, 60);
		//bst.display();
		//bst.replacegreator(bst.root);
		//bst.display();
		//bst.printKLvlDown(bst.root, 2, null);
		bst.printNodesAtKDistanceFromGivenNode(bst.root.left.left,2);
	}
	
	
	//Replace with sim of greator nodes
	//inorder of BST is sorted so we use RNL instead of LNR
	static int sum=0;
	
	public void replacegreator(Node node)
	{
		if(node==null)
			return; 
		
		replacegreator(node.right);
		
		node.data+=sum;
		sum=node.data;
		
		replacegreator(node.left);
		
		
	}
	
	//Print all nodes at distance k from a given node
	
	
	public void printNodesAtKDistanceFromGivenNode(Node node,int k)
	{
		
		findNodeToRootpath(this.root,node.data);
		System.out.println(path);
		for(int i=0;i<path.size();i++)
		{
			printKLvlDown(path.get(i), k-i, i==0?null:path.get(i-1));
		}
		
		
		
	}
	
	
	//get node to root path
	static ArrayList<Node> path=new ArrayList<Node>();
	public boolean findNodeToRootpath(Node node,int k)
	{
		
		if(node==null)
		return false;
		
		if(node.data==k)
		{
			path.add(node);
			return true;
			
		}
		
		if(findNodeToRootpath(node.left, k))
		{
			path.add(node);
			return true;
		}
		
		if(findNodeToRootpath(node.right,k))
		{
			path.add(node);
			return true;
		}
		
		
		
		return false;
		
		
		
		
	}
	
	public void printKLvlDown(Node node,int k,Node blocker)
	{
		
		if(node==null || k<0 || node==blocker)
			return ;
		
		
		
		if(k==0)
		{
			System.out.println(node.data);
			return;
		}
		
		printKLvlDown(node.left, k-1, blocker);
		printKLvlDown(node.right, k-1, blocker);
		
		
		
	}
	
	
	
	
	
}
