package com.recursion.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
1 
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211
 * @author vdatla
 *
 */
public class LookAndSay {
	public static void main(String[] args) {
	    List<String> res=new ArrayList<String>();
	    lookAndSay(10,res,"1");
	    for(String s:res)
	    System.out.println(s);
	  }
	  public static void lookAndSay(int n,List<String> res,String s){
	    if(n==0) return;
	    res.add(s);
	    StringBuilder sb=new StringBuilder();
	    char prev=0;
	    if(s!=null && s.length()!=0) prev=s.charAt(0);
	    int count=0;
	    for(char c:s.toCharArray()){
	      if(c==prev) count++;
	      else{
	        sb.append(count);
	        sb.append(prev);
	        prev=c;
	        count=1;
	      }
	    }
	    if(prev==s.charAt(s.length()-1)){
	      sb.append(count);
	        sb.append(prev);
	    }
	    lookAndSay(n-1,res,sb.toString());
	  }
}
