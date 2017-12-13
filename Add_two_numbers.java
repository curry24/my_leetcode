package top_interview;

public class Add_two_numbers {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public static void main(String args[]){
		ListNode n_1 = new ListNode(2);
		n_1.next = new ListNode(4);
		n_1.next.next = new ListNode(3);
		ListNode n_2 = new ListNode(5);
		n_2.next = new ListNode(6);
		n_2.next.next = new ListNode(4);
		Add_two_numbers a = new Add_two_numbers();
		ListNode result = a.addTwoNumbers(n_1, n_2);
		System.out.println(result.val);
		System.out.println(result.next.val);
		System.out.println(result.next.next.val);	
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null){
			return null;
		}
		ListNode result = new ListNode(0);
		ListNode pointer = result;
//		result会随着pointer的变化而变化
		int carry = 0;
		
		while(l1 != null || l2 != null){
			if(l1 != null){
				carry+=l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null){
				carry+=l2.val;
				l2 = l2.next;
			}
			pointer.next = new ListNode(carry%10);
			carry/=10;
			pointer = pointer.next;
			
		}
		
		if (carry > 0) {
		    pointer.next = new ListNode(carry);
		}	
		return result.next;       
    }

}
