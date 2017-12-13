package top_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generate_Parentheses {
	public static void main(String []args){
		Scanner cin = new Scanner (System.in);
		int n = cin.nextInt();
		Generate_Parentheses a = new Generate_Parentheses();
		List<String> out = new ArrayList();
		out = a.generateParenthesis(n);
		System.out.print(out);
		}
		
	
	public List<String> generateParenthesis(int n) {
	       int left = n;
	       int right = n;
	       List <String> result = new ArrayList();
	       String temp = "";
	       dfs(left, right, temp, result);
	       
	       return result;
	       
	    }
	
	public void dfs(int left, int right, String temp, List<String> result){
		if (left == 0 && right == 0) {
			result.add(temp);
		}
		
		if(left >0) dfs(left-1,right,temp+"(",result);
		
		if(right>0 && right>left) dfs(left, right-1, temp+")",result); 
		
	}

}
