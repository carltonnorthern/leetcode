/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return recursive(root, 0);
    }
    
    public int recursive(TreeNode t, int count) {
        if(t==null) {
            return count;
        } else {
            count++;
            return Math.max(recursive(t.left, count), recursive(t.right, count));
        }
    }
}