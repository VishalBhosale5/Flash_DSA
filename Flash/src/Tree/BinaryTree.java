package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import Recursion.CheckifArraySorted;
import Tree.BinaryTree_dummy.Node;

public class BinaryTree {

	private class Node {

		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root = null;
	private int size = 0;

	public BinaryTree() {
		Scanner sc = new Scanner(System.in);
		this.root = takeInput(sc, null, false);
	}

	private Node takeInput(Scanner sc, Node parent, boolean isLeft) {

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

		boolean choice = false;
		System.out.println("Do you have left child of" + node.data);
		choice = sc.nextBoolean();

		if (choice) {
			node.left = takeInput(sc, node, true);

		}

		choice = false;
		System.out.println("Do you have right child of" + node.data);
		choice = sc.nextBoolean();

		if (choice) {
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
	
	//iterative solution
	
	
	public void inOrderItr(Node node)
	{
		
		
		Stack<Node> st=new Stack<>();
		//st.push(node);
		
		Node curr=node;
		
		boolean isLeft=curr.left!=null?true:false;
		
		while(curr!=null || !st.isEmpty())
		{
			
			if(curr!=null)
			{
				
				
				st.push(curr);
				curr=curr.left;
			}
			else
			{
				Node n=st.pop();
				System.out.print(n.data+" ");
				curr=n.right;
				
				
			}
			
	
		}
		
		
		
		
		
	}
	
public void inOrder(Node node)
{
	
if(node.left!=null)
	inOrder(node.left);

System.out.print(node.data+" ");

if(node.right!=null)
	inOrder(node.right);
}


//preOrder iterative


public static void preOrderIterative(Node node)
{
	
Stack<Node> st=new Stack<>();
st.push(node);

while(!st.isEmpty())
{
	Node nn=st.pop();
	
System.out.println(nn.data);

if(nn.right!=null)
	st.push(nn.right);

if(nn.left!=null)
{
	st.push(nn.left);
	
}




}






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




//iterative postorder


public void iterativePostOrder(Node node)
{
	Stack<Node> st=new Stack<>();
	Node prev=null;
	Node curr=node;
	while(curr!=null || !st.isEmpty())
	{
		
		
		if(curr!=null)
		{
			st.push(curr);
			curr=curr.left;
		}
		else
		{
			curr=st.peek();
			
			if(curr.right==null || curr.right==prev)
			{
				System.out.print(st.pop().data+" ");
				prev=curr;
				curr=null;
				
			}
			else
				curr=curr.right;
			
			
			
			
		}
		
	
		
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



//Another approach iterative preOrder Traversal

class TraversalPair
{
Node node;
boolean sw;
boolean lw;
boolean rw;
}


public void preorderitr(Node node)
{
	
Stack<TraversalPair> st=new Stack<>();
TraversalPair p=new TraversalPair();
p.node=node;
st.push(p);


while(!st.isEmpty())
{

	//print left right
	TraversalPair tp=st.peek();
	
	
	if(tp.sw==false)
	{
		System.out.print(tp.node.data+" ");
		tp.sw=true;
	}
	else if(tp.lw==false)
	{
		TraversalPair pr=new TraversalPair();
		pr.node=tp.node.left;
		
		if(pr.node!=null)
			st.push(pr);
		
		tp.lw=true;
	}
	else if(tp.rw==false)
	{
		TraversalPair pr=new TraversalPair();
		pr.node=tp.node.right;
		
		if(pr.node!=null)
			st.push(pr);
		
		tp.rw=true;
	}
	else
		st.pop();




}





}


//postOrder



public void postorderitr(Node node)
{
	
Stack<TraversalPair> st=new Stack<>();
TraversalPair p=new TraversalPair();
p.node=node;
st.push(p);


while(!st.isEmpty())
{

	//print left right
	TraversalPair tp=st.peek();
	
	
	
	if(tp.lw==false)
	{
		TraversalPair pr=new TraversalPair();
		pr.node=tp.node.left;
		
		if(pr.node!=null)
			st.push(pr);
		
		tp.lw=true;
	}
	else if(tp.rw==false)
	{
		TraversalPair pr=new TraversalPair();
		pr.node=tp.node.right;
		
		if(pr.node!=null)
			st.push(pr);
		
		tp.rw=true;
	}
	else if(tp.sw==false)
	{
		System.out.print(tp.node.data+" ");
		tp.sw=true;
	}
	else
		st.pop();




}





}


//iterative inorder traversal

public void inorderitr(Node node)
{
	
Stack<TraversalPair> st=new Stack<>();
TraversalPair p=new TraversalPair();
p.node=node;
st.push(p);


while(!st.isEmpty())
{

	//print left right
	TraversalPair tp=st.peek();
	
	
	
	if(tp.lw==false)
	{
		TraversalPair pr=new TraversalPair();
		pr.node=tp.node.left;
		
		if(pr.node!=null)
			st.push(pr);
		
		tp.lw=true;
	}
	else if(tp.sw==false)
	{
		System.out.print(tp.node.data+" ");
		tp.sw=true;
	}
	else if(tp.rw==false)
	{
		TraversalPair pr=new TraversalPair();
		pr.node=tp.node.right;
		
		if(pr.node!=null)
			st.push(pr);
		
		tp.rw=true;
	}
	else
		st.pop();




}
}



/*
 * Construct tree using
 *  preOrder+InOrder   =BT
 *  postOrder+InOrder= BT
 */

static  int ps= 0;

	public Node constructBT(int[] pre, int[] in, int is, int ie) {
		System.out.println("ps :"+ps+"  is :"+is+" ie: "+ie);

		if (is == ie) {
			ps++;
			return new Node(in[is], null, null);
			
		}
		
		if(is>ie)
			return null;
		int i = pre[ps];
		ps++;
		int ii = is;

		while(i!=in[ii++]) {}
		ii--;
		Node n = new Node(in[ii], null, null);

		n.left = constructBT(pre,  in, is, ii - 1);
		n.right = constructBT(pre, in, ii + 1, ie);

		return n;
	}


//without static variable
	
	public Node constructBTFromPreOrderInordr(int[] pre, int ps,int pe,int[] in, int is, int ie) {
		

	//	if (is == ie) {
			
		//	return new Node(in[is], null, null);
			
		//}
		
		if(ps>pe || is>ie)
			return null;
		int i = pre[ps];
		//ps++;
		int ii = is;
int size=0;
		while(i!=in[ii++]) {
			size++;
		}
		ii--;
		Node n = new Node(in[ii], null, null);

		n.left = constructBTFromPreOrderInordr(pre, ps+1,ps+size, in, is, ii - 1);
		n.right = constructBTFromPreOrderInordr(pre, ps+size+1,pe,in, ii + 1, ie);

		return n;
	}











//construct Binary tree using postOrder_InOrder
	
	//without static variable
	
		public Node constructBTFromPostOrderInOrd(int[] post, int ps,int pe,int[] in, int is, int ie) {
			

		//	if (is == ie) {
				
			//	return new Node(in[is], null, null);
				
			//}
			
			if(ps<pe || is>ie)
				return null;
			int i = post[ps];
			//ps++;
			int ii = is;
				int size=0;
			while(i!=in[ii++]) {
				size++;
			}
			ii--;
			Node n = new Node(in[ii], null, null);

			n.right = constructBTFromPostOrderInOrd(post, ps-1,ps-size, in,  ii + 1, ie);
			n.left = constructBTFromPostOrderInOrd(post, ps-size-1,pe,in,is, ii - 1);

			return n;
		}

//construct tree from inorder postorder
		
		public Node buildTree(int[] inorder, int[] postorder) {
	        
	        return T(postorder,postorder.length-1,0,inorder,0,inorder.length-1);
	    }
	    
	    public Node T(int[] post,int ps,int pe,int[] in,int is,int ie)
	    {
	        System.out.println("ps: "+ps+"  pe: "+pe+"  is : "+is+"  ie : "+ie);
	        
	       if(pe>ps || is>ie)
					return null;
	        //System.out.println("ps: "+ps);
				int i = post[ps];
				//ps++;
				
				
	            int newi=0;
	        
	        for(int ii = is;ii<=ie;ii++)
	        {
	            if(in[ii]==i)
	            {
	                newi=ii;
	                break;
	            }
	            
	            
	        }
	       // System.out.println("newi: "+newi);
	        int size=ie-newi;
				Node n = new Node(i, null, null);
	       // System.out.println(i);
	        n.right = T(post, ps-1,ps-size, in,  newi + 1, ie);

	            n.left = T(post, ps-size-1,pe,in,is, newi - 1);
				

				return n;
	        
	        
	    }








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
//check if given BT is BST or not

public boolean isBST(Node node,pair p)
{//else isBST(Node node,int min,int max)
	boolean ans=true;
		if(node==null)
			{
				return ans;	
			}
		System.out.println(node.data+"   {+"+p.min+" ,"+p.max+"}");

		if(node.data<p.min || node.data>p.max)
			return false;
		
		int temp=p.max;
	
	if(node.left!=null)
	{
		p.max=node.data;
		
		if(!isBST(node.left, p))
			ans=false;
	}
		
	if(node.right!=null)
	{
		p.min=node.data;
		p.max=temp;
		
		if(!isBST(node.right, p))
			ans=false;
	}
		
		return ans;
	
}


//sum of all leaf nodes in binary tree

public int leafSum(Node node)
{
	if(node==null)
		return 0;
	
	int sum=0;
	if(node!=null && node.left==null && node.right==null)
		sum+=node.data;
	
	sum+=leafSum(node.left);
	sum+=leafSum(node.right);
	
	
	
	return sum;


}
//findSize,max, findItem,height 
//easy question 





/*
 * Lowest common ancestors
 * 
 */

public Node lowestCommonAncestor(Node root, Node p, Node q) {
    
    if(root==null)
        return null;

    
    if(root.data==p.data || root.data==q.data)
        return root;
    
    
    Node left=lowestCommonAncestor(root.left,p,q);
    Node right=lowestCommonAncestor(root.right,p,q);
    
    
   
     if(left==null && right==null)
        return null;
    else if(left!=null && right!=null)
        return root;
    else if(left==null)
        return right;
    else return left;
    
    
    
}



//10 true 8 true 7 false false true 9 false false true 12 true 11 false false true 13 false false

//10 true 20 true 40 true 80 false false true 90 false false true 50 false false true 30 true 60 true 100 false false true 200 false false true 70 false false
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.display();
		/*System.out.println(tree.height(tree.root));
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		
		System.out.println("\n Level orer BFS");
		tree.LevelOrder_BFS(tree.root);*/
		//tree.inOrder(tree.root);
		//tree.inOrderItr(tree.root);
		
		//tree.preOrder(tree.root);
	//	tree.preOrderIterative(tree.root);
		//tree.postOrder(tree.root);
		//tree.inOrder(tree.root);
		//	System.out.println();
		//tree.iterativePostOrder(tree.root);
		//System.out.println(tree.isBST(tree.root,new pair()));
		
		//System.out.println(tree.leafSum(tree.root));
		//System.out.println(tree.getTreeDiameter(tree.root));
		//System.out.println(tree.isBalanced(tree.root));
			//tree.maxSubtreeSum(tree.root);
			//System.out.println(max);
			//System.out.println(tree.maxSubtreeSumeff(tree.root).max);
			/*tree.inOrder(tree.root);
			System.out.println();
			tree.inorderitr(tree.root);*/
			System.out.print("postOrder: ");
			tree.postOrder(tree.root);
			System.out.print("\nInOrder:  ");
			tree.inOrder(tree.root);
			System.out.println("------------------");
			int[] pre= {1, 2, 4, 5, 3 ,6, 7};
			int in[]= {4 ,2 ,5, 1, 6 ,3, 7};
			//tree.root=tree.constructBT(pre, in, 0, in.length-1);
			//tree.display();	
			
			System.out.println();
			
			//tree.root=tree.constructBTu(pre, 0, pre.length-1, in, 0, in.length-1);
			//tree.display();
			int[] post= {4,5,2,6,7,3,1};
			System.out.println("---------------");
			tree.root=tree.constructBTFromPostOrderInOrd(post, post.length-1, 0, in, 0, in.length-1);
			tree.display();
	}
//  1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 false false
	
	//height
	public int getHeight(Node node)
	{
		if(node==null)
			return -1; //incase node is 1
		
		
		int l=getHeight(node.left);
		int r=getHeight(node.right);
		
		return Math.max(l, r)+1;
		
		
		
	}
	
	
	
	//find the diameter of a binary tree n^2 approach
	public int getTreeDiameter(Node node)
	{
		
		
	    if(node==null)
	    return 0;
	    
		
		
		int ld=	 getTreeDiameter(node.left);
	
		int rd=	 getTreeDiameter(node.right);
		
		
		int sd=getHeight(node.left)+getHeight(node.right)+2;
		
		
		return Math.max(sd,Math.max(ld,rd));
		
	}
	
	// O(n) approach
	 public diapair diameterOfBinaryTreed(Node root) {
	        
	        
         if(root==null)
         {
        	 diapair d=new diapair();
             d.diameter=0;
             d.height=-1;
             return d;
         }
 
 
//  hunkk lh=getHeight(root.left);
//  hunkk rh =getHeight(root.right);
 
 diapair l=diameterOfBinaryTreed(root.left);
 diapair r=diameterOfBinaryTreed(root.right);
 
 
 diapair s=new diapair();
     s.diameter=Math.max(l.height+r.height+2,Math.max(l.diameter,r.diameter));
     s.height=Math.max(l.height,r.height)+1;
     
 return s;
 
}

	 
	 
	 //check if binary tree is balanced or not O(n^2)
	 
	 
	 public boolean isBalanced(Node node)
	 {
		 
		 if(node==null)
			 return true;
		 
		 int lh=getHeight(node.left);
		 int rh=getHeight(node.right);
		 int balancefactor=Math.abs(lh-rh);
		 if(balancefactor>1)
			 return false;
		 
		 
		 if(!isBalanced(node.left))
			 return false;
		 
		 
		 
		 
		 
		 if(!isBalanced(node.right))
			 return false;
		 
		 return true;
		 
	 }
	
	 

	 //O(n)
	 
	 
	 public isbalancePr isBalancedeff(Node node)
	 {
		 
		 if(node==null)
		 {
			 return new isbalancePr();
		 }
		 
		 isbalancePr l=isBalancedeff(node.left);
		 isbalancePr r=isBalancedeff(node.right);
		 
		 isbalancePr s=new isbalancePr();
		 
		 s.isBalanced= l.isBalanced==false || r.isBalanced==false || Math.abs(l.height-r.height)>1?false:true;
		 
		 s.height=Math.max(l.height, r.height)+1;
		 
		 
		 
		 
		 return s;
		 
	 }
	 
	 //flip equivalent binary tree
	 ///https://leetcode.com/problems/flip-equivalent-binary-trees/
	 
	  public boolean flipEquiv(Node  root1, Node root2) {
	        
	        if(root1==null && root2==null)
	            return true;
	        else if(root1==null || root2==null)
	            return false;
	        
	        

	        if(root1.data==root2.data)
	        {
	            
	            return flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right) || flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);
	        }
	        else
	            return false;
	        

	        
	        
	        //or  somewhat  efficient 		
	        
	        /*
	        if(root1==null && root2==null)
	            return true;
	        
	        if(root1==null || root2==null)
	            return false;
	        
	        
	        if(root1.val != root2.val)
	            return false;
	        
	        boolean ll=flipEquiv(root1.left,root2.left);
	        boolean rr=flipEquiv(root1.right,root2.right);
	        
	        if(ll && rr)
	            return true;
	        
	        boolean lr=flipEquiv(root1.left,root2.right);
	        boolean rl=flipEquiv(root1.right,root2.left);
	        
	        
	        return (ll && rr) || (lr && rl);*/
	        
	    }
	  
	  /*
	   * 
	   * 
	   * Serialize and deserialize binary tree
	   * in compiler code first tokenized and then serialized 
	   * parser desearilizes 
	   */
	
		    public String serialize(Node root) {
		        
		        if(root==null) return "X,";
		        
		        return root.data+","+serialize(root.left)+serialize(root.right);
		    }

		    // Decodes your encoded data to tree.
		    public Node deserialize(String data) {
		        
		        Queue<String> q=new LinkedList<>();
		        q.addAll(Arrays.asList(data.split(",")));
		        
		        return Des(q);
		    }
		    
		    public Node Des(Queue<String> q)
		    {
		        
		        
		        String s=q.poll();
		        
		        if(s.equals("X")) return null;	
		        
		        Node node=new Node(Integer.parseInt(s),null,null);
		        
		        node.left=Des(q);
		        node.right=Des(q);
		        
		        
		        
		        return node;
		        
		        
		        
		    }
		

	  
	  
	  
	  
	  
	  
	  
	  //maximum subtree sum
	  static int max=Integer.MIN_VALUE;
	  public int maxSubtreeSum(Node node)
	  {
		  
		  
		  
		  
		  if(node==null)
			  return 0;
		  
		  
		  int ls=maxSubtreeSum(node.left);
		  int rs=maxSubtreeSum(node.right);
	

		  
		  int a=ls+rs+node.data;
		  if(a>max)
			  max=a;
		  
		  System.out.println("ls :"+ls+" rs :"+rs+" max : "+max);

		  return a;
		  
		  
	  }
	  
	  public int sum(Node node)
	  {
		  
		  if(node==null)
			  return 0;
		  
		  int ls=sum(node.left);
		  int rs=sum(node.right);
		  
		  
		  return ls+rs+node.data;
	  }
	  
	  //right view of binary tree
	  

	   private void rightView(Node root) {


			   Queue<Node> q=new LinkedList<>();
			   q.add(root);
			   while(!q.isEmpty())
			   {

				   	int size=q.size();


					   for(int i=0;i<size;i++)
					   {

						   Node n=q.remove();

						   if(i==size-1)
						   System.out.print(n.data+" ");

						   if(n.left!=null)
						   q.add(n.left);

						   if(n.right!=null)
							q.add(n.right);


					   }


			   }

		}
	  
	  public sumpair maxSubtreeSumeff(Node node)
	  {
		  
		  
		  
		  
		  if(node==null)
			  return new sumpair();
		  
		  
		  sumpair ls=maxSubtreeSumeff(node.left);
		  sumpair rs=maxSubtreeSumeff(node.right);
		  
		  sumpair sd=new sumpair();
		
		  	sd.sum=ls.sum+rs.sum+node.data;
		  	
		  	sd.max=Math.max(sd.sum, Math.max(ls.max, rs.max));
		  
		  System.out.println("ls :"+ls.sum+" rs :"+rs.sum);

		  return sd;
		  
		  
	  }
	
}

class pair
{
int min=Integer.MIN_VALUE;
int max=Integer.MAX_VALUE;
}

class diapair
{
    int diameter;
    int height;
    
    
}
class isbalancePr
{
   boolean isBalanced=true;
    int height=-1;
    
    
}

class sumpair
{
int sum=0;
int max=Integer.MIN_VALUE;  //not 0 think why this should not 0
}



