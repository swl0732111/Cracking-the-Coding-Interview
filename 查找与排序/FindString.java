/*
题目描述
有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。
算法的查找部分的复杂度应该为log级别。
给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
*/

import java.util.*;

public class FindString{
    public int findString(String[] str, int n, String x) {
        int lo = 0, hi = n-1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			/* 先处理空字符串：*/
			if(str[mid].isEmpty()) {
				int index = mid;
				while(index>=lo && str[index].isEmpty()) index--;
				if(index<lo) {
					lo = mid+1;
				} else if(str[index].equals(x)) {
					return index;//命中
				} else if(str[index].compareTo(x)>0) {
					hi = index-1;
				} else {
					lo = mid + 1;
				}				
			} 
			/* 再处理非空字符串，这时与传统二分搜索步骤相同：*/
			else {
				if(str[mid].equals(x)) {
					return mid;
				} else if(str[mid].compareTo(x)>0) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}
		
		return -1;//未找到
    }
}