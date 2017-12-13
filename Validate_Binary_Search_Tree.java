package top_interview;

import java.util.ArrayList;
import java.util.List;


public class Validate_Binary_Search_Tree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	public static void main(String args[]){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		
		Validate_Binary_Search_Tree a = new Validate_Binary_Search_Tree ();
		if(a.isValidBST(n1)) System.out.println("True");
		else System.out.println("False");
		
	}
	
//	检查一颗二叉树是不是二叉查找树（二叉搜索树、二叉排序树）；
//	二叉查找树满足的条件：
//	1.左子树上的所有节点值均小于根节点值，2右子树上的所有节点值均大于根节点值，3，左右子树也满足上述两个条件


//	递归实现(增加了新的测试用例，已失效)
//	public boolean isValidBST(TreeNode root){
//		if(root == null) return true;
//		if(root.left == null && root.right == null) return true;
//		return digui(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//	}
//	
//	public boolean digui(TreeNode root, int min, int max){
//		if(root == null) return true;
//		if(root.val <= min || root.val >= max) return false;
//		return digui(root.left, min, root.val) && digui(root.right, root.val, max);
//	}
	
	
//	迭代实现，联想到二叉树的中序遍历
//	如果当前二叉树是一颗二叉查找树，则当前二叉树的的中序遍历的结果，就是一个递增序列
//	只需判断是不是递增序列
	List<Integer>result = new ArrayList<Integer>();
	public boolean isValidBST(TreeNode root){
		if(root == null) return true;
		InorderTraversal(root);
		for(int i=0;i<result.size()-1;i++){
			if(result.get(i)>=result.get(i+1)) return false;
		}
		return true;
		
	}

//	中序遍历递归实现
	public void InorderTraversal(TreeNode root){
		if(root == null) return;
		InorderTraversal(root.left);
		result.add(root.val);
		InorderTraversal(root.right);
	}
	

	
	
	
}
