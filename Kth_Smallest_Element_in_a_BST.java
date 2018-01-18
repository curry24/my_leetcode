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

//	Ѱ�Ҷ���������ĵ�kС��Ԫ��
//	��Ϊ��������������������һ����С�������������
//	��ˣ������ȶԶ���������������������Ȼ��ȥ�����еĵ� k-1 ��Ԫ�ص�ֵ

//	��������������ĵݹ�д����
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
	
	
//	�����Ƿǵݹ���������
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
