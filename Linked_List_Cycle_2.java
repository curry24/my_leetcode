package top_interview;


public class Linked_List_Cycle_2 {
	
	 public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	 public static void main(String args[]){

		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		node.next = node1;
		node1.next = node2;
		node2.next = node;
		Linked_List_Cycle_2 a = new Linked_List_Cycle_2();
		System.out.println(a.detectCycle(node).val);

	}
	 
//	 �����ǻ���Linked_List_Cycle��һ��(���ֿ���ָ��������ͷ���true��)
//	 ���������ǻ�Ҫ�����ҵ�������ʼ�㡣
//	 ��ϸ������Կ��������£�http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html

	 
//	 ����������ָ�룬��һ��ָ�룬ÿ��һ����һ�����ڶ���ָ��ÿ��һ���������������������t��֮��������K��
//	 ��ôָ��һ�ߵ�·�ǣ� t = X + nY + K ��
//	 ָ��� �ߵ�·�ǣ�      2t = X + mY+ K ��   m,nΪδ֪��
//	 �ѵ�ʽһ���뵽��ʽ����, ��
//	 2X + 2nY + 2K = X + mY + K
//	  ����  X+K = (m-2n)Y ��
//   ��������ˣ�X��K�Ĺ�ϵ�ǻ���Y�����ġ�
//	  ����˵������ָ�������Ժ���fast�ص���ʼ��(head)������ÿ��Ҳ��һ����
//	 slow����ÿ����һ����������ָ��ͬʱ��X���󣬾Ϳ����ڻ�����ʼ�������ˡ�
//	  ��Ϳ�����O(N)��ʵ���ˡ�
	 
	 public ListNode detectCycle(ListNode head){
		 if(head == null) return null;
		 ListNode fast = head;
		 ListNode slow = head;
		 
		 while(fast!=null && fast.next!=null){
			 slow = slow.next;
			 fast = fast.next.next;
			 if(slow == fast){
				 fast = head;
				 while(fast != slow){
					 fast = fast.next;
					 slow = slow.next;
				 }
				 return fast;
			 }
				 
		 } 
		 return null;
	 }
}
