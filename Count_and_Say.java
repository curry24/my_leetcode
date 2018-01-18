package top_interview;


import java.util.Scanner;

public class Count_and_Say {
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Count_and_Say a = new Count_and_Say();
		System.out.println(a.countAndSay(n));
	}
	
	
//	题目说的不是很清楚
//	使用递归可以进行解决
	public String countAndSay(int n){
		if(n == 1) return "1";
		String m = countAndSay(n-1) + "*";
//		在字符串末尾加一个 * ，保证可以遍历到字符串的最后一个字符
		return count(m);
	}
	
	public String count(String m){
		char[] shuzu = m.toCharArray();
		String s = "";
		for(int i=0;i<m.length()-1;i++){
			int num = 1;
			while(shuzu[i] == shuzu[i+1]){
				num++;
				i++;
			}
			s = s + num + shuzu[i];	
//			这里使用了String中的，使用加号 "+" 来拼接字符串
//			这里引出一个知识点， Java中字符串的拼接，详解在下面。
		}
		return s;
	}
	
	
//	Java 中字符串拼接的三种方法：
//	1.加号；     2.concat方法；	  3.StringBuilder(或 StringBuffer)的 append 方法
	
//	1.  "+" 加号方法中，实际上是使用 StringBuilder 的 append 方法来实现，并最终通过 toString 方法来转换成 String 字符串。
//		str = new StringBuilder(str).append("haha").toString();
//		它与纯粹地使用StringBuilder的append方法是不同的： 
//		① 每趟循环都会创建一个StringBuilder对象 
//		② 每次执行完毕都会调用toString方法将其转换为字符串 
//		所以，就耗费了更多的时间。(最慢)
	
//	2.  concat 方法 ： 	String str = "haha";  str.concat("hehe"); 
//		整体是一个数组的拷贝，虽然在内存中是处理都是原子性操作，速度非常快，
//		但是，最后的return语句创建一个新String对象，也就是每次concat操作都会创建一个新的String对象，
//		这也是限制concat方法速度的原因。 (稍慢)
	
//	3.	append 方法 
//		StringBuilder stringBuilder = new StringBuilder("haha");
//		stringBuilder.append("hehe");	
//		String str = stringBuilder.toString();
//		整个append方法都在做字符数组的处理，加长，拷贝等，
//		这些都是基本的数据处理，整个方法内并没有生成对象
//		最后 toString() 返回一个 String 对象 (最快)
}
