package top_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {

	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val=x; }
	}
	
	public static void main(String args[]){
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		
		Binary_Tree_Inorder_Traversal a = new Binary_Tree_Inorder_Traversal();
		System.out.println(a.inorderTraversal(n1));
		
	}

//	二叉树的中序遍历，遍历的顺序是 左根右
//	有两种实现方式，递归的方式以及非递归的方式
	
//	递归实现
//	public List<Integer> inorderTraversal(TreeNode root){
//		
//		List<Integer> result = new ArrayList<Integer>();
//		if(root == null) return result;
//		recursion(root, result);
//		return result;		
//	}
//	
//	public void recursion(TreeNode root, List<Integer> result){
//		if(root != null){
//			recursion(root.left, result);
//			result.add(root.val);
//			recursion(root.right, result);
//		}		
//		
//	}
	
	
//	非递归实现
//	用栈先把根节点的所有左孩子都添加到栈内， 
//	然后输出栈顶元素，再处理栈顶元素的右子树 
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node !=null){
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			result.add(node.val);
			node = node.right;
		}
		
		return result;
	}


}
