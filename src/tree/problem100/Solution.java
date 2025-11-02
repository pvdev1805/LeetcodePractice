package tree.problem100;

public class Solution {
    // #1. Recursion
    // Time Complexity: O(min(N, M)) where N and M are the number of nodes in trees p and q
    // Space Complexity: O(min(H1, H2)) where H1 and H2 are the heights of trees p and q
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
