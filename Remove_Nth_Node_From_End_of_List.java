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
	
//  �����Ĺؼ��������Ѱ�ҵ�����n���ڵ㣬�������Ҫɾ��������n���ڵ�Ļ���Ӧ�ö�λ��������(n+1)���ڵ㣬�Ϳ��Խ���ɾ����
//  ����һ����m���ڵ㣬��ô�����ĵ�(m-n)���ڵ㣬��ʵ���ǵ�����(n+1)���ڵ㡣 
//	���Ҫ�������������õ�һ��������������n���ڵ㣬ʣ��(m-n)���ڵ㡣Ȼ��������������һ����ǰ�ߣ�ֱ����һ�������ߵ�ͷ�����ڶ�����������(m-n)���ڵ㡣
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
