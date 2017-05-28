/*
题目描述
有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位.
例如，原数组为[1,2,3,4,5,6]，向左移位5个位置即变成了[6,1,2,3,4,5],
现在对于移位后的数组，需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。
*/

import java.util.*;

public class FindElement {
    public int findElement(int[] A, int n, int x) {
        // write code here
        int lo = 0, hi = n-1;
        /* 对于不同的情况，需要画图判断 */
        while(lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
            if(A[mid] == x) {
                return mid;
            } else if(A[mid] < x) {
                if(A[mid]<A[lo] && x>A[hi]) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else {
                if(A[mid]>A[lo] && x<A[lo]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}