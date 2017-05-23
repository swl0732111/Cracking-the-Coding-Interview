/*
题目描述
在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同.
编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
*/

import java.util.*;

public class MagicIndex {
    public boolean findMagicIndex(int[] A, int n) {
        return help(A, 0, n);
    }
    
    private boolean help(int[] A, int lo, int hi) {
        if(lo >= hi) {
            return false;
        }
        int mid = lo + (hi - lo) / 2;
        
        if(A[mid] == mid) {
            return true;
        } else if(A[mid] < mid) {
            return help(A, mid, hi);
        } else {
            return help(A, lo, mid);
        }
    }
}