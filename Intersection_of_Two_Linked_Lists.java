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
	
//	����Ҫ������������Ľ��������
//	������������ཻ���򷵻ؽ��㣬���򣬷���null

//	�������ȵ�˼·�ǣ�
//	�ֱ������������ĳ��ȣ��ó����Ȳ�
//	Ȼ���ó�����������ǰ�� ���Ȳ� ���ڵ�
//	֮��������������һ����ǰ�ߣ�����ڵ���ͬ�����ཻ�����ؽ��㣬���򷵻�null
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
	
//	���⻹����һ��˼·��
//	ά������ָ��pA��pB����ʼ�ֱ�ָ��A��B��Ȼ�������Ƿֱ������������ÿ��һ���ڵ㡣
//	��pA��������ĩβʱ������ָ��B��ͷ�ڵ㣨û����B�������Ƶĵ�pB��������ĩβʱ������ָ��A��ͷ�ڵ㡣
//	���pA��ĳһ����pB��������pA��pB���ǽ��㡣
//	���һ����������ڵ㣬�ֱ�ֵ A�����B�����β�ڵ�
//	�������β�ڵ㲻��ȣ�����������������ཻ������null
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
