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
	
//	������Ҫ���ݸ�����ǰ�����(������)���������(�����) �������һ�Ŷ���������(������û���ظ�������)
//	����ǰ����������Ժ�����֪�����ڵ�Ĵ�С���ٲ鿴������������Եõ���������и��ڵ������������������λ��
//	Ȼ����Խ�һ���õ�ǰ������и��ڵ�����������������λ�ã����ҿ��Եõ����������������ĸ��ڵ�
//	���žͿ��Եݹ�ؽ��ж������Ĺ���
	public TreeNode buildTree(int[] preorder, int[] inorder){
		
		if (preorder == null || inorder == null) return null;
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
		
		TreeNode tree = Digui(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
		return tree;
		
	}
	
//	�ݹ鹹��������ķ�������Ҫ������ǰ����ǰ������Լ������������ʼ����ֹ��λ��
	public TreeNode Digui(int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end){
		if(preorder_start > preorder_end || inorder_start > inorder_end) return null;
		int root_val = preorder[preorder_start];
		TreeNode root = new TreeNode(root_val);
		int root_index = find_index(inorder, inorder_start, inorder_end, root_val);
		root.left = Digui(preorder, inorder, preorder_start+1, preorder_start+root_index-inorder_start, inorder_start, root_index-1);
		root.right = Digui(preorder, inorder, preorder_start+root_index-inorder_start+1, preorder_end, root_index+1, inorder_end);
		return root;
	}
	
//	��ǰ���������֪�����ڵ��ֵ��Ȼ�������������Ѱ�Ҹ��ڵ��λ�ò�����
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
