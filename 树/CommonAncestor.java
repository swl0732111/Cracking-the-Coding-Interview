/*
题目描述：
设计并实现一个算法，找出二叉树中的某两个节点的第一个公共祖先。
注意：1，不得使用额外的空间； 2，这不一定是二叉查找树； 3，该树的数据结构中不包含指向父节点的链接
*/

public class CommonAncestor {
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(!cover(root, p) || !cover(root, q)) return null;
		return help(root, p, q);
	}
	private TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		if(root == p || root == q) return root;
		
		boolean p_on_left = cover(root.left, p);
		boolean q_on_right = cover(root.right, q);
		
		/*假如p和q不在一边*/
		if(p_on_left != q_on_right) return root;
		
		/*在同一边*/
		TreeNode child_side = p_on_left ? p_on_left : q_on_right;
		return help(child_side, p, q);		
	}
	private boolean cover(TreeNode root, TreeNode child) {
		if(root == null) return false;
		if(root == child) return true;
		return cover(root.left, child) || cover(root.left, child);
	}
}