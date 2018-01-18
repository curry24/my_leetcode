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
	
//	��ż�������⣬����һ����������������λ�õĽڵ㡰�ᡱ��ǰ�棬�����ż��λ�õĽڵ�
//	�趨����ָ�룬һ��ָ������λ�ã�һ��ָ��ż��λ��
//	����Ҫ����ż��ָ��Ŀ�ͷ even_head�������ڱ���һ��֮�󣬽���������������
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
