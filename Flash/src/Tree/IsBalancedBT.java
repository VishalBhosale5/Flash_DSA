package Tree;

import java.util.Scanner;

public class IsBalancedBT {


		static Scanner scn = new Scanner(System.in);

		public static void main(String[] args) {
			IsBalancedBT m = new IsBalancedBT();
			BinaryTree bt = m.new BinaryTree();
			System.out.println(bt.isBalanced());
		}

		private class BinaryTree {
			private class Node {
				int data;
				Node left;
				Node right;
			}

			private Node root;
			private int size;

			public BinaryTree() {
				this.root = this.takeInput(null, false);
			}

			public Node takeInput(Node parent, boolean ilc) {

				int cdata = scn.nextInt();
				Node child = new Node();
				child.data = cdata;
				this.size++;

				// left
				boolean hlc = scn.nextBoolean();

				if (hlc) {
					child.left = this.takeInput(child, true);
				}

				// right
				boolean hrc = scn.nextBoolean();

				if (hrc) {
					child.right = this.takeInput(child, false);
				}

				// return
				return child;
			}

			public boolean isBalanced() {
				return this.isBalanced(this.root).isBalanced;
			}

			private BalancedPair isBalanced(Node node) {
				// write your code here
	        int height=0;
	            
	            if(node==null)
	            {
	                BalancedPair p=new BalancedPair();
	                p.isBalanced=true;
	                p.height=0;
	                return p;
	            }

	         
	                 BalancedPair ans=new BalancedPair();
	                  BalancedPair l= isBalanced(node.left);
	                
	                  BalancedPair r=isBalanced(node.right);
	               

	                  if(Math.abs(l.height-r.height)<=1 && l.isBalanced && r.isBalanced)
	                  {
	                      ans.isBalanced=true;
	                     ans.height=l.height>r.height?l.height:r.height;
	                     ans.height++;
	                  }

	         

	                       // System.out.println(node.data+" height: "+ans.height);

	        return ans;
				
			}

			private class BalancedPair {
				int height;
				boolean isBalanced;
			}

		}
	}
