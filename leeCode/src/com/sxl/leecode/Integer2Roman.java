package com.sxl.leecode;

public class Integer2Roman {

	public static String intToRoman(int num) {
        char [] romans = {'I','X','C','M'};//1,5,10,50,100,500,100
        char [] halfRomans = {'V','L','D'};//1,5,10,50,100,500,100
        int [] values = {1,10,100,1000};
        int [] halves = {5,50,500};
        int k = 0;
        int temp = num;
        StringBuilder sb = new StringBuilder();
        while(temp / values[3] > 0) {
    		sb.append(romans[3]);
    		temp = temp - values[3];
    	}
        for(int i = values.length - 2; i >= 0 ; i--) {
        	int mul = temp / values[i];
        	if(mul == 5) {
        		sb.append(halfRomans[i]);
        		temp = temp - halves[i];
        	}else if(mul== 4) {
        		sb.append(romans[i]).append(halfRomans[i]);
        		temp = temp - 4 * values[i];
        	}else if(mul > 5 && mul < 9) {
        		sb.append(halfRomans[i]);
        		temp = temp - halves[i];
        		while(temp / values[i] > 0) {
        			sb.append(romans[i]);
        			temp = temp - values[i];
        		}
        	}else if(mul > 0 && mul < 4){
        		while(temp / values[i] > 0) {
        			sb.append(romans[i]);
        			temp = temp - values[i];
        		}
        	}else if(mul == 9) {
        		sb.append(romans[i]).append(romans[i + 1]);
        		temp = temp - 9 * values[i];
        	}
        }
        return sb.toString();
    }
	/*
	 * 高效实现
	 */
	public static String intToRoman2(int num) {
        String [][] romans = {
        		{"","M","MM","MMM","","","","","",""},
        		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        		{"","I","II","III","IV","V","VI","VII","VIII","IX"}
        };
        StringBuilder sb = new StringBuilder();
        sb.append(romans[0][num / 1000 % 10]).append(romans[1][num / 100 % 10]).append(romans[2][num / 10 % 10]).append(romans[3][num % 10]);
        return sb.toString();
    }
	
	public static void main(String [] args) {
		System.out.println(intToRoman2(3999));
	}
}
