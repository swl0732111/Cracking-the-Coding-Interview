/*
题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/

public class FindPath {
	
	/* 回溯法：
	回溯算法也叫试探法，它是一种系统地搜索问题的解的方法。
	用回溯算法解决问题的一般步骤：
	1 针对所给问题，定义问题的解空间，它至少包含问题的一个（最优）解。
	2 确定易于搜索的解空间结构,使得能用回溯法方便地搜索整个解空间 。
	3 以深度优先的方式搜索解空间，并且在搜索过程中用剪枝函数避免无效搜索。
	问题的解空间通常是在搜索问题解的过程中动态产生的，这是回溯算法的一个重要特性。
	*/
	
	private ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null) return all;
		list.add(root.val);
		target -= root.val;
		
		if(target == 0 && root.left == null && root.right == null) {
			all.add(list);
		}
		findPath(root.left, target);
		findPath(root.right, target);
		
		list.remove(list.size()-1);//剪枝，避免无效搜索
		
		return all;
    } 
}