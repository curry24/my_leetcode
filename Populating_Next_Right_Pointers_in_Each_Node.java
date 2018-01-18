package top_interview;

public class Populating_Next_Right_Pointers_in_Each_Node {
	public static class TreeLinkNode{
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x){
			val = x;
		}
	}
	
	public static void main(String args[]){
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		Populating_Next_Right_Pointers_in_Each_Node a = new Populating_Next_Right_Pointers_in_Each_Node();
		a.connect(n1);
	}

//	�����Ŀ���ǽ���������ÿһ�㶼��������������£�
//	    1 -> NULL
//    /  \
//   2 -> 3 -> NULL
//  / \  / \
// 4->5->6->7 -> NULL
//	��������Ҫע�⣺
//	You may only use constant extra space.
//	You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//	�����������뵽��ʹ�ö������Ĳ��������ʵ��
//	���ǣ��������Ĳ��������Ҫ�õ�һ�����У������Ͳ��� O(1) �Ŀռ临�Ӷ��ˡ�
//	���ǿ��Խ�����������������˼·��ͨ������ѭ����һ��ȷ��������һ�����������ڱ����н��ڵ�������
	public void connect(TreeLinkNode root){
		TreeLinkNode level = root;
		TreeLinkNode current = root;
		while(level != null){
			current = level; // ÿһ�������߿�ʼ����
			while(current != null){
				if(current.left != null) current.left.next = current.right;
				if(current.right != null && current.next != null) current.right.next = current.next.left;
				current = current.next;
			}
			level = level.left;
		}
	}
	
//	Ҳ����ͨ���ݹ���ʵ����������
//	public void connect(TreeLinkNode root){
//		if(root == null) return;
//		if(root.left != null) root.left.next = root.right;
//		if(root.right != null && root.next != null) root.right.next = root.next.left;
//		
//		connect(root.left);
//		connect(root.right);
//	}
}
