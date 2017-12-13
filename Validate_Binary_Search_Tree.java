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
	
//	���һ�Ŷ������ǲ��Ƕ������������������������������������
//	��������������������
//	1.�������ϵ����нڵ�ֵ��С�ڸ��ڵ�ֵ��2�������ϵ����нڵ�ֵ�����ڸ��ڵ�ֵ��3����������Ҳ����������������


//	�ݹ�ʵ��(�������µĲ�����������ʧЧ)
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
	
	
//	����ʵ�֣����뵽���������������
//	�����ǰ��������һ�Ŷ������������ǰ�������ĵ���������Ľ��������һ����������
//	ֻ���ж��ǲ��ǵ�������
	List<Integer>result = new ArrayList<Integer>();
	public boolean isValidBST(TreeNode root){
		if(root == null) return true;
		InorderTraversal(root);
		for(int i=0;i<result.size()-1;i++){
			if(result.get(i)>=result.get(i+1)) return false;
		}
		return true;
		
	}

//	��������ݹ�ʵ��
	public void InorderTraversal(TreeNode root){
		if(root == null) return;
		InorderTraversal(root.left);
		result.add(root.val);
		InorderTraversal(root.right);
	}
	

	
	
	
}
