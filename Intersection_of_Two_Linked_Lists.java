package top_interview;

public class Intersection_of_Two_Linked_Lists {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public static void main(String args[]){
		ListNode a = new ListNode(3);
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(7);
		ListNode n4 = new ListNode(9);
		ListNode n5 = new ListNode(11);
		ListNode b = new ListNode(2);
		ListNode n6 = new ListNode(4);
		
		a.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		b.next = n6;
		
		
		Intersection_of_Two_Linked_Lists m = new Intersection_of_Two_Linked_Lists();
		ListNode result = m.getIntersectionNode(a, b);
		if(result == null) System.out.println("null");
		else System.out.println(result.val);
	}
	
//	本题要求两个单链表的交点的问题
//	如果两个链表相交，则返回交点，否则，返回null

//	本题首先的思路是：
//	分别求出两个链表的长度，得出长度差
//	然后让长的链表先往前走 长度差 个节点
//	之后，再让两个链表一起往前走，如果节点相同，则相交，返回交点，否则返回null
//	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//		if(headA == null || headB == null) return null;
//		int lengthA = 0;
//		int lengthB = 0;
//		ListNode lA = headA;
//		ListNode lB = headB;
//		
//		while(lA.next != null){
//			lengthA++;
//			lA = lA.next;
//		}
//		while(lB.next != null){
//			lengthB++;
//			lB = lB.next;
//		}
//		
//		for(int i=0;i<Math.abs(lengthA-lengthB);i++){
//			if(lengthA > lengthB) headA = headA.next;
//			if(lengthA < lengthB) headB = headB.next;
//		}
//		
//		while(headA != null && headB != null){
//			if(headA == headB) return headA;
//			headA = headA.next;
//			headB = headB.next;
//		}
//		return null;
//		
//	}
	
//	本题还有另一种思路：
//	维护两个指针pA和pB，初始分别指向A和B。然后让它们分别遍历整个链表，每步一个节点。
//	当pA到达链表末尾时，让它指向B的头节点（没错，是B）；类似的当pB到达链表末尾时，重新指向A的头节点。
//	如果pA在某一点与pB相遇，则pA或pB就是交点。
//	并且还设置两个节点，分别赋值 A链表和B链表的尾节点
//	如果两个尾节点不相等，则表明两个链表不会相交，返回null
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null) return null;
		
		ListNode pA = headA;
		ListNode pB = headB;
		ListNode tailA = null;
		ListNode tailB = null;
		
		while(true){
			if(pA == null) pA = headB;
			if(pB == null) pB = headA;
			if(pA.next == null) tailA = pA;
			if(pB.next == null) tailB = pB;
			if(tailA != null && tailB != null && tailA != tailB) return null;
			if(pA == pB) return pA;
			pA = pA.next;
			pB = pB.next;
		}
	 
	}

}
