 package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class BinaryTree_dummy {

		public class Node {

			 public int data;
			 public Node left;
			public Node right;

			Node(int data, Node left, Node right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
		}

		 Node root = null;
		 int size = 0;

		public BinaryTree_dummy() {
			Scanner sc = new Scanner(System.in);
			this.root = takeInput(sc, null, false);
		}

		 Node takeInput(Scanner sc, Node parent, boolean isLeft) {

			if (parent == null) {
				System.out.println("Enter the data for the root node");
			} else {
				if (isLeft) {
					System.out.println("Enter the data for the left child of " + parent.data);
				} else {
					System.out.println("Enter the data for the right child of " + parent.data);
				}
			}

			int data = sc.nextInt();
			Node node = new Node(data, null, null);
			this.size++;
			
			
			
			System.out.println("Do you have left child of" + node.data);
			int choice = sc.nextInt();

			if (choice!=-1) {
				node.left = takeInput(sc, node, true);

			}

			
			System.out.println("Do you have right child of" + node.data);
			choice =  sc.nextInt();;

			if (choice!=-1) {
				node.right = takeInput(sc, node, false);

			}
			return node;
		}
		
		
		public void display()
		{
			
			this.display(this.root);
			
			
		}

			
		private void display(Node node)
		{
			if(node==null)
				return;
			
			/*if(node!=null)
			System.out.println(node.data);
			if(node!=null)
			{
			display(node.left);
			display(node.right);
			}
			*/
			String str="";
			
			if(node.left!=null)
			{
				
				str+=node.left.data+"=>";
			}
			else
				str+="END=>";
			
			str+=node.data;
			
			if(node.right!=null)
			{
				
				str+="<="+node.right.data;
			}
			else
				str+="<=END";
			
			System.out.println(str);
			
			if(node.left!=null)
			{
			display(node.left);
			}
			if(node.right!=null)
			display(node.right);
			
		
			
		}
		
		
		
		
		
		
		
		public int height(Node node)
		{
			
			/*int height=-1;
			
			if(node.left!=null)
			{
				int ht=height(node.left);
				if(ht>height)
					height=ht;
			}
			if(node.right!=null)
			{
				int ht=height(node.right);
				if(ht>height)
					height=ht;
			}
			
			
			height++;
			
			
			return height;*/
			
			//another approach
			if(node==null)
				return -1;
			
			int lheight=height(node.left);
			int rheight=height(node.right);
			
			int height=Math.max(lheight,rheight)+1;
			return height;
		}
		
	public void inOrder(Node node)
	{
		
	if(node.left!=null)
		inOrder(node.left);

	System.out.print(node.data+" ");

	if(node.right!=null)
		inOrder(node.right);
	}
	//Inorder iterative approach
	
	public ArrayList<Integer> InOrderList(Node node)
	{
		ArrayList<Integer> list=new ArrayList<>();
		if(node==null)
		{
			return list;
		}
		Stack<Node> st=new Stack<>();
		//ArrayList<Integer> list=new ArrayList<>();
		
		while(true)
		{
			
			if(node!=null)
			{
				st.push(node);
				
				node=node.left;
				
				
				
			}
			else
			{
				if(st.isEmpty())
				{
					break;
				}
				
					Node t=st.pop();
					list.add(t.data);
					node=t.right;
				
			}
			
			
			
			
			
		}
		
		return list;
		
	}

	public void preOrder(Node node)
	{
		System.out.print(node.data+" ");
	if(node.left!=null)
		preOrder(node.left);



	if(node.right!=null)
		preOrder(node.right);
	}



	public void LevelOrder_BFS(Node node)
	{
		
	Queue<Node> queue=new LinkedList<>();

	queue.add(node);


	while(!queue.isEmpty())
	{

		Node n=queue.peek();
		queue.remove();
		System.out.print(n.data+" ");
		
		if(n.left!=null)
		queue.add(n.left);
		if(n.right!=null)
		queue.add(n.right);



	}






	}







	public void postOrder(Node node)
	{

		if(node==null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");

	}
/*To check if given BT is BST
	
1)1st approach is to get inorder traversal and check if it is sorted or not is yes then it is BST
2)2nd approach is to use range to check left and right childs of root using recursion [-infinity,infinity]
*/			
	static 	ArrayList<Integer> i=new ArrayList<>();;
	public ArrayList<Integer> getInOrder(Node node)
	{
		//first get inorder traversal of tree if it is sorted then yes prtherwise no

		
	if(node.left!=null)
		getInOrder(node.left);

	i.add(node.data);

	if(node.right!=null)
		getInOrder(node.right);


	return i;

	}

	public boolean checkifBST(Node node)
	{
	ArrayList<Integer> i=getInOrder(node);

	for(int j=0;j<i.size()-1;j++)
	{
		for(int k=j+1;k<i.size();k++)
		{
			System.out.println(j+" -> "+k);
			if(i.get(j)>i.get(k))
			{
				return false;
			}
		}
	}
	return true;

	}
	
	//2nd approach
	
	public boolean isBST(Node node,int min,int max)
	{
		
		if(node==null)
			return true;
		
		if(node.data<min || node.data>max)
			return false;
			else if(!isBST(node.left, min, node.data))
				return false;
			else if(!isBST(node.right, node.data, max))
				return false;
		
		
		
		return true;
		
		
	}
	
	
	
	
	public int getSize(Node node)
	{
		if(node==null)
			
			return 0;
		
		int size=0;
		
		
		size+=getSize(node.left);
		
		size+=getSize(node.right);
		
		
		
		return size+1;
		
		
	}
	
	
	public int getMax(Node node)
	{
		if(node==null)
			return Integer.MIN_VALUE;  //incase tree has negative values
		
		int max=0;
		
		int l=getMax(node.left);
		if(l>max)
			max=l;
		
		int r=getMax(node.right);
		if(r>max)
			max=r;
		
		if(node.data>max)
			max=node.data;
		
		
		return max;
		
		
	}

	
	public boolean find(Node node,int item)
	{
		
		if(node==null)
			return false;
		
		
		if(node.data==item)
			return true;
		
		return find(node.left,item) || find(node.right,item);
	
		
	}
	
	
	public int getHeight(Node node)
	{
		if(node==null)
			return -1; //incase node is 1
		
		
		int l=getHeight(node.left);
		int r=getHeight(node.right);
		
		return Math.max(l, r)+1;
		
		
		
	}
	static int maxDiameter=Integer.MIN_VALUE;
	
	public void findDiamter(Node node)
	{
	
		if(node==null)
			return;
		int l=getHeight(node.left);
		int r=getHeight(node.right);
		
		int max=l+r+2;
		
		if(max>maxDiameter)
			maxDiameter=max;
		
		findDiamter(node.left);
		findDiamter(node.right);
		
	
	}
	
	//diameter 2nd approach
	
	//O(n^2)
	public int diameter2(Node node)
	{
		
		if(node==null)
			return 0;
		
		
		int ld=diameter2(node.left);
		int rd=diameter2(node.right);
		
		
		int lh=getHeight(node.left);
		int rh=getHeight(node.right);
		
		
		return Math.max(lh+rh+2,Math.max(ld, rd));
		
	
		
	}
	
	
	//3rd better O(n) approach
	// when we want to return multiple values in recusion then make another class and add multiple properties in it.
	class diaPair{
		int diameter;
		int height;
	}
	
	
	public int diameter3Ans(Node node)
	{
		
		return diameter3(node).diameter;
	}
	//O(n)
	public diaPair diameter3(Node node)
	{
		
		if(node==null)
		{
			diaPair s=new diaPair();
			s.diameter=0;
			s.height=-1;
			return s;
			
		}
		
		
		diaPair ldp=diameter3(node.left);
		diaPair rdp=diameter3(node.right);
		
		diaPair sdp=new diaPair();
		
		
		int ld=ldp.diameter;
		int rd=rdp.diameter;
		int sh=ldp.height+rdp.height+2;
		
	
		
		sdp.diameter= Math.max(sh,Math.max(ld, rd));
		sdp.height=Math.max(ldp.height, rdp.height)+1;
		
	
		return sdp;
	}
	
	
	//at each level node should be balanced including root
	//O(n^2) approach
	public boolean isBalanced(Node node)
	{
		if(node==null)
			return true;
		boolean lb=isBalanced(node.left);
		boolean rb=isBalanced(node.right);
		
		int bf=getHeight(node.left)-getHeight(node.right);
		
		if(lb && rb && bf>=-1 && bf<=1)
			return true;
		else
			return false;
		
	
		
	}
	
	
	//better approach
	
	class BalncPair
	{
		boolean isBal=true;
		int height=-1;
	}
	
	
	public BalncPair isBalanced2(Node node)
	{
		
		if(node==null)
			{
			return new BalncPair();
			}
		
		BalncPair lbp=isBalanced2(node.left);
		BalncPair rbp=isBalanced2(node.right);
		
		BalncPair sbp=new BalncPair();
		
		boolean lb=lbp.isBal;
		boolean rb=rbp.isBal;
		
		int bf=lbp.height-rbp.height;
		
		if(lb && rb && bf>=-1 && bf<=1)
			sbp.isBal=true;
		else
			sbp.isBal=false;
		
		sbp.height=Math.max(lbp.height, rbp.height)+1;
		
		
		
		return sbp;
		
		
		
	}
	
	public boolean flipEquivalentBT(Node root1,Node root2)
	{
		
		if(root1==null && root2==null)
			return true;
		//either one is null
		if(root1==null || root2==null)
			return false;
		
		if(root1.data!=root2.data)
			return false;
		
		
		boolean ll=flipEquivalentBT(root1.left, root2.left);
		boolean rr=flipEquivalentBT(root1.right, root2.right);
		
		if(ll && rr)
			return true;
		
		
		boolean lr=flipEquivalentBT(root1.left, root2.right);
		boolean rl=flipEquivalentBT(root1.right, root2.left);
		
			return (ll && rr) || (lr && rl);
		

		
	}
	
//construct tree using preorder and inorder
		
		public BinaryTree_dummy(int[] pre,int[] in)
		{
			root=Construct(pre,0,pre.length-1,in,0,in.length-1);
		}
	
	private Node Construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		
		if(ilo>ihi || plo>phi)
			return null;
		
		
		Node node=new Node(pre[plo], null, null);
		
		// search for root pre[plo] in inorder
		int si=-1;
		int noofel=0;
		for(int i=ilo;i<=ihi;i++)
		{
			if(pre[plo]==in[i])
			{
				si=i;
				break;
			}
			
			noofel++;
		}
		
		//left and right child call;
		
		node.left=Construct(pre, plo+1, plo+noofel, in, ilo, si-1);
		node.right=Construct(pre, plo+noofel+1, phi, in, si+1, ihi);
		
		return node;
		
		
		
		
	
	}
	
	public int sum(Node node)
	{
		if(node==null)
			return 0;
		
		int ls=sum(node.left);
		int rs=sum(node.right);
		
		
		return ls+rs+node.data;
	}
	
	static int maxsum=Integer.MIN_VALUE;
	public int sumMax(Node node)
	{
		if(node==null)
			return 0;
		
		int ls=sumMax(node.left);
		int rs=sumMax(node.right);
		
		int sum=ls+rs+node.data;
		System.out.println("ls: "+ls+" rs:"+rs+" sum: "+sum+" maxsum :"+maxsum);

		if(sum>maxsum)
		{
			System.out.println("inside ls: "+ls+" rs:"+rs+" sum: "+sum+" maxsum :"+maxsum);
			maxsum=sum;
		}
		
		return sum;
	}
	static  ArrayList<ArrayList<Integer>> list=new ArrayList<>();


	//10 1 -20 1 40 -1 -1 1 -50 -1 -1 1 -30 1 60 1 70 -1 -1 -1 -1 
	
	
	//10 1 20 1 40 -1 -1 1 50 -1 -1 1 30 1 60 1 -1 1 70 -1 1 80 -1 -1
	//50 1 30 1 10 -1 -1 1 40 -1 -1 1 60 1 55 -1 -1 1 65 -1 1 80 -1 -1
//	//1 1 2 1 4 -1 -1 1 5 -1 -1 1 3 1 6 -1 -1 1 7 -1 -1

	//10 true 8 true 7 false false true 9 false false true 12 true 11 false false true 13 false false
	//
	//10 true 20 true 40 true 80 false false true 90 false false true 50 false false true 30 true 60 true 100 false false true 200 false false true 70 false false
		public static void main(String[] args) {
			
			list.add(new ArrayList<>());
			list.add(new ArrayList<>());
			list.add(new ArrayList<>());
			BinaryTree_dummy tree=new BinaryTree_dummy();
			//tree.display();
			//System.out.println(tree.height(tree.root));
			//System.out.println("Recursive inorder: ");
			//tree.inOrder(tree.root);
			//System.out.println("Iterative inorder");
			/*System.out.println(tree.InOrderList(tree.root));
			System.out.println("Size of Tree is : "+tree.getSize(tree.root));
			System.out.println("Maximum is : "+tree.getMax(tree.root));
			System.out.println(tree.find(tree.root, 500));
			System.out.println("Height : "+tree.getHeight(tree.root));*/
			/*System.out.println();
			tree.preOrder(tree.root);
			System.out.println();
			tree.postOrder(tree.root);
			*/
			//System.out.println("\n Level orer BFS");
			//tree.LevelOrder_BFS(tree.root);
			
			//System.out.println(tree.checkifBST(tree.root));
			//System.out.println(tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
			/*System.out.println();
			
			tree.findDiamter(tree.root);
			System.out.println(maxDiameter);
			System.out.println(tree.diameter2(tree.root));
			System.out.println(tree.diameter3Ans(tree.root));
			System.out.println(tree.isBalanced(tree.root));
			System.out.println(tree.isBalanced2(tree.root).isBal);*/
			/*int[] pre=new int[] {10,20,40,50,30,60,70};
			int[] in=new int[] {40,20,50,10,60,30,70};
			BinaryTree_dummy tree2=new BinaryTree_dummy(pre,in);
			tree2.display();*/
			
//			tree.inOrder(tree.root);
//			System.out.println();
//			System.out.println("root of tree: "+tree.root.data);
//			System.out.println("sum is:"+tree.sumMax(tree.root));
//			System.out.println(maxsum);
			
			//preOrderInOrderPostOrderTraversal(tree.root);
		
			iterativePreOrderInOrderPostOrder(tree.root);
			System.out.println("PreOrder: "+list.get(0));
			System.out.println("InOrder: "+list.get(1));
			System.out.println("PostOrder: "+list.get(2));
		}
		
		/*
		 * get preorder inorder postorder traversal in 1 traversal
		 */
		public static void preOrderInOrderPostOrderTraversal(Node node)
		{
			if(node==null)
				return ;
			//first time visit
			list.get(0).add(node.data);
			preOrderInOrderPostOrderTraversal(node.left);
			
			//2nd time visit
			list.get(1).add(node.data);
			
			preOrderInOrderPostOrderTraversal(node.right);
			
			//3rd time visit while removing from stack
			list.get(2).add(node.data);
			
		}
		
		public static void iterativePreOrderInOrderPostOrder(Node node)
		{
			
			Stack<Pairs> st=new Stack<>();
			st.push(new Pairs(node, 1));
			
			while(!st.isEmpty())
			{
				
				Pairs curr=st.peek();
				
				if(curr.num==1)
				{
					list.get(0).add(curr.node.data);
					
					curr.num++;
					if(curr.node.left!=null)
						st.push(new Pairs(curr.node.left,1));
					
				}
				else if(curr.num==2)
				{
					list.get(1).add(curr.node.data);

					curr.num++;
					
					if(curr.node.right!=null)
						st.push(new Pairs(curr.node.right,1));
				}
				else
				{
					list.get(2).add(curr.node.data);
					st.pop();
				}
				
				
			}
			
			
			
		}
	}
class Pairs{
	BinaryTree_dummy.Node node;
	int num;
	Pairs(BinaryTree_dummy.Node node,int num)
	{
		this.node=node;
		this.num=num;
	}
}
