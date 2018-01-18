package top_interview;

public class Gas_Station {
	public static void main(String args[]){
		int[] gas = {4,5};
		int[] cost = {6,2};
		Gas_Station a = new Gas_Station();
		System.out.println(a.canCompleteCircuit(gas, cost));
	}
	
//	��Ŀ���⣺
//	��N������վΧ��һ�����Σ����е�i������վ�Ĵ�����Ϊgas[i]��
//	����һ���������޴���������ӵ�i������վ��������i+1������վ�ĺ�����Ϊcost[i]��
//	���ĳһ������վ��ʼ���У���ʼ����Ϊ�ա�
//	�����ĳһ������վ������������һȦ�����ظü���վ���±꣬���򷵻�-1��
//	ע�⣺���н�ȷ����Ψһ�ġ�
	
//	�����������뵽�ķ�������������ѭ�������ǻᳬʱ�����¡�
//	public int canCompleteCircuit(int[] gas, int[] cost){
//		if(gas.length == 0) return -1;
//		for(int index=0;index<gas.length;index++){
//			int current = 0;
//			int current_cost = 0;
//			int temp = 0;
//			for(int j=index;;j++){
//				current = current+gas[j%gas.length];
//				current_cost = current_cost+cost[j%gas.length];
//				if(current<current_cost) break;
//				if(j%gas.length == index) temp++;
//				if(temp == 2) return index;
//			}
//			
//		}
//		return -1;
//	}
	
	
//	��ϸ������Ŀ�����Եõ����������Ľ��ۣ�
//	����1�����Ӽ���վA������ǡ���޷��������վC��ֻ�ܵ���C��ǰһվ������A��C֮����κ�һ������վB���޷�����C��
//	����1֤��: ��֤��������Ӽ���վA����ǡ���޷��������վC������A��C֮����ڼ���վB����B�������Ե���C��
//	                                     ������Ϊ��A�������Ե���B������A��B���������棨������ - ��������Ϊ��ֵ���������Ե���C��
//					     �Ƴ�ì�ܣ����費������
	
//	����2�����������ܺ�sum(gas) >= �������ܺ�sum(cost)��������һ���н⡣Ҳ����ʹ�÷�֤��֤���� http://bookshadow.com/weblog/2015/08/06/leetcode-gas-station/
//	��ˣ��������ʹ��һ��ѭ�����
//	���迪ʼ�������start = 0, �������������
//	�����ǰ��gasֵ����costֵ���Ϳ��Լ���ǰ������ʱ����һ��վ�㣬ʣ���gas���ϵ�ǰ��gas�ټ�ȥcost�����Ƿ����0��������0�������ǰ����
//	������ĳһվ��ʱ�������ֵ sum С��0�ˣ���˵������㵽������м���κ�һ������Ϊ��㣬���޷�������һվ��C��
//	��������Ϊ��һվ�� C������������
//	��������������ʱ����ǰ�������㼴Ϊ������� total<0�� ����-1�����򷵻ر������㡣
	public int canCompleteCircuit(int[] gas, int[] cost){
		if(gas.length == 0) return -1;
		int total = 0;
		int sum = 0;
		int start = 0;
		for(int i=0;i<gas.length;i++){
			total = total + (gas[i]-cost[i]);
			sum = sum + (gas[i]-cost[i]);
			if(sum < 0){
				start = i+1;
				sum = 0;
			}
		}
		if(total < 0) return -1;
		else return start;
	}
}
