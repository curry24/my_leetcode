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
	
//	计算小于当前非负整数的所有质数的个数
	
//	最简单的方法，但是复杂度为 O(n^2)
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
	
	
	
//	埃拉托斯特尼筛法 Sieve of Eratosthenes, 是一种简单找素数的方法
//	https://baike.baidu.com/item/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
//	要得到自然数n以内的全部素数，必须把不大于 根号n 的所有素数的倍数剔除，剩下的就是素数。
//	给出要筛数值的范围n，找出 n 以内的素数 
//	先用2去筛，即把2留下，把2的倍数剔除掉；再用下一个素数，也就是3筛，把3留下，把3的倍数剔除掉；接下去用下一个素数5筛，把5留下，把5的倍数剔除掉；不断重复下去......。
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
