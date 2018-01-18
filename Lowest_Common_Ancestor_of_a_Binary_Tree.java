package top_interview;


public class Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
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
		
		Lowest_Common_Ancestor_of_a_Binary_Tree a = new Lowest_Common_Ancestor_of_a_Binary_Tree();
		TreeNode result = a.lowestCommonAncestor(n1, n3, n5);
		System.out.println(result.val);
	}
	
//	�������� ��ͨ������������������ȵ�����(LCA)
//	�����ö������ݹ������⣬����һЩ��֧�����ж�
//	��������������£�
	
//	1. ����ǰ�ڵ㼴Ϊ�����ڵ��е�һ������ʱ�򸸽ڵ㷵�ص�ǰ�ڵ㡣
//	      ����ǰ�ڵ�Ϊ�գ��򷵻ؿա�
	
//	2. ����ǰ�ڵ㲻�������ڵ��е�����һ������ʱӦ�ж����������ķ��ؽ����
//	      ���������������طǿսڵ㣬��ô��ǰ�ڵ�һ��������ĸ��ڵ㣬����ǰ�ڵ������ǰ�㱨��// �����ڵ�־���������
//	      ��������������һ���������طǿսڵ㣬�򽫴˷ǿսڵ��򸸽ڵ�㱨��// �ڵ������������һ�࣬�ҵ�ǰ�ڵ�ΪLCA
//	      ����������������NULL, ���򸸽ڵ㷵��NULL. // �ڵ㲻���������
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)  return null;
		if(root == p) return p;
		if(root == q) return q;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null) return root;
		if(left != null) return left;
		else return right;
	}
}
