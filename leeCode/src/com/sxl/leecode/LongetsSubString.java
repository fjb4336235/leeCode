package com.sxl.leecode;


public class LongetsSubString {

	public static int lengthOfLongestSubstring(String s) {
		if(s == null || "".equals(s)){
			return 0;
		}else if(s.length() == 1){
			return 1;
		}else{
			int startPost = 0;
			int pos = 1;
			boolean [] has = new boolean[127];
			int maxLen = 1;
			while(pos < s.length()){
				int startValue = s.codePointAt(startPost);
				has[startValue] = true;
				int len = 1;
				int value = s.codePointAt(pos);
				if(!has[value]){
					has[value] = true;
					pos++;
				}else{
					while(startValue != value){
						has[startValue] = false;
						startPost++;
						startValue = s.codePointAt(startPost);
					}
					startPost++;
					pos++;
				}
				
				len = pos -startPost;
				if(len > maxLen)
					maxLen = len;
			}
			
			return maxLen;
		}
    }
	public static void main(String [] args){
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
