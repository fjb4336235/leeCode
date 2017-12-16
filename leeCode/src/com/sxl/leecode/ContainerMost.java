package com.sxl.leecode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
 * @author fengjianbang
 *
 */
public class ContainerMost {

	/**
	 * 题目可以理解为求i,j(i >= 0 ,j <= height.length - 1,i < j),使得表达式(j -i) * min(height[i],height[j])的最大值，
	 * 对于所有的i,j - i <= height.lenght - 1,因此，一定有：min(height[i],height[j]) >= min(height[0],height[height.lenght - 1]).
	 * 假设min(height[0],height[height.lenght - 1]) = h,那么min(height[i],height[j]) > h，可以推出条件1： height[i] > h,height[j] > h。
	 * 对于所有不满:1的i,j，可以直接跳过
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
        int i = 0,j = height.length - 1,max = 0;
        while( i < j){
        	int h = Math.min(height[i], height[j]);
        	int m = (j - i) * h;
        	max = max > m ? max : m;
        	while(height[i] <= h && i < j) i++;
        	while(height[j] <= h && i < j) j--;
        }
        return max;
    }
	
}
