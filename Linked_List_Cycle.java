package top_interview;

public class Linked_List_Cycle {
	
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
		Linked_List_Cycle a = new Linked_List_Cycle();
		if(a.hasCycle(node)) System.out.println("yes");
		else System.out.println("no");

	}
	
//	����һ���ǳ������˫ָ���⡣ʱ��:O(N)  �ռ�:O(1)
//	���Ǵ�ͷ����һ����ָ�룬һ����ָ�롣
//	��ָ��һ������������ָ��һ����һ���������ָ���ߵ��˾�ͷ����˵�������޻���
//	�����ָ�����ָ����������˵�������л���
//	Ϊʲô������˵���л��أ�����һ���л���������ָ����󶼻��ߵ����ϣ�
//	�����������һ�������ܵ�һ������ָ���ں��棬��ָ����ǰ�棬
//	��ʵ���Ͽ�ָ��Ҳ��׷��ָ�룬ϣ���ܳ���ָ��һȦ��
//	����������ܵ��ϣ��ܻ���һ���ָ��׷������ָ�롣
//	���ǲ��õ��Ŀ�ָ����������ָ�룬��Ϊ���������ٶȲ���1��
//	�����������ڻ��ϵľ�������ÿ�μ�1��������ܼ���0��
	public boolean hasCycle(ListNode head){
		if(head == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) return true;
		}
		return false;		
	}
}
