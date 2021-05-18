package com.algo.recursion.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Given a mapping from digits to list of letters and a string of digits of
arbitrary length determine all possibble ways to replace digits with letters
i/p mapping={ '1' -> ['A','B','C']
		'2'->['D','E','F']
}
Avg length of map values - N
input string ="12" -K
expected o/p =["AD","AE","AF","BD","BE","BF","CD","CE","CF"]
O(k*N)
*/
public class AllPossibleStrings {;
public static Set<String> getAllPossibleStrings(Map<Character,List<Character>> map,String numberString){
	List<List<Character>> lists=new ArrayList<List<Character>>();
	char[] input=numberString.toCharArray();
	for(int i=0;i<input.length;i++){
		lists.add(map.get(input[i]));
	}
	Set<String> result=new HashSet<String>();
	getRecursiveResult(lists,0,result,"");
	return result;	
}
public static void getRecursiveResult(List<List<Character>> lists, int depth, Set<String> result, String str){
	if(depth==lists.size()) {
		result.add(str);
	return;
	}
	for(int i=0;i<lists.get(depth).size();i++){
		getRecursiveResult(lists, depth+1, result, str+lists.get(depth).get(i));
	}
	
}
public static void main(String[] args) {
	Map<Character,List<Character>> map=new HashMap<Character, List<Character>>();
	map.put('1',Arrays.asList('A','B','C'));
	map.put('2',Arrays.asList('D','E','F'));
	map.put('3',Arrays.asList('G','H','I'));
	map.put('4',Arrays.asList('J','K','L'));
	map.put('5',Arrays.asList('M','N','O'));
	map.put('6',Arrays.asList('P','Q','R'));
	map.put('7',Arrays.asList('S','T','U'));
	map.put('8',Arrays.asList('V','W','X'));
	map.put('9',Arrays.asList('Y','Z'));
	String s="a1b";
	//System.out.println(getAllPossibleCombinationsOfUpperAndLowerCase(s));
	Set<String> result = getAllPossibleStrings(map, "123");
	System.out.println(result+" size: "+result.size());
}
private static Set<String> getAllPossibleCombinationsOfUpperAndLowerCase(String s) {
	Set<String>resultList=new HashSet<String>();
	List<List<Character>> list=new ArrayList<List<Character>>();
	for(int i=0;i<s.length();i++){
		List<Character> list1=new ArrayList<Character>();
		list1.add(Character.toLowerCase(s.charAt(i)));
		list1.add(Character.toUpperCase(s.charAt(i)));
		list.add(list1);
	}
	getRecursiveResult(list, 0, resultList, "");
	return resultList;
}
}
