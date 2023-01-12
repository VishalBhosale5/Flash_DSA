package Tree;

import Tree.BinaryTree_dummy.Node;

public class SumOfLeafNodesOfBinaryTree {
	public static void main(String[] args) {
		BinaryTree_dummy tree=new BinaryTree_dummy();
		
		//50 1 20 1 40 -1 -1 1 50 -1 -1 1 30 1 60 -1 -1 1 70 -1 1 80 -1 -1
		System.out.println(getLeafSm(tree.root));
	}

	private static int getLeafSm(Node node) {
		if(node==null)
			return 0;
		
		/*int sum=0;
		
		if(node.left==null && node.right==null)
			sum=node.data;
		
		if(node.left!=null)
			sum+=getLeafSm(node.left);
		if(node.right!=null)
			sum+=getLeafSm(node.right);
		
		return sum;*/
		//another approach
		
		
		if(node.left==null && node.right==null)
			return node.data;
		int left=getLeafSm(node.left);
		int right=getLeafSm(node.right);
		
		return left+right;
	}
}
