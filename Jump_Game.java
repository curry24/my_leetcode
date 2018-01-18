package top_interview;

public class Jump_Game {
	public static void main(String args[]){
		int[] nums = {3,2,1,0,4};
		Jump_Game a = new Jump_Game();
		System.out.println(a.canJump(nums));
	}
	
//  ���ȿ�����  dp ��������һ��  һά  dp ����
//	public boolean canJump(int[] nums){
//		if(nums == null || nums.length == 0) return false;
//		int[] dp = new int[nums.length];
////		dp[i] ��ʾ���Ǵ� 0 �ߵ� i ʱ��ʣ������Ĳ���
////      dp[i] = 0  (i=0)
////		dp[i] = Max( dp[i-1], nums[i-1]) - 1  (i>0)
////		���  dp[i] < 0, ���޷��ߵ���ǰλ��
////		(�о��� dp ��������̫�����)
//		dp[0] = 0;
//		for(int i=1;i<nums.length;i++){
//			dp[i] = Math.max(dp[i-1], nums[i-1]) - 1;
//			if(dp[i] < 0)  return false;
//		}
//		return dp[nums.length-1] >= 0;
//	}
	
	
//	����ʹ��̰�ĵķ�������
//	��ʵҲ�� dp ��˼��
//	����һ�� MaxIndex ֵ��������ʾ��ǰ���ܵ��������������λ��
//	Ȼ����������е�ֵ�����Ҳ��ϸ��� MaxIndex ��ֵ
//	MaxIndex = Max( MaxIndex, i+nums[i])
//	�����ڱ����Ĺ����������жϣ� �����ǰλ�� i �����������λ�� MaxIndex����˵����������iλ�ã������ᵽ�����һ��λ�ã���break
//	����������� nums.length-1 > i > MaxIndex , ���Է��� false
//	���У���� MaxIndex >= nums.length-1, ��˵���϶����Ե������һ��λ�ã���break, �ҷ���true
	public boolean canJump(int[] nums){
		if(nums == null || nums.length == 0) return false;
		int MaxIndex = 0;
		for(int i=0;i<nums.length;i++){
			if(i > MaxIndex || MaxIndex >= nums.length-1) break;
			MaxIndex = Math.max(MaxIndex, i+nums[i]);
		}
		return MaxIndex >= nums.length-1;
	}

}
