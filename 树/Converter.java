/*
题目描述
有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。
其可以用来表示二叉查找树(其中left指针表示左儿子，right指针表示右儿子)。
请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现，链表的数据结构用ListNode实现。
*/
import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

/* 中序遍历：*/
public class Converter {
	/* 1，递归版本：*/
	ListNode head = new ListNode(-1);
	ListNode fade = head;
	
    public ListNode treeToList(TreeNode root) {
        if(root != null) {
			treeToList(root.left);
			fade.next = new ListNode(root.val);
			fade = fade.next;
			treeToList(root.right);
		}
		return head.next;,
    }
	
	
	/* 2, 迭代版本：*/
	public ListNode treeToList2(TreeNode root) {
		if(root == null) {
			return null;
		}
		ListNode head = new ListNode(-1);
		ListNode fade = head;
		
		Stack<TreeNode> stack = new Stack<>();
		
		while(root != null && !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			fade.next = new ListNode(root.val);
			fade = fade.next;
			root = root.right;
		}
		
		return head.next;
	}
}









