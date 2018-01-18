package top_interview;

public class Gas_Station {
	public static void main(String args[]){
		int[] gas = {4,5};
		int[] cost = {6,2};
		Gas_Station a = new Gas_Station();
		System.out.println(a.canCompleteCircuit(gas, cost));
	}
	
//	题目大意：
//	有N个加油站围成一个环形，其中第i个加油站的储油量为gas[i]。
//	你有一辆油箱无限大的汽车，从第i个加油站出发到第i+1个加油站的耗油量为cost[i]。
//	你从某一个加油站开始旅行，初始油箱为空。
//	如果从某一个加油站出发可以走完一圈，返回该加油站的下标，否则返回-1。
//	注意：可行解确保是唯一的。
	
//	本题最容易想到的方法就是用两层循环，但是会超时，如下。
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
	
	
//	仔细分析题目，可以得到两个隐含的结论：
//	结论1：若从加油站A出发，恰好无法到达加油站C（只能到达C的前一站）。则A与C之间的任何一个加油站B均无法到达C。
//	结论1证明: 反证法：假设从加油站A出发恰好无法到达加油站C，但是A与C之间存在加油站B，从B出发可以到达C。
//	                                     而又因为从A出发可以到达B，所以A到B的油量收益（储油量 - 耗油量）为正值，进而可以到达C。
//					     推出矛盾，假设不成立。
	
//	结论2：若储油量总和sum(gas) >= 耗油量总和sum(cost)，则问题一定有解。也可以使用发证法证明。 http://bookshadow.com/weblog/2015/08/06/leetcode-gas-station/
//	因此，本题可以使用一层循环解决
//	假设开始设置起点start = 0, 并从这里出发，
//	如果当前的gas值大于cost值，就可以继续前进，此时到下一个站点，剩余的gas加上当前的gas再减去cost，看是否大于0，若大于0，则继续前进。
//	当到达某一站点时，若这个值 sum 小于0了，则说明从起点到这个点中间的任何一个点作为起点，都无法到达下一站点C，
//	则把起点设为下一站点 C，继续遍历。
//	当遍历完整个环时，当前保存的起点即为所求。如果 total<0， 返回-1，否则返回保存的起点。
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
