package top_interview;

public class Populating_Next_Right_Pointers_in_Each_Node {
	public static class TreeLinkNode{
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x){
			val = x;
		}
	}
	
	public static void main(String args[]){
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		Populating_Next_Right_Pointers_in_Each_Node a = new Populating_Next_Right_Pointers_in_Each_Node();
		a.connect(n1);
	}

//	本题的目的是将二叉树的每一层都连起来，结果如下：
//	    1 -> NULL
//    /  \
//   2 -> 3 -> NULL
//  / \  / \
// 4->5->6->7 -> NULL
//	有两点需要注意：
//	You may only use constant extra space.
//	You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//	本题我首先想到是使用二叉树的层序遍历来实现
//	但是，二叉树的层序遍历需要用到一个队列，这样就不是 O(1) 的空间复杂度了。
//	但是可以借鉴二叉树层序遍历的思路，通过两层循环，一层确定层数，一层横向遍历，在遍历中将节点连起来
	public void connect(TreeLinkNode root){
		TreeLinkNode level = root;
		TreeLinkNode current = root;
		while(level != null){
			current = level; // 每一层从最左边开始遍历
			while(current != null){
				if(current.left != null) current.left.next = current.right;
				if(current.right != null && current.next != null) current.right.next = current.next.left;
				current = current.next;
			}
			level = level.left;
		}
	}
	
//	也可以通过递归来实现上述过程
//	public void connect(TreeLinkNode root){
//		if(root == null) return;
//		if(root.left != null) root.left.next = root.right;
//		if(root.right != null && root.next != null) root.right.next = root.next.left;
//		
//		connect(root.left);
//		connect(root.right);
//	}
}
