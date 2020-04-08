package CoreJavaConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String input = "cat dog tac sat tas god dog";
		  setOfAnagrams(input);
	}
	static void setOfAnagrams(String input){ 
		String[] tokens=input.split(" ");
		//Arrays.sort(tokens);
		Map<Integer, List<String>> result= new LinkedHashMap<>();
		for(String token : tokens) {
			int hash = calcHash(token);
			List<String> list=(result.get(hash) == null)? new ArrayList<>() : result.get(hash);
			list.add(token);
			result.put(hash, list);
		}
		//System.out.println(result);
		StringBuilder strB= new StringBuilder();
		result.keySet().stream()
		.forEach(k -> result.get(k).stream().forEach(s -> strB.append(s).append(" ")));
		System.out.println(strB);
	}
	static boolean anagrams(String str1,String str2) {
		if(str1.length() != str2.length()) return false;
		else {
			char[] char1= str1.toCharArray();
			char[] char2= str2.toCharArray();
			Arrays.sort(char1);
			Arrays.sort(char2);
			return char1.equals(char2);
		}
	}
	static int calcHash(String str) {
		int hash=0;
		char[] chars=str.toCharArray();
		for(char c: chars) {
			hash+=c;
		}
		return hash;
	}
}
