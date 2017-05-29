
import java.util.*;

/*法二：
用一个二叉查找树来维护当前已经插入的数组，小于等于该节点插入左子树内，
大于插入右子树内，递归调用。
这样，每次查询小于等于某个节点的节点数，分三种情况讨论，递归调用：
1.当前节点的值等于插入的节点的值，那么返回该节点的左子树数目就等于秩；
2.当前节点的值小于插入的节点的值，那么递归调用左子树（因为该节点的本身
及其右子树都对秩没影响)；
3.当前节点的值大于插入的节点的值，那么当前节点的所有左子树加上本身都是
该插入节点的秩，然后加上插入的节点在右子树中的秩之和为改插入节点的秩；
*/
public class RankOfNumber2 {
	
	Node root = null;
	
	public int[] getRankOfNumber(int[] A, int n) {
		int[] res = new int[n];
		for(int i=0; i<n; i++) {
			res[i] = helper(A[i]);
		}
		return res;
	}
	
	private int helper(int a) {
		if(root == null) {
			root = new Node(a);
		} else {
			root.insert(a);
		}
		return root.getRank(a);
	}
}

class Node {
	int leftSize = 0;
	Node left, right;
	int val;
	
	public Node(int v) {
		val = v;
	}
	
	public void insert(int v) {
		if(v <= val) {
			if(left != null) {
				left.insert(v);
			} else {
				left = new Node(v);
			}
			leftSize++;
		} else {
			if(right != null) {
				right.insert(v);
			} else {
				right = new Node(v);
			}
		}
	}
	
	public int getRank(int v) {
		if(v == val) {
			return leftSize;
		} else if(v < val) {
			return left.getRank(v);
		} else {
			return leftSize+1+right.getRank(v);
		}
	}
}









