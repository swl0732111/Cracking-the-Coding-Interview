/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindPath2 {
    /*
    这个想法与Two sum相似，使用HashMap存储（key：前缀和，value：获得这个前缀和的方式有多少），
    并且每到达一个节点时，我们检查前缀sum-target是否存在于hashmap中。
    如果存在，我们将前缀sum-target的方法加在了res中。
    */
    public int pathSum(TreeNode root, int sum) {
        
        HashMap<Integer, Integer> preSum = new HashMap<>();
        
        preSum.put(0, 1);
        
        return helper(root, 0, sum, preMap);
    }
    
    private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        
        if(root == null) return 0;
        
        currSum += root.val;
        
        int res = preSum.getOrDefault(currSum - target, 0);
        
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        
        preSum.put(currSum, preSum.get(currSum) - 1);
        
        return res;
        
    }
}