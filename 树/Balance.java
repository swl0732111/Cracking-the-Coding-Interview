import java.util.*;

/*
题目描述
实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
*/
public class Balance {
    
    private int deepth(TreeNode p) {
        if(p == null) {return 0;}
        return Math.max(deepth(p.left), deepth(p.right)) + 1;
    }
    
    public boolean isBalance(TreeNode root) {
        if(root == null) {return true;}
        if((deepth(root.left) - deepth(root.right)) <-1 ||
          (deepth(root.left) - deepth(root.right)) >1 ) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}