package top_interview;

import java.util.Stack;


public class Kth_Smallest_Element_in_a_BST {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	public static void main(String args[]){
		
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		
		Kth_Smallest_Element_in_a_BST a = new Kth_Smallest_Element_in_a_BST();
		System.out.println(a.kthSmallest(n1, 3));
	}

//	寻找二叉查找树的第k小的元素
//	因为二叉查找树的中序遍历是一个由小到大的有序排列
//	因此，可以先对二叉查找树进行中序遍历，然后去排列中的第 k-1 个元素的值

//	以下是中序遍历的递归写法：
//	List<Integer> sortedlists = new ArrayList<Integer>();
//	public int kthSmallest(TreeNode root, int k){
//		Inorder(root);
//		int result = sortedlists.get(k-1);
//		return result;
//	}
//	
//	public void Inorder(TreeNode root){
//		if(root.left != null) Inorder(root.left);
//		sortedlists.add(root.val);
//		if(root.right != null) Inorder(root.right);	
//	}
	
	
//	以下是非递归的中序遍历
	public int kthSmallest(TreeNode root, int k){
		int order = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			TreeNode out = stack.pop();
			order++;
			if(order == k) return out.val;
			node = out.right;
			
		}
		return 0;
	}
	
	
}
