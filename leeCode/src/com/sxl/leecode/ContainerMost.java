package com.sxl.leecode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
 * @author fengjianbang
 *
 */
public class ContainerMost {

	/**
	 * ��Ŀ�������Ϊ��i,j(i >= 0 ,j <= height.length - 1,i < j),ʹ�ñ��ʽ(j -i) * min(height[i],height[j])�����ֵ��
	 * �������е�i,j - i <= height.lenght - 1,��ˣ�һ���У�min(height[i],height[j]) >= min(height[0],height[height.lenght - 1]).
	 * ����min(height[0],height[height.lenght - 1]) = h,��ômin(height[i],height[j]) > h�������Ƴ�����1�� height[i] > h,height[j] > h��
	 * �������в���:1��i,j������ֱ������
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
