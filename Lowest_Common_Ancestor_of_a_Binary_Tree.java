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
	
//	本题是求 普通二叉树的最近公共祖先的问题(LCA)
//	可以用二叉树递归遍历求解，并对一些分支做出判断
//	具体情况分析如下：
	
//	1. 若当前节点即为两个节点中的一个，此时向父节点返回当前节点。
//	      若当前节点为空，则返回空。
	
//	2. 若当前节点不是两个节点中的任意一个，此时应判断左右子树的返回结果。
//	      若左右子树均返回非空节点，那么当前节点一定是所求的根节点，将当前节点逐层向前汇报。// 两个节点分居树的两侧
//	      若左右子树仅有一个子树返回非空节点，则将此非空节点向父节点汇报。// 节点仅存在于树的一侧，且当前节点为LCA
//	      若左右子树均返回NULL, 则向父节点返回NULL. // 节点不在这棵树中
	
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
