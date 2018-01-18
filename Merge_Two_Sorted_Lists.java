package top_interview;

public class Merge_Two_Sorted_Lists {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		
		n4.next = n5;
		n5.next = n6;
		
		Merge_Two_Sorted_Lists a = new Merge_Two_Sorted_Lists();
		ListNode result = a.mergeTwoLists(n1, n4);
		while(result!=null){
			System.out.print(result.val+" ");
			result = result.next;
		}
		
	}
	
//	Merge two sorted linked lists and return it as a new list. 
//	The new list should be made by splicing together the nodes of the first two lists.
//	Example:
//	Input: 1->2->4, 1->3->4
//	Output: 1->1->2->3->4->4
	
//	����Ҫ����������������� L1 �� L2 merge sort
//	�����еݹ�ķ����Լ��ǵݹ�ķ���
	
//	�ǵݹ�ķ������£�
//	The key to solve the problem is defining a fake head.
//	Then compare the first elements from each list.
//	Add the smaller one to the merged list.
//	Finally, when one of them is empty, simply append it to the merged list, since it is already sorted.

//	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//		ListNode fake_head = new ListNode(-1);
//		ListNode merge = fake_head;
//		while(l1 != null && l2 != null){
//			if(l1.val < l2.val){
//				merge.next = l1;
//				l1 = l1.next;
//				merge = merge.next;
//			}
//			else{
//				merge.next = l2;
//				l2 = l2.next;
//				merge = merge.next;
//			}
//		}
//		if(l1 == null) merge.next = l2;
//		if(l2 == null) merge.next = l1;
//		
//		return fake_head.next;
//		
//	}
	
//	�ݹ�Ľⷨ���£�
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		// ÿ���ҵ����������е���Сֵ����ǰ��Сֵ.next = ��һ�αȽ��е���Сֵ
		if(l1.val <= l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

}
