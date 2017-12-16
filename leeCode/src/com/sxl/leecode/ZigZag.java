package com.sxl.leecode;

public class ZigZag {

	/**
	 * 击败98.77%的提交者
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
        if(s == null || "".equals(s) || numRows < 2 || numRows >= s.length()){
        	return s;
        }else{
        	char [] t = new char[s.length()];
        	int j = 0;
        	int p = 0,add = 2 * numRows - 2;
        	while(p < s.length()){
        		t[j++] = s.charAt(p);
        		p = p + add;
        	}
        	int i = 1;
        	for(i = 1; i < numRows - 1; i++){
        		int m = numRows - (i + 1) ,n = i,pos = i;
        		int add1 = 2 * m,add2 = 2 * n;
        		t[j++] = s.charAt(i);
        		while(pos < s.length()){
        			pos += add1;
        			if(pos < s.length()){
        				t[j++] = s.charAt(pos);
        			}
        			if(add2 > 0){
        				pos += add2;
            			if(pos < s.length())
            				t[j++] = s.charAt(pos);
        			}
        			
        		}
        	}
        	p = i;
        	while(p < s.length()){
        		t[j++] = s.charAt(p);
        		p = p + add;
        	}
        	
        	return new String(t);
        }
    }
	public static void main(String [] args){
		System.out.println(convert("ABC", 2));
	}
}
