package com.sxl.leecode;

public class LongestPalindromicSubString {

	public static String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
        	return "";
        }else if(s.length() < 2){
        	return s;
        }else{
        	int [][] pos = new int[127][2];
        	int p = 0;
        	while(p < s.length()){
        		char c = s.charAt(p);
        		if(pos[c][0] == 0){
        			pos[c][0] = p + 1;
        		}else{
        			pos[c][1] = p + 1;
        		}
        		p++;
        	}
        	int maxLen = 0;
        	int maxPos = 0;
        	for(int i = 0; i < 127; i++){
        		int len = pos[i][1] - pos[i][0];
        		if(len > maxLen){
        			maxLen = len;
        			maxPos = i;
        		}
        	}
        	return s.substring(pos[maxPos][0] - 1, pos[maxPos][1]);
        }
    }
	public static void main(String [] args){
		System.out.println(longestPalindrome("abadd"));
	}
}
