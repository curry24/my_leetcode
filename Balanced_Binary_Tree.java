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
	
//	������Ҫ�жϵ�ǰ�Ķ������ǲ���һ��ƽ�������
//	ƽ������� (AVL��) ����ÿ���ڵ�����������������ĸ߶�����1�Ķ��������
//	AVL������Ϊ�˽������������Ĳ�ƽ���Ե���ʱ�临�Ӷȴ���½���AVL����ס�˶�������������ʱ�临�Ӷ�O(logn)
	
//	�ݹ�ʵ��
//	���ȿ���ǰ�������Ƿ����ƽ�����������
//	Ȼ���ٷֱ�ݹ�ؼ���������Լ��������Ƿ����ƽ�������
//	public boolean isBalanced(TreeNode root){
//		if(root == null) return true;
//		int l_height = height(root.left);
//		int r_height = height(root.right);
//		if(Math.abs(l_height - r_height) > 1) return false;
//		return isBalanced(root.left) && isBalanced(root.right);
//	}
	
//	����������߶ȵĴ���
//	public int height(TreeNode root){
//		if(root == null) return 0;
//		return Math.max(height(root.left), height(root.right))+1 ;
//	}
	
	
	
//	����ķ���Ч�ʺܵͣ���Ϊ�ظ��ؽ����˺ܶ�������ĸ߶ȵļ���
//	���Կ����ڼ��������ĸ߶ȵ�ͬʱ���жϵ�ǰ�����Ƿ�߶�ƽ��(���������ĸ߶Ȳ��Ƿ�Ϊ1)����ƽ��ķ��� -1�� Ȼ��ݹ�ط���-1�����շ��� -1�� ��ʾ��ƽ��
//	�����ǰ�����߶�ƽ�⣬�򷵻������ĸ߶ȣ��ݹ�ؽ����жϡ�
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
