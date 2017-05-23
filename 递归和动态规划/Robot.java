/*
题目描述
有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
*/

import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
        int count = 0;
        int[][] map = new int[x][y];
        map[0][0] = 1;
        for(int i=1; i<x; i++) {
            map[i][0] = 1;
        }
        for(int j = 1; j<y; j++) {
            map[0][j] = 1;
        }
        for(int i=1; i<x; i++) {
            for(int j=1; j<y; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[x-1][y-1];
    }
	//法二：因为x+y<=12， 所以并不用担心超时
	int countWays(int x, int y) {
		if(x<=0||y<=0) return 0;
		if(x==1||y==1) return 1;
		return countWays(x-1,y)+countWays(x,y-1);
    }
}