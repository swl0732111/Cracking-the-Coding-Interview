import java.util.*;

/*
题目描述
请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
*/

/*情景一：给定根节点和指定的值，寻找下一个节点*/
public class Successor {
    public int findSucc(TreeNode root, int p) {
        boolean find = false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            if(!stack.isEmpty()) {
                TreeNode q = stack.pop();
                if(find) return q.val;
                else if(q.val == p) find = true;
                curr = q.right;
            }
        }
        return -1;
    }
}

/*情景二：只给出指定节点*/
class Successor2 {
	public TreeNode findSucc(TreeNode node) {
		if(node == null) return null;
		
		if(node.right != null) {
			/*右孩子不为空，找到右子树最左边的节点*/
			return leftMostChild(node.right);
		} else {
			TreeNode q = node;
			TreeNode x = q.parent;
			/*向上，直至node位于左子树而不是右子树*/
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	private TreeNode leftMostChild(TreeNode node) {
		if(node == null) return null;
		while(node.left != null) node = node.left;
		return node;
	}
}



