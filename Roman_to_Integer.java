package top_interview;

import java.util.HashMap;

public class Roman_to_Integer {
	
	public static void main(String[] args) throws Exception {
        System.out.println(new Roman_to_Integer().romanToInt("DCXXI"));
    }

//	如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字
//	其他情况则减去这个数字
	public int romanToInt(String s){
		HashMap<Character, Integer> map = new HashMap();
		map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        for(int i=0;i<s.length();i++){
        	if(i==s.length()-1) {
        		num = num + map.get(s.charAt(i));
        		break;
        	}
        	if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) num = num + map.get(s.charAt(i));
        	else num = num - map.get(s.charAt(i));
        }
        return num;
       
	}

}
