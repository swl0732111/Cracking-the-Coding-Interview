import java.util.*;

/*
对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
*/

/*法一：递归*/
public class TreeLevel {
    
    ListNode node = new ListNode(-1);
    ListNode fade = node;
    
    public ListNode getTreeLevel(TreeNode root, int dep) {
        
        if(root == null || dep < 0) return null;
        
        if(dep == 1) {
            fade.next = new ListNode(root.val);
            fade = fade.next;
        } else {
            getTreeLevel(root.left, dep-1);
            getTreeLevel(root.right, dep-1);
        }
        
        return node.next;   
    }
}

/*法二：广度优先搜索*/
class TreeLevel2 {
	public ListNode getTreeLevel(TreeNode root, int dep) {
		if(root == null) return null;
		ListNode head = new ListNode(0);
		ListNode curr = head;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.remove();
				if(dep == 0) {
					curr.next = new LinkedList(node.val);
					curr = curr.next;
				}
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			if(dep == 0) break;
		}
		return head.next;
	}
}



