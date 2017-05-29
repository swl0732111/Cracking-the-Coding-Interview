/*
题目描述
现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，即在当前数组中小于等于它的数的个数(不包括它自身)，
请设计一个高效的数据结构和算法来实现这个功能。
给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。
*/
import java.util.*;

public class RankOfNumber {
	/* 法一：暴力解法，时间复杂度O(N^2)，不推荐*/
    public int[] getRankOfNumber(int[] A, int n) {
        int[] res = new int[n];
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(A[j] < A[i]) {
                    res[i]++;
                }
            }
        }
        
        return res;
    }
	
	
	
	
}