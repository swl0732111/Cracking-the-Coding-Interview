/*
题目描述
有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
*/

import java.util.*;

public class GoUpstairs {
    public int countWays(int n) {
        int[] map = new int[100000];
        map[0] = 1;
        map[1] = 2;
        map[2] = 4;
        
        for(int i=3; i<n; i++) {
            map[i] = ((map[i-1] + map[i-2])%1000000007 + map[i-3])%1000000007;
        }
        return map[n-1];
    }
}