package com.sxl.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongetsSubString {

	public static int lengthOfLongestSubstring(String s) {
		if(s == null || "".equals(s)){
			return 0;
		}else if(s.length() == 1){
			return 1;
		}else{
			int startPost = 0;
			int pos = 1;
			Map<Integer,Integer> map1 = null;
			int maxLen = 1;
			while(pos < s.length()){
				map1 = new HashMap<>();
				int startValue = s.codePointAt(startPost);
				int len = 1;
				map1.put(startValue, 1);
				int value = s.codePointAt(pos);
				while((map1.get(value) == null || map1.get(value) <= 0)){
					map1.put(value, 1);
					pos++;
					if(pos >= s.length())
						break;
					value = s.codePointAt(pos);
				}
				
				len = pos -startPost;
				if(len > maxLen)
					maxLen = len;
				if(map1.get(value) != null && map1.get(value) > 0){
					int index = s.indexOf(value, startPost);
					startPost = index + 1;
				}else{
					startPost = pos;
				}
				pos = startPost + 1;
			}
			
			return maxLen;
		}
    }
	public static void main(String [] args){
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
}
