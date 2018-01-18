package top_interview;

public class Odd_Even_Linked_List {
	
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ val=x; }
	}
	
	public static void main(String args[]){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		Odd_Even_Linked_List a = new Odd_Even_Linked_List();
		ListNode result = a.oddEvenList(node1);
		
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	
	}
	
//	奇偶链表问题，给定一个链表，将所有奇数位置的节点“提”到前面，后面接偶数位置的节点
//	设定两个指针，一个指向奇数位置，一个指向偶数位置
//	还需要保留偶数指针的开头 even_head，方便在遍历一遍之后，接在奇数链表的最后
	public ListNode oddEvenList(ListNode head){
		if(head == null) return null;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode even_head = even;
		while(even != null && even.next != null){
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = even_head;
		return head;
	}

}
