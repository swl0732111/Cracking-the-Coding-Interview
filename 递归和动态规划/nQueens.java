/*
著名的八皇后问题
*/
import java.util.*;

public class Queens {
	
	public static int nQueens(int n) {
		int[] cols = new int[n];
		int[] count = {0};
		for(int i=0; i<n; i++) {
			cols[0] = i;//第一行皇后的位置
			getCount(cols, 1, count);//从第二行开始放
		}
		return count[0];
	}
	
	private static void getCount(int[] cols, int row, int[] count) {
		if(row == cols.length) {//放到最后一行了
			count[0]++;
			return;
		}
		for(int i=0; i<cols.length; i++) {
			if(checked(cols, row, i)) {
				cols[row] = i;
				getCount(cols, row+1, count);
			}
		}
	}
	
	private static boolean checked(int[] cols, int row, int col) {
		for(int i=0; i<row; i++) {
			if(cols[i] == col //该列已经有元素了。
			|| Math.abs(row-i) == Math.abs(cols[i]-col)//两列的距离等于两行的距离。
			//不需要考虑这一行有没有重复元素，因为这一行刚开始摆棋子
			) 
			return false;
		}
		return true;
	}
}