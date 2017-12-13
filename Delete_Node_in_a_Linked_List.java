package top_interview;


public class Delete_Node_in_a_Linked_List {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String args[]){
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		Delete_Node_in_a_Linked_List a = new Delete_Node_in_a_Linked_List();
		a.deleteNode(node.next);
		
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
		
	}
	
	
//  ����д���Ǵ���ģ�����ֻ�ǶԵ�ǰ�ڵ����¸�ֵ�����ڵ�ǰ��������Ч����û�иı���������ԭʼ�����ָ���ָ��	
//	public void deleteNode(ListNode node){
//		node = node.next;
//		
//	}
	 
	public void deleteNode(ListNode node){
		node.val = node.next.val;  // �ȸı䵱ǰ�ڵ��ֵ
		node.next = node.next.next;  // Ȼ��ı䵱ǰ�ڵ�ָ���ָ���������൱��ɾ���˵�ǰ�ڵ㡣
	}

	
	
}
