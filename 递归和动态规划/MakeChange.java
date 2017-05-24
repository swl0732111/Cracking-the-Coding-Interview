
/**
 * 题目描述：
 * 给定数量不限的硬币，币值为25分，10分，5分，1分。
 * 编写代码，计算100分有多少种表示法。
 * @author liu_wenbin
 *
 */

public class MakeChange {
	
	/**
	 * 法一：递归
	 */
	public static int makeChange(int n, int denom) {
		
		int nextDenom = 0;
		switch(denom) {
		case 25:
			nextDenom = 10;
			break;	
		case 10:
			nextDenom = 5;
			break;
		case 5:
			nextDenom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for(int i=0; i*denom<=n; i++) {//i表示当前使用多少面额为denom的现金
			ways += makeChange(n-i*denom, nextDenom);
		}
		return ways;
	}
	/**
	 * 法二：动态规划。时间复杂度只有O(n)
	 */
	private static int makeChange2(int n) {
		int[] dp = new int[n+1];
		int[] coins = {1, 5, 10, 25};
		dp[0] = 1;
		for(int i=0; i<4; i++) {
			for(int j=coins[i]; j<=n; j++) {
				dp[j] += dp[j-coins[i]];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeChange(100000, 25));
		//System.out.println(makeChange2(100000));

	}

}
