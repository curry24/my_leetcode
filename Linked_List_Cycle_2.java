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
	 
//	 本题是基于Linked_List_Cycle这一题(发现快慢指针相遇后就返回true了)
//	 而这里我们还要继续找到环的起始点。
//	 详细讲解可以看链接如下：http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html

	 
//	 现在有两个指针，第一个指针，每走一次走一步，第二个指针每走一次走两步，如果他们走了t次之后相遇在K点
//	 那么指针一走的路是： t = X + nY + K ①
//	 指针二 走的路是：      2t = X + mY+ K ②   m,n为未知数
//	 把等式一代入到等式二中, 有
//	 2X + 2nY + 2K = X + mY + K
//	  即：  X+K = (m-2n)Y ③
//   这就清晰了，X和K的关系是基于Y互补的。
//	  等于说，两个指针相遇以后，让fast回到初始点(head)，并且每次也走一步，
//	 slow继续每次走一步，当两个指针同时走X步后，就可以在环的起始点相遇了。
//	  这就可以有O(N)的实现了。
	 
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
