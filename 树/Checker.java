import java.util.*;

/*
题目描述
请实现一个函数，检查一棵二叉树是否为二叉查找树。
*/
/*两种方法*/

//法一：中序遍历（AC了83%的测试用例，不知道错在哪）
public class Checker {
    
    public boolean checkBST(TreeNode root) {
        int lastChecked = Integer.MIN_VALUE;
        return checkBST(root, lastChecked);
    }
    
    private boolean checkBST(TreeNode root, int lastChecked) {
        
        if(root == null) return true;
        
        if(!checkBST(root.left, lastChecked)) return false;
        
        if(root.val < lastChecked) return false;
        lastChecked = root.val;
        
        if(!checkBST(root.right, lastChecked)) return false;
        
        return true;
	}
}

//法二：最大/最小法（根据BST的定义）
class Checker2 {
	public boolean checkBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean checkBST(TreeNode root, int min, int max) {
		if(root == null) return true;
		
		if(root.val < min || root.val > max) return false;
		
		if(!checkBST(root.left, min, root.val) || !checkBST(root.right, root.val, max)) {
			return false;
		}
		return true;
	}
}