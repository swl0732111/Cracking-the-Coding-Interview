/*
Balance.class的代码虽然可行，但是效率不高。那段代码会递归访问每个节点的子树。时间复杂度O(nlogn)。
下面的Balance2是改进版本，时间复杂度O(n)。
*/

public class Balance2 {
	public boolean isBalance(TreeNode root) {
		if(checkHeight(root) == -1) return false;
		return true;
	}
	
	private int checkHeight(TreeNode root) {
		if(root == null) return 0;
		
		/*检查左子树是否平衡*/
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) return -1;
		
		/*检查右子树是否平衡*/
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) return -1;
		
		/*检查当前节点是否平衡*/
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) return -1;
		else return Math.max(leftHeight, rightHeight) + 1;
	}
}