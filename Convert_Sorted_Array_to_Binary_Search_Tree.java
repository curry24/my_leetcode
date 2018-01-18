package top_interview;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	public static void main(String args[]){
		int[] nums = {-10, -3, 0 ,5, 9};
		Convert_Sorted_Array_to_Binary_Search_Tree a = new Convert_Sorted_Array_to_Binary_Search_Tree();
		TreeNode tree = a.sortedArrayToBST(nums);
	}
	
//	本题需要根据给出的升序的数组，构造一颗带有平衡条件的二叉查找树(平衡二叉树、或AVL树)
//	一棵AVL树是其每个节点的左子树和右子树的高度最多差1的二叉查找树
//	AVL树就是为了解决二叉查找树的不平衡性导致时间复杂度大大下降，AVL保持住了(BST)的最好时间复杂度O(logn)，
//	本题使用递归的方法可以解决
//	每次寻找当前范围的中点作为根节点即可
	public TreeNode sortedArrayToBST(int[] nums){
		if (nums.length == 0) return null;
		TreeNode tree = digui(0, nums.length-1, nums);
		return tree;
	}
	
	public TreeNode digui(int start, int end, int[] nums){
		if(start>end) return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = digui(start, mid-1, nums);
		root.right = digui(mid+1, end, nums);
		return root;
	}
}
