package com.sxl.leecode;


public class LongestPalindromicSubString {

	/**
	 * 采用Manacher‘s Algorithm算法计算最长回文子串
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
        	return "";
        }else if(s.length() < 2){
        	return s;
        }else{
        	char [] t = processString(s);
        	int center = 0;
        	int right = 0;
        	int [] p = new int[t.length];
        	for(int i = 1; i < t.length - 1; i++){
        		if(right > i){
        			p[i] = Math.min(right - i, p[2 * center - i]);
        		}
        		while(t[i - p[i] - 1] == t[i + p[i] + 1])
        			p[i]++;
        		if(i + p[i] > right){
        			right = i + p[i];
        			center = i;
        		}
        	}
        	int radix = 0;
        	int c = 0;
        	for(int i = 0; i < p.length; i++){
        		if(p[i] > radix){
        			radix = p[i];
        			c = i;
        		}
        	}
        	return s.substring((c - radix -1) / 2, (c -1 + radix) / 2);
        }
    }
	private char [] processString(String s){
		char [] chars = new char [s.length() * 2 + 3];
		chars[0] = '$';
		chars[s.length() * 2 + 2] = '@';
		chars[s.length() * 2 + 1] = '#';
		for(int i = 0; i < s.length(); i++){
			chars[2 * i + 2] = s.charAt(i);
			chars[i * 2 + 1] = '#';
		}
		return chars;
	}
	public static void main(String [] args){
		System.out.println(new LongestPalindromicSubString().longestPalindrome("abadd"));
	}
}
