package AVLTree;

import java.util.Scanner;

import Tree.BinaryTree_dummy.Node;

public class AVL {



		public  class Node {

			int data;
			Node left;
			Node right;
			int height;

			Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;
				this.height=1;
			}
		}

		 Node root = null;
		 int size = 0;

		public AVL() {
			
		}
		public void insert(int item)
		{
			root=insert(this.root, item);
		}
		
	private Node insert(Node node,int item)
	{
		
		
		if(node==null)
		{
			Node nn=new Node(item,null,null);
			return nn;
			
		}
		if(item > node.data)
		{
			node.right=insert(node.right, item);
		}
		else if(item < node.data)
		{
			node.left=insert(node.left, item);
		}
		
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		
		//while returing check bf
		int bf=balancingFactor(node);
		
		//LL problem then rightrotate
		if(bf > 1 && item < node.left.data)
		{
			return RightRotate(node);
		}
		
		//RR problem then leftrotate
		if(bf < -1 && item > node.right.data)
		{
			return leftRotate(node);
		}
		
		
		//LR case
		
		if(bf > 1 && item > node.left.data)
		{
			node.left=leftRotate(node.left);
			
			return RightRotate(node);
			
		}
		
		//RL case
		
		if(bf < -1  && item < node.right.data)
		{
		node.right=RightRotate(node.right);
					
		return leftRotate(node);
					
		}
		
		return node;
	}
		
	//RR case solution is single left rotation
	//how to detect
	// bf < -1  && insertedNode > node.right.data
	
	public Node leftRotate(Node node)
	{
		
		if(node==null)
			return null;
		
		Node r=node.right;
		Node T=r.left;
		
		r.left=node;
		node.right=T;
		
		//first calculate childs height and then new parent
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		r.height=Math.max(getHeight(r.right),getHeight(r.left))+1;
				
		
		return r;
		
	}
	
		//LL case solution is single right rotation
		//how to detect
		// bf > 1  && insertedNode < node.left.data
		
	public Node RightRotate(Node node)
	{
		
		if(node==null)
			return null;
		
		Node l=node.left;
		Node T=l.right;
		
		l.right=node;
		node.left=T;
		
		//first calculate childs height and then new parent
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		l.height=Math.max(getHeight(l.right),getHeight(l.left))+1;
		
		return l;
		
	}
	
	
	
	public int balancingFactor(Node node)
	{
		if(node==null)
			return 0;
		
		int l=getHeight(node.left);
		int r=getHeight(node.right);
		
		
		return l-r;
	}
	
	
	
	 Node nodeWithMimumValue(Node node) {
		    Node current = node;
		    while (current.left != null)
		      current = current.left;
		    return current;
		  }

		//if we want to delete node then we need parent of that node and information whether it is left child of his parent or right child of his parent
		public Node remove(Node node,Node parent,boolean ilc,int item)
		{
			
			
			if(node==null)
				return null;
			
			if(item > node.data)
			{
				node.right= remove(node.right,node,false,item);
			}
			else if(item<node.data)
			{	
				node.left= remove(node.left,node,true,item);
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
					
					return null;
				}
				
				
				
				//case 2: when left is null but right is not null
				
				
				else if(node.left==null && node.right!=null)
				{
		
					if(ilc)
					{
						return node.right;
					}
					else
					{
						return node.right;
					}
					
					
				}
				
				//case 3: when right is null and left is non null
				
				else if(node.left!=null && node.right==null)
				{
					if(ilc)
					{
						return node.left;
					}
					else
					{
						return node.left;
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
					
					node.left= remove(node.left,node,true,max);
					
					
					
					
				}
			}
			
			if(node==null)
				return null;
			
			 node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			    int balanceFactor = balancingFactor(node);
				// System.out.println("balancing factor :"+node.data+" : "+balanceFactor+" node left height: "+getHeight(node.left)+" ");

			    if (balanceFactor > 1) {
			      if (balancingFactor(node.left) >= 0) {
			        return RightRotate(node);
			      } else {
			        node.left = leftRotate(node.left);
			        return RightRotate(node);
			      }
			    }
			    if (balanceFactor < -1) {
			      if (balancingFactor(node.right) <= 0) {
			        return leftRotate(node);
			      } else {
			        node.right = RightRotate(node.right);
			        return leftRotate(node);
			      }
			    }
			
			
			System.out.println("returing : "+node.data);
			return node;
			
		}
	
		
	 //another approh to delete node
	 Node deleteNode(Node root, int item) {

		    // Find the node to be deleted and remove it
		    if (root == null)
		      return root;
		    if (item < root.data)
		      root.left = deleteNode(root.left, item);
		    else if (item > root.data)
		      root.right = deleteNode(root.right, item);
		    else {
		      if ((root.left == null) || (root.right == null)) {
		        Node temp = null;
		        if (temp == root.left)
		          temp = root.right;
		        else
		          temp = root.left;
		        if (temp == null) {
		          temp = root;
		          root = null;
		        } else
		          root = temp;
		      } else {
		        Node temp = nodeWithMimumValue(root.right);
		        root.data = temp.data;
		        root.right = deleteNode(root.right, temp.data);
		      }
		    }
		    if (root == null)
		      return root;

		    // Update the balance factor of each node and balance the tree
		    root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		    int balanceFactor = balancingFactor(root);
		    if (balanceFactor > 1) {
		      if (balancingFactor(root.left) >= 0) {
		        return RightRotate(root);
		      } else {
		        root.left = leftRotate(root.left);
		        return RightRotate(root);
		      }
		    }
		    if (balanceFactor < -1) {
		      if (balancingFactor(root.right) <= 0) {
		        return leftRotate(root);
		      } else {
		        root.right = RightRotate(root.right);
		        return leftRotate(root);
		      }
		    }
		    return root;
		  }
	 
	 
		public int findMax(Node node)
		{
			if(node.right==null)
				return node.data;
			
			return findMax(node.right);
		}
		
	public void display(Node node)
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
	
	//keep in mind initial height should be 1 and return 0 here
	//if return -1 then bf will not work properly
	//height 0 and return -1
	//or height 1 return 0
	public int getHeight(Node node)
	{
		
		if(node==null)
			return 0;
		
		
		return node.height;
		
		
		/*int height=-1;
		
		if(node==null)
			return -1;
		
		int l=getHeight(node.left);
		int r=getHeight(node.right);
		
		if(l>height)
			height=l;
		
		if(r>height)
			height=r;
		
		height++;
		
		
		return height;*/
		
		
		
	}
	public static void main(String[] args) {
		AVL tree=new AVL();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(12);
		tree.insert(3);
		tree.insert(18);
		tree.insert(20);
		tree.display(tree.root);
		/*tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(19);
		tree.insert(16);
		tree.display(tree.root);*/
		//System.out.println(tree.getHeight(tree.root));
		/*tree.remove(tree.root, null, false, 19);
		tree.display(tree.root);*/
		/*System.out.println(tree.getHeight(tree.root));
		tree.root=tree.leftRotate(tree.root);
		System.out.println();
		tree.display(tree.root);
		System.out.println(tree.getHeight(tree.root));*/
		System.out.println("---------");
		//tree.root=tree.deleteNode(tree.root ,15);
		//tree.root=tree.deleteNode(tree.root ,5);
		//System.out.println(tree.getHeight(tree.root.left));
		tree.root=tree.remove(tree.root, null, false, 3);

		tree.display(tree.root);
	}
	
	
		
	
}
