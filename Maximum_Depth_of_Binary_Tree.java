package top_interview;

import java.util.LinkedList;
import java.util.Queue;


public class Maximum_Depth_of_Binary_Tree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
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
		
		Maximum_Depth_of_Binary_Tree a = new Maximum_Depth_of_Binary_Tree ();
		System.out.println(a.maxDepth(n1));
	}

//	���������������
//	������ʵ�ַ������ݹ�ʵ���Լ��ǵݹ�ʵ��

//	�ݹ�ʵ�ֵĴ������£�
//	public int maxDepth(TreeNode root){
//		if(root == null) return 0;
//		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//	}

	
//	�ǵݹ�ʵ�ֵĴ��룺
//	ʹ�õ��Ƕ������Ĳ�������ķ���
//	ÿ����һ�㣬������ 1�����������󣬷��صľ�������Ĳ�����
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode> ();
		queue.offer(root);
		int max_deepth = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			max_deepth++;
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
		}
		return max_deepth;
		
	}
}
