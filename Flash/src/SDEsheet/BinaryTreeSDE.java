package SDEsheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import Tree.BinaryTree_dummy.Node;

public class BinaryTreeSDE {
	
	static  ArrayList<ArrayList<Integer>> list=new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());

		
	}
	
	/*
	 * maximum depth of binary tree
	 * https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/
	 * time : O(n) space: O(logn)
	 */
	 public int maxDepth(Node root) {
	        if(root==null)
	        return 0;
	        
	        int left=maxDepth(root.left);
	        int right=maxDepth(root.right);

	        return Math.max(left,right)+1;
	        
	    }
	
	 
	 /*
	  * check if tree is height balanced
	  * https://leetcode.com/problems/balanced-binary-tree/submissions/
	  * time : O(n) space: O(logn)
	  */
	 
	 public boolean isBalanced(Node root) {
		 
	        return isBalancedd(root).isBalanced;
	    }
	    public Pair isBalancedd(Node root)
	    {
	         if(root==null)
	        return new Pair(0,true);

	        Pair left=isBalancedd(root.left);
	        Pair right=isBalancedd(root.right);

	        if(!left.isBalanced || !right.isBalanced)
	            return new Pair(-1,false);
	        else
	        {
	            return new Pair(Math.max(left.height,right.height)+1,Math.abs(left.height-right.height)>1?false:true);
	        }

	    }
	    
	    /*
	     * find diameter of binary tree
	     * https://leetcode.com/problems/diameter-of-binary-tree/description/
	     * time: O(n) space: O(n)
	     */
	    public int diameterOfBinaryTree(Node root) {
	        return T(root).maxDia;
	    }
	    public PairDia T(Node root)
	    {
	        if(root==null)
	        return new PairDia(-1,0);

	        PairDia left=T(root.left);
	        PairDia right=T(root.right);

	        int maxdia=Math.max(left.maxDia,right.maxDia);
	    
	    return new PairDia(Math.max(left.height,right.height)+1,maxdia>left.height+right.height+2?maxdia:left.height+right.height+2);
	    }
	    
	    
	    
	    /*
	     * maximum path sum
	     * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
	     */
	    public int maxPathSum(Node root) {
	        return TT(root).maxsum;
	        }
	        
	        public PathPair TT(Node node)
	        {
	            if(node==null)
	                return new PathPair(0,-83273437);

	            PathPair left =  TT(node.left);
	            PathPair right = TT(node.right);

	           int sum = Math.max(node.data,Math.max(left.sum,right.sum) + node.data);

	           int max = Math.max(Math.max(Math.max(left.maxsum,right.maxsum),sum),left.sum+right.sum+node.data);
	           return new PathPair(sum,max);
	        }
	   

	        /*check if 2 trees are identical or not
	         * https://leetcode.com/problems/same-tree/submissions/
	         * time: O(n)
	         * 
	         */
	        public boolean isSameTree(Node p, Node q){
	            if(p==null || q==null)
	            {
	                return p==q;
	            }
	            return p.data==q.data && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	        }
	        
	        
	        /*
	         * 987. Vertical Order Traversal of a Binary Tree
			https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
	         */
	        
	        
	        
	        public List<List<Integer>> verticalTraversal(Node root) {
	            TreeMap<Integer,ArrayList<VerticalPair>> map=new TreeMap<>();
	             List<List<VerticalPair>> ans=new ArrayList<>();
	                      List<List<Integer>> anss=new ArrayList<>();

	            fill(root,0,0,map);
	           /// System.out.println(map);
	             for(Integer i:map.keySet())
	             {
	                 Collections.sort(map.get(i));
	                 ans.add(map.get(i));
	             }

	            for(List<VerticalPair> l:ans)
	            {
	                List<Integer> ll= l.stream().map(x -> x.val).collect(Collectors.toList());
	                anss.add(ll);
	            }
	             return anss;

	        }
	        public void fill(Node node,int row,int col,TreeMap<Integer,ArrayList<VerticalPair>> map)
	        {
	            if(node==null) return;
	            insert(map,row,col,node.data);
	            fill(node.left,row+1,col-1,map);
	            fill(node.right,row+1,col+1,map);
	            
	        }
	        public void insert(TreeMap<Integer,ArrayList<VerticalPair>> map,int row,int col,int val)
	        {
	            if(map.containsKey(col))
	            map.get(col).add(new VerticalPair(row,col,val));
	            else
	            {
	                ArrayList<VerticalPair> list=new ArrayList<>();
	                list.add(new VerticalPair(row,col,val));
	                map.put(col,list);
	            }

	        }
	    
	        /*
	         * in top and bottom view questions we have to traverse level order oherwise answer would be wrong as given tree is not compete binary tree
	         * 
	         */
	        
	        static ArrayList<Integer> topView(Node root)
	        {
	              TreeMap<Integer,Integer> map=new TreeMap<>();
	            ArrayList<Integer> a=new ArrayList<>();
	           fill(root,0,map);
	           // System.out.println(map);
	             for(Integer ll:map.values())
	             {
	                a.add(ll);
	             }


	             return a;

	        }
	        public static void fill(Node node,int col,TreeMap<Integer,Integer> map)
	        {
	            
	            Queue<BottomPair> q=new LinkedList<>();
	            q.add(new BottomPair(0,node));
	            
	            while(q.size()>0)
	            {
	                BottomPair curr=q.poll();
	                
	                if(!map.containsKey(curr.col)) //comment this line in case of bottom view
	                map.put(curr.col,curr.node.data);
	                
	                if(curr.node.left!=null)
	                {
	                    q.add(new BottomPair(curr.col-1,curr.node.left));
	                }
	                if(curr.node.right!=null)
	                {
	                    q.add(new BottomPair(curr.col+1,curr.node.right));
	                }
	                
	            }
	  
	            
	        }
	      
	    /* 
	     * print right side of binary tree
	     */
	        public List<Integer> rightSideView(Node root) {

	        //TreeMap<Integer,Integer> map=new TreeMap<>();
	             ArrayList<Integer> a=new ArrayList<>();
	             if(root==null)
	             return a;
	            fills(root,0,a);
	          
	              return a;

	         }
	         public  void fills(Node node,int row,ArrayList<Integer> map)
	         {
	      
	                     if(node==null) return;
	                     if(row==map.size())
	                             map.add(row,node.data);
	             fills(node.right,row+1,map);

	             fills(node.left,row+1,map);

	             
	         }
	       
	   
	         	/*
	         	 * check if tree is mirror/symmectric of itself
	         	 */
	         public boolean isSymmetric(Node root) {
	             return T(root,root);
	         }
	         public boolean T(Node root1,Node root2)
	         {
	             if(root1==null || root2==null)
	             return root1==root2;

	             return root1.data==root2.data && T(root1.left,root2.right) && T(root1.right,root2.left);
	         }
	 



}
	   
	        
	        
	        
	        
	        
	        
	    
	   


class Pair{
    int height;
    boolean isBalanced;

    Pair(int h,boolean isBalanced)
    {
        height=h;
        this.isBalanced=isBalanced;
    }
}

class PairDia
{
    int height;
    int maxDia;
    PairDia(int h,int maxDia)
    {
        height=h;
        this.maxDia=maxDia;
    }
}

class PathPair
{
    int sum;
    int maxsum;
    PathPair(int s,int m)
    {
        sum=s;
        maxsum=m;
    }
}


class VerticalPair implements Comparable<VerticalPair>
{
    int row;
    int col;
    int val;

    VerticalPair(int r,int c,int vl)
    {
        row=r;
        col=c;
        val=vl;
    }
     public int compareTo(VerticalPair m)
    {
        if(this.row==m.row)
        return this.val-m.val;
        else
        return this.row-m.row;
    }
    public String toString(){
    return "row:"+this.row+" col:"+this.col+" val:"+this.val;
    }
}

class BottomPair
{
    int col;
    Node node;
    BottomPair(int c,Node n)
    {
        col=c;
        node=n;
    }
}

