package top_interview;


public class Remove_Nth_Node_From_End_of_List {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String args[]){
		ListNode node1 = new ListNode(-1);
		ListNode node2 = new ListNode(5);
	    ListNode node3 = new ListNode(11);
	    ListNode node4 = new ListNode(6);
	    ListNode node5 = new ListNode(45);
	    ListNode node6 = new ListNode(3);
       
	    node1.next = node2;
	    node2.next = node3;
	    node3.next = node4;
	    node4.next = node5;
	    node5.next = node6;
	   
	    Remove_Nth_Node_From_End_of_List a = new Remove_Nth_Node_From_End_of_List();
	    ListNode result = a.removeNthFromEnd(node1, 2);
	    while(result != null){
	    	System.out.println(result.val);
	    	result = result.next;
	    }
	}
	
//  这道题的关键就是如何寻找倒数第n个节点，但是如果要删除倒数第n个节点的话，应该定位到倒数第(n+1)个节点，就可以进行删除。
//  假设一共有m个节点，那么正数的第(m-n)个节点，其实就是倒数第(n+1)个节点。 
//	因此要设置两个链表，让第一个链表先正向走n个节点，剩下(m-n)个节点。然后再让两个链表一起向前走，直到第一个链表走到头，即第二个链表走了(m-n)个节点。
	public ListNode removeNthFromEnd(ListNode head, int n){
		 if(head == null) return null;
		 if(n<=0) return null;
			
		 ListNode temp = new ListNode(0);
		 temp.next = head;
		 ListNode first = temp;
		 ListNode second = temp;
		 for(int i=0;i<n;i++){
			 first = first.next;
		 }
		 while(first.next!=null){
			 first = first.next;
			 second = second.next;
		 }
		 
		 second.next = second.next.next;
		 
		 return temp.next;
		 
	}

}
