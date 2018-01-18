package top_interview;

public class Rotate_Array {
	public static void main(String args[]){
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		Rotate_Array a = new Rotate_Array();
		a.rotate(nums, k);
		for(int i=0;i<7;i++){
			System.out.print(nums[i]+" ");
		}
	}
	
//	Rotate an array of n elements to the right by k steps.
//	��ת��������, ��ʵ���ǽ����������ƶ� k��
//	�������ַ���

	
//	�˷���ʹ���˶�������� (˫���鷨)
//	�ռ临�Ӷ� O(N), ʱ�临�Ӷ�ΪO(N)
//	public void rotate(int[] nums, int k){
//		int n = nums.length;
//		int[] rotated = new int [n];
//		for(int i=0;i<n;i++){
//			rotated[(i+k)%n] = nums[i];
//		}
//		for(int i=0;i<n;i++){
//			nums[i] = rotated[i];
//		}
//	}

	
//	��ת��
//	ͨ�����η�ת�����ǿ��Ժ������ʵ����ת���飬�������������ƶ� k��
//	�������ǽ��������鷴ת��Ȼ��ǰk�����ַ�ת������ٽ�����ʣ�µ����ַ�ת���͵õ�Ŀ�������ˡ�
//	�ռ临�Ӷ�ΪO(1), ʱ�临�Ӷ�ΪO(N)
	public void rotate(int[] nums, int k){
		int n = nums.length;
//		k���ܴ������鳤�ȣ���ת��ֹһ�Σ���������Ҫ�ȶ�kȡ��
		k = k%n;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
		
	}
	
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
}
