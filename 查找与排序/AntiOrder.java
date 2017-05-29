/*
题目描述
有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
请设计一个高效的算法，计算给定数组中的逆序对个数。
给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
*/

import java.util.*;

public class AntiOrder {
	
	/*
	我仅仅是在上一题“维护x的秩”的基础上稍作修改，很简单
	*/
    Node root = null;
    public int count(int[] A, int n) {
        int res = 0;
		for(int i=0; i<n; i++) {
			res += helper(A[i]);
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
	int rightSize = 0;
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
			
		} else {
			if(right != null) {
				right.insert(v);
			} else {
				right = new Node(v);
			}
            rightSize++;
		}
	}
	
	public int getRank(int v) {
		if(v == val) {
			return rightSize;
		} else if(v < val) {
			return rightSize+1+left.getRank(v);
		} else {
			return right.getRank(v);
		}
	}
}