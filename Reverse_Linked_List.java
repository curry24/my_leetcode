package top_interview;


public class Reverse_Linked_List {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ val=x;}
	}
	
	public static void main(String agrs[]){
		ListNode n_1 = new ListNode(2);
		ListNode n_2 = new ListNode(3);
		ListNode n_3 = new ListNode(4);
		n_1.next = n_2;
		n_2.next = n_3;		
		Reverse_Linked_List a = new Reverse_Linked_List();
		ListNode result = a.reverseList(n_1);
		while(result != null){
	    	System.out.println(result.val);
	    	result = result.next;
	    }
		
	}
	
	
//	反转链表
//	有两种实现方式，递归以及非递归
	
	
//	非递归的实现如下：
//	public ListNode reverseList(ListNode head){
//		if(head == null)  return null;
//		ListNode reverse = null;
//		while(head != null){
//			ListNode next = head.next;
//			head.next = reverse;
//			reverse = head;
//			head = next;
//		}
//		return reverse;
//	}

	
//	递归的实现如下：
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)  return head;
		return getReverse(head, null);
	}
	
	public ListNode getReverse(ListNode cur, ListNode prev){
		if(cur.next == null){
			cur.next = prev;
			return cur;
		}
		ListNode n1 = cur.next;
		cur.next = prev;
		return getReverse(n1, cur);
	}
}
