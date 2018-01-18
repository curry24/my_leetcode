package top_interview;

import java.util.Arrays;
import java.util.Scanner;

public class Count_Primes {
	
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Count_Primes a = new Count_Primes();
		System.out.println(a.countPrimes(n));
	}
	
//	����С�ڵ�ǰ�Ǹ����������������ĸ���
	
//	��򵥵ķ��������Ǹ��Ӷ�Ϊ O(n^2)
//	public int countPrimes(int n){
//		int count = 0;
//		for(int i=2;i<n;i++){
//			if(Primes(i))  count++;
//		}
//		return count;
//	}
//	public boolean Primes(int i){
//		for(int j=2;j<i;j++){
//			if(i%j == 0) return false;
//		}
//		return true;
//	}
	
	
	
//	������˹����ɸ�� Sieve of Eratosthenes, ��һ�ּ��������ķ���
//	https://baike.baidu.com/item/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
//	Ҫ�õ���Ȼ��n���ڵ�ȫ������������Ѳ����� ����n �����������ı����޳���ʣ�µľ���������
//	����Ҫɸ��ֵ�ķ�Χn���ҳ� n ���ڵ����� 
//	����2ȥɸ������2���£���2�ı����޳�����������һ��������Ҳ����3ɸ����3���£���3�ı����޳���������ȥ����һ������5ɸ����5���£���5�ı����޳����������ظ���ȥ......��
	public int countPrimes(int n){
		if(n<=2) return 0;
		boolean[] Primes = new boolean[n];
		Arrays.fill(Primes, true);
		for(int i=2;i<Math.sqrt(n);i++){
			if(Primes[i]){
				for(int j=i+i;j<n;j=j+i){
					Primes[j] = false;
				}
			}
		}
		int count = 0;
		for(int i=2;i<n;i++){
			if(Primes[i]) count++;
		}
		return count;
		
	}
}
