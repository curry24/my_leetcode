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
	
	
//  这种写法是错误的，这样只是对当前节点重新赋值，仅在当前函数下生效，并没有改变主函数中原始链表的指针的指向	
//	public void deleteNode(ListNode node){
//		node = node.next;
//		
//	}
	 
	public void deleteNode(ListNode node){
		node.val = node.next.val;  // 先改变当前节点的值
		node.next = node.next.next;  // 然后改变当前节点指针的指向，这样就相当于删除了当前节点。
	}

	
	
}
