package top_interview;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	public static void main(String args[]){
		int preorder[] = {1, 2, 4, 5, 3, 6, 8, 7};
		int inorder[] = {4, 2, 5, 1, 6, 8, 3, 7};
		
		Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal a = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		TreeNode tree = a.buildTree(preorder, inorder);
		
	}
	
//	本题需要根据给出的前序遍历(根左右)和中序遍历(左根右) 来构造出一颗二叉树来。(数组中没有重复的数字)
//	根据前序遍历，可以很容易知道根节点的大小，再查看中序遍历，可以得到中序遍历中根节点的左子树和右子树的位置
//	然后可以进一步得到前序遍历中根节点左子树和右子树的位置，并且可以得到左子树和右子树的根节点
//	接着就可以递归地进行二叉树的构造
	public TreeNode buildTree(int[] preorder, int[] inorder){
		
		if (preorder == null || inorder == null) return null;
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
		
		TreeNode tree = Digui(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
		return tree;
		
	}
	
//	递归构造二叉树的方法，需要给出当前子树前序遍历以及中序遍历的起始与终止的位置
	public TreeNode Digui(int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end){
		if(preorder_start > preorder_end || inorder_start > inorder_end) return null;
		int root_val = preorder[preorder_start];
		TreeNode root = new TreeNode(root_val);
		int root_index = find_index(inorder, inorder_start, inorder_end, root_val);
		root.left = Digui(preorder, inorder, preorder_start+1, preorder_start+root_index-inorder_start, inorder_start, root_index-1);
		root.right = Digui(preorder, inorder, preorder_start+root_index-inorder_start+1, preorder_end, root_index+1, inorder_end);
		return root;
	}
	
//	由前序遍历可以知道根节点的值，然后在中序遍历中寻找根节点的位置并返回
	public int find_index(int[] array, int start, int end, int x){
		int index = -1;
		for(int i=start;i<=end;i++){
			if(array[i] == x){
				index = i;
				break;
			}
		}
		return index;
	}

}
