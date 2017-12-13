package top_interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import top_interview.Binary_Tree_Level_Order_Traversal.TreeNode;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	
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
		
		Binary_Tree_Zigzag_Level_Order_Traversal a = new Binary_Tree_Zigzag_Level_Order_Traversal();
		System.out.println(a.zigzagLevelOrder(n1));
	}

//	这道题仍然是对二叉树进行层序遍历
//	与 Binary_Tree_Level_Order_Traversal 这道题目不同的是，本题需要对二叉树进行蛇形的层序遍历
//	可以看出，蛇形的层序遍历的特点是：
//	偶数层自左向右遍历，奇数层自右向左遍历 (根节点是第0层)
//	在原始的层序遍历中使用了队列，来进行每一层的输出
//	因此，本题依然可以使用队列，只不过奇数层的List要进行翻转
//	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
//		 List<List<Integer>> result = new ArrayList();
//		 if(root == null) return result;
//		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		 queue.offer(root);
//	     int current_num = 0;
//	     boolean odd = true;
//		 while(!queue.isEmpty()){
//			 current_num = queue.size();
//			 List<Integer> level_result = new ArrayList();
//			 for(int i=0;i<current_num;i++){
//				 TreeNode node = queue.poll();
//				 level_result.add(node.val);
//				 if(node.left != null) queue.offer(node.left);
//				 if(node.right != null) queue.offer(node.right);	 
//			 }
//			 if(odd) result.add(level_result);
//			 else{
//				 Collections.reverse(level_result);
//				 result.add(level_result);
//			 }
//			 odd = !odd;
//		 }
//		 return result;
//	}
	
	
//	还有一种方法，可以使用2个栈来分别输出奇数层和偶数层 (1个栈的话输出顺序会出错)
//	有一点需要注意，奇数层需要右节点先入栈，左节点后入栈；
//	偶数层则是左节点先入栈，右节点后入栈
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList();
		if(root == null) return result;
		Stack<TreeNode> stack_0 = new Stack<TreeNode>();
		Stack<TreeNode> stack_1 = new Stack<TreeNode>();
		stack_0.push(root);
		int current_num = 0;
		int level_num = 0;
		while(!stack_0.isEmpty() || !stack_1.isEmpty()){
			List<Integer> result_level = new ArrayList();
			if(level_num % 2 == 0){ 
				current_num = stack_0.size();
				for(int i=0;i<current_num;i++){
					TreeNode node = stack_0.pop();
					result_level.add(node.val);
					if(node.left != null) stack_1.push(node.left);
					if(node.right != null) stack_1.push(node.right);
				}
				result.add(result_level);
			}
			else{
				current_num = stack_1.size();
				for(int i=0;i<current_num;i++){
					TreeNode node = stack_1.pop();
					result_level.add(node.val);		
					if(node.right != null) stack_0.push(node.right);
					if(node.left != null) stack_0.push(node.left);
				}
				result.add(result_level);
			}
			level_num++;
		}		
		return result;
	}

}
