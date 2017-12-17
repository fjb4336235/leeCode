package com.sxl.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
        	
        	if(i == 0 || i > 0 && nums[i] != nums[i - 1]) {
        		int target = -1 * nums[i];
            	int head = i + 1,tail = nums.length - 1;
            	while(head < tail) {
            		if(nums[head] + nums[tail] == target) {
            			List<Integer> list = new ArrayList<>();
                    	list.add(nums[i]);
                    	list.add(nums[head]);
                    	list.add(nums[tail]);
                    	answer.add(list);
            			int k = head + 1;
                    	while(k < tail && nums[k] == nums[head])
                    		k++;
                    	head = k;
                    	k = tail - 1;
                    	while(k > head && nums[k] == nums[tail])
                    		k--;
                    	tail = k;
                    	
            		}else if(nums[head] + nums[tail] < target)
            			head++;
            		else
            			tail--;
            	}
        	}
        }
        return answer;
    }
//	private static int [] process(int []nums) {
//		int j = nums.length - 1;
//		int i = 0;
//		while(i < nums.length) {
//			if(nums[i] >= 0 && i < j) {
//				nums[i] = nums[i] ^ nums[j];
//				nums[j] = nums[i] ^ nums[j];
//				nums[i] = nums[i] ^ nums[j];
//				j--;
//			}else {
//				i++;
//			}
//		}
//		
//		i = 0;
//		boolean haveZero = false;
//		while(i < nums.length) {
//			if(nums[i] > 0) {
//				break;
//			}else if(nums[i] == 0) {
//				i++;
//				haveZero = true;
//			}else {
//				i++;
//			}
//		}
//		int pos = i;
//		System.out.println("sdf"+nums[pos]);
//		if(pos > 0) {
//			Arrays.sort(nums, 0, pos - 1);
//		}
//		Arrays.sort(nums, pos, nums.length - 1);
//		return nums;
//	}
	public static void main(String [] args) {
		threeSum(new int []{-1,0,1,2,-1,-4});
	}
}
