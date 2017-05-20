/*
题目描述
对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
*/

public class MinimalBST {
	
	public int buildMinimalBST(int[] vals) {
		
		if(vals == null || vals.length == 0) {
			return 0;
		}
		return build(vals, 0, vals.length-1);
	}
	
	private int build(int[] vals, int lo, int hi) {
		
		if(hi <= lo) return 1;
		
		int mid = lo + (hi - lo) / 2;
		
		int h1 = 1 + build(vals, lo, mid-1);
        
        int h2 = 1 + build(vals, mid+1, hi);
        
        return Math.max(h1, h2);
	}
}

