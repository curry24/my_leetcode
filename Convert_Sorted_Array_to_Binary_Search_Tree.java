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
	
//	������Ҫ���ݸ�������������飬����һ�Ŵ���ƽ�������Ķ��������(ƽ�����������AVL��)
//	һ��AVL������ÿ���ڵ�����������������ĸ߶�����1�Ķ��������
//	AVL������Ϊ�˽������������Ĳ�ƽ���Ե���ʱ�临�Ӷȴ���½���AVL����ס��(BST)�����ʱ�临�Ӷ�O(logn)��
//	����ʹ�õݹ�ķ������Խ��
//	ÿ��Ѱ�ҵ�ǰ��Χ���е���Ϊ���ڵ㼴��
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
