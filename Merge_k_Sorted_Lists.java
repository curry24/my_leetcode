package top_interview;

public class Merge_k_Sorted_Lists {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String args[]){
		ListNode node2 = new ListNode(-1);
		ListNode node3 = new ListNode(5);
	    ListNode node4 = new ListNode(11);

	    ListNode node6 = new ListNode(6);
        ListNode node10 = new ListNode(10);
	        
	    node2.next = node3;
	    node3.next = node4;

	    node6.next = node10;
	    ListNode[] lists = new ListNode[4];
	    lists[0] = null;
	    lists[1] = node2;
	    lists[2] = null;
	    lists[3] = node6;
	    Merge_k_Sorted_Lists a = new Merge_k_Sorted_Lists();
	    ListNode result = a.mergeKLists(lists); 
	    while(result != null){
	    	System.out.println(result.val);
	    	result = result.next;
	    }
	}
	
	public ListNode mergeKLists(ListNode[] lists){
		
		return dividelists(lists, 0, lists.length-1);
	}
	//ÿ���������������merge���������ظ��Ĳ��ҺͱȽϡ������ڹ鲢����Ҳ���Ƿ��η���
	public ListNode dividelists(ListNode[] lists, int start, int end){
		if(start == end) return lists[start];
		if(start<end){
			int tmp = (start+end)/2;
			ListNode l1 = dividelists(lists, start, tmp);
			ListNode l2 = dividelists(lists, tmp+1, end);
			return merge(l1, l2);
		}else{
			return null;
		}
		
	}
	// merge two sorted lists �Ĵ��룬���õݹ�ʵ��
	public ListNode merge(ListNode l1, ListNode l2){
		if(l1 == null){return l2;}
		else if(l2 == null){return l1;}
		// ÿ���ҵ����������е���Сֵ����ǰ��Сֵ.next = ��һ�αȽ��е���Сֵ
		if(l1.val <= l2.val){
			l1.next = merge(l1.next, l2);
			return l1;
		}else{
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	
}
