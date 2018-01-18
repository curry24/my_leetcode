package top_interview;

import java.util.List;


public class Balanced_Binary_Tree {
	
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
		
		Balanced_Binary_Tree a = new Balanced_Binary_Tree();
		if(a.isBalanced(n1)) System.out.println("True");
		else System.out.println("False");
		
	}
	
//	本题需要判断当前的二叉树是不是一颗平衡二叉树
//	平衡二叉树 (AVL树) 是其每个节点的左子树和右子树的高度最多差1的二叉查找树
//	AVL树就是为了解决二叉查找树的不平衡性导致时间复杂度大大下降，AVL保持住了二叉查找树的最好时间复杂度O(logn)
	
//	递归实现
//	首先看当前二叉树是否符合平衡二叉树条件
//	然后再分别递归地检查左子树以及右子树是否符合平衡二叉树
//	public boolean isBalanced(TreeNode root){
//		if(root == null) return true;
//		int l_height = height(root.left);
//		int r_height = height(root.right);
//		if(Math.abs(l_height - r_height) > 1) return false;
//		return isBalanced(root.left) && isBalanced(root.right);
//	}
	
//	计算二叉树高度的代码
//	public int height(TreeNode root){
//		if(root == null) return 0;
//		return Math.max(height(root.left), height(root.right))+1 ;
//	}
	
	
	
//	上面的方法效率很低，因为重复地进行了很多次子树的高度的计算
//	所以可以在计算子树的高度的同时，判断当前子树是否高度平衡(左右子树的高度差是否为1)，不平衡的返回 -1， 然后递归地返回-1，最终返回 -1， 表示不平衡
//	如果当前子树高度平衡，则返回子树的高度，递归地进行判断。
	public boolean isBalanced(TreeNode root){
		if(root == null) return true;
		if(height(root) == -1) return false;
		else return true;
	}
	
	public int height(TreeNode root){
		if(root == null) return 0;
		int l_height = height(root.left);
		int r_height = height(root.right);
		if(l_height == -1 || r_height == -1) return -1;
		if(Math.abs(l_height - r_height) > 1) return -1;
		return Math.max(l_height, r_height)+1 ;
	}
	
}
