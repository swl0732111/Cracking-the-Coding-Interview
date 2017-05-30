/*
题目描述
对于一个有正有负的整数数组，请找出总和最大的连续数列。
给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
*/

import java.util.*;

public class MaxSum {
    public int getMaxSum(int[] A, int n) {
        
        int maxSum = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += A[i];
            if(sum > 0) {
                maxSum = Math.max(maxSum, sum);
            } else {
                sum = 0;
            }
            
        }
        return maxSum;
    }
}