package top_interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
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
		
		Binary_Tree_Level_Order_Traversal a = new Binary_Tree_Level_Order_Traversal();		
		List<List<Integer>> result = a.levelOrder(n1);
		System.out.println(result);
		
		
	}

//	 二叉树的层序遍历
//	使用了队列的数据结构
//  java中队列的add()和remove()方法在失败的时候会抛出异常(不推荐)
//	这里使用的是offer()以及poll()方法
//	LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 
		 List<List<Integer>> result = new ArrayList();
		 if(root == null) return result;
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.offer(root);
	     int level_num = 0;
		 while(!queue.isEmpty()){
			 level_num = queue.size();
			 List<Integer> level_result = new ArrayList();
			 for(int i=0;i<level_num;i++){
				 TreeNode node = queue.poll();
				 level_result.add(node.val);
				 
				 if(node.left != null) queue.offer(node.left);
				 if(node.right != null) queue.offer(node.right);	 
			 }
			 result.add(level_result);
		 }
		 return result;
	}

}
