package top_interview;

import java.util.HashSet;

public class Find_the_Duplicate_Number {
	public static void main(String args[]){
		int nums[] = {1,1};
		Find_the_Duplicate_Number a = new Find_the_Duplicate_Number();
		System.out.println(a.findDuplicate(nums));
		
	}
	
//	�ο���������(����ĺ����)https://segmentfault.com/a/1190000003817671#articleHeader7
	
//	����1����ϣ��
//	ʱ��: O(N)  �ռ�:O(N), ��������ĿҪ��
//	public int findDuplicate(int[] nums){
//		HashSet<Integer> set = new HashSet();
//		if(nums == null || nums.length<=1) return -1;
//		int result=0;
//		for(int i=0;i<nums.length;i++){
//			if(set.contains(nums[i])){
//				result = nums[i];
//				break;
//			}
//			else set.add(nums[i]);
//		}
//		
//		return result;
//	}
	
	
//	����2��������
//	ʱ��:O(N^2)  �ռ�:O(1)
	
	
//	����3������
//	ʱ�� :O(NlogN)   �ռ�:O(1)
	
	
//	����4�����ַ�
//	ʱ��:O(NlogN)  �ռ�:O(1)
	
	
//	����5��ӳ���һ���
//	ʱ��:O(N)   �ռ䣺O(1)
//	����������û���ظ��������ǿ���������ôһ�㣬���ǽ�������±��1��nÿһ����һ��һ��ӳ��������
//	����������213,��ӳ���ϵΪ0->2, 1->1, 2->3��
//	�������һ��һӳ���ϵ��һ������f(n)������n���±꣬f(n)��ӳ�䵽������
//	������Ǵ��±�Ϊ0����������������������һ��ֵ�������ֵΪ�µ��±꣬��������������㣬�Դ����ƣ�ֱ���±곬�硣

//	ʵ���Ͽ��Բ���һ����������һ�������С�����������������������±�����У�0->2->3��
//	��������ظ��Ļ������м�ͻ�������һ��ӳ�䣬��������2131,��ӳ���ϵΪ0->2, {1��3}->1, 2->3��
//	�������������ݵ����о�һ�����л�·�ˣ������±��������0->2->3->1->1->1->1->...���������������ظ�������
//	���Ը���ʵ���Ͼ����һ�·�����⣬��Linked_List_Cycle_2һ����
//	�������ÿ��������±궼��0��ʼ�����±�ÿ��ӳ�����Σ����±�ÿ��ӳ��һ�Σ�ֱ�������±��ٴ���ͬ��
//	��ʱ�򱣳�slow�±�λ�ò��䣬�ٽ�fast�±��0��ʼ���������±궼����ÿ��ӳ��һ�Σ�
//	���������±�����ʱ�����ǻ�����㣬Ҳ�����ظ�������������һ�����㷨�����ģ���ο�Floyd's Algorithm��
	public int findDuplicate(int[] nums){
		if(nums == null || nums.length <= 1) return -1;
		int fast=0;
		int slow=0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		while(fast != slow);
		
		fast = 0;
		while(fast != slow){
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast;	
	}

}
