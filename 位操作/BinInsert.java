/*
题目描述
有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位数到高位且以0开始。
给定两个数int n和int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为零，且m的二进制位数小于等于i-j+1。
*/
import java.util.*;

public class BinInsert {
	
    public int binInsert(int n, int m, int j, int i) {
		
        return n | (m<<j);
		
    }
}

/* 进阶：假如不保证n的第j到第i位均为零，其他条件不变 */
class BinInsert2 {
	
    public int binInsert(int n, int m, int j, int i) {
		
        int allOnes = ~0;//等同于一连串的1
		
		int left = allOnes << (j+1);
		
		int right = ((1<<i) - 1);
		
		int mask = left | right; //掩码
		
		n = n & mask;//清除n的i到j位
		
		m = m << i;
		
		return n | m;
    }
}