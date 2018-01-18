package top_interview;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
	public static void main(String args[]){
		int n = 15;
		List<String> result = new ArrayList<String>();
		Fizz_Buzz a = new Fizz_Buzz();
		result = a.fizzBuzz(n);
		System.out.println(result);
	}
	
//	Write a program that outputs the string representation of numbers from 1 to n.
//	But for multiples of three it should output ¡°Fizz¡± instead of the number and for the multiples of five output ¡°Buzz¡±. 
//	For numbers which are multiples of both three and five output ¡°FizzBuzz¡±.
	
	 public List<String> fizzBuzz(int n) {
	        List<String> result = new ArrayList<String>();
	        if(n<=0) return result;
	        for(int i=1;i<=n;i++){
	            if(Multiples_three(i) && !Multiples_five(i)) result.add("Fizz");
	            else if(!Multiples_three(i) && Multiples_five(i)) result.add("Buzz");
	            else if(Multiples_three(i) && Multiples_five(i)) result.add("FizzBuzz");
	            else result.add(Integer.toString(i));
	        }
	        return result;
	    }
	 public boolean Multiples_three(int n){
	        if(n % 3 == 0) return true;
	        else return false;
	    } 
	 public boolean Multiples_five(int n){
	        if(n % 5 == 0) return true;
	        else return false;
	    }
	

}
