package segmentTree;

public class SegmentTree {
	
	private class Node
	{
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
		
		
	}

	Node root;
	public SegmentTree(int[] arr)
	{
		
		this.root=constructSegmentTree(arr,0	,arr.length-1);
	}
	private Node constructSegmentTree(int[] arr, int start, int end) {
		
		if(start==end)
		{
			Node leaf=new Node();
			leaf.data=arr[start];
			leaf.startInterval=start;
			leaf.endInterval=end;
			//left and right are null  by default
			return leaf;
		}
		Node node =new Node();
		node.startInterval=start;
		node.endInterval=end;
		
		int mid=(start+end)/2;
		node.left=constructSegmentTree(arr,start, mid);
		node.right=constructSegmentTree(arr, mid+1, end);
		
		
		
		node.data=node.left.data+node.right.data;
		
		
		return node;
	}
	
	//O(logn)  at most 4 nodes 4logn  O(logn) ignoring the constant 4
	public int Query(Node node,int si,int ei)
	{
		
		if(node==null)
			return 0;
		//node is completely lying inside query
		if(node.startInterval>=si && node.endInterval<=ei)
		{
			return node.data;
		}
		//this is when completely outside queries interval
		else if(node.startInterval>ei || node.endInterval<si)
		{
			return 0; //return default value of query
		}
		else
		{
			//this is overlapping interval case
			int l=Query(node.left,si, ei);
			int r=Query(node.right, si, ei);
			
			int ans=l+r;
			
			return ans;
		}
		
		
		
	}
	
	
	public int Update(Node node , int idx, int val)
	{
		if(node==null)
			return 0;
		
		if(idx>=node.startInterval && idx<=node.endInterval)
		{
			
			if(idx==node.startInterval && idx==node.endInterval)
			{
				node.data=val; //update data
			}
			else
			{
				int left=Update(node.left, idx, val);
				int right=Update(node.right, idx, val);
				node.data=left+right;
			}
		}
		
		
		
		
		return node.data;
		
		
	}
	
	
	public void display(Node node)
	{
		if(node==null)
			return;
		
		String str="";
		
		
		if(node.left!=null)
			str+="["+node.left.startInterval+","+node.left.endInterval+"]"+node.left.data;
		else
			str+=".";
		
		str+="-> ["+node.startInterval+","+node.endInterval+"]"+node.data+" <-";
		
		if(node.right!=null)
			str+="["+node.right.startInterval+","+node.right.endInterval+"]"+node.right.data;
		else
			str+=".";
		
		System.out.println(str);
		display(node.left);
		display(node.right);
		
		
	}
	
	
	
	public static void main(String[] args) {
		SegmentTree tree=new SegmentTree(new int[] {1,3,5,7,9,11});
		tree.display(tree.root);
		System.out.println(tree.Query(tree.root, 2, 4));
//		tree.root.data=tree.Update(tree.root, 2, 8);
//		tree.display(tree.root);
//		System.out.println(tree.Query(tree.root, 0, 10));

	}
	
	
	
	
}
