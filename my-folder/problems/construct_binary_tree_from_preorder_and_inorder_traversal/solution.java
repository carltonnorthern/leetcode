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
    Map<Integer, Integer> map;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preIdx = 0;
        map = new HashMap<Integer, Integer>();
        for(int i=0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, preorder.length-1, map);
    }
    
    private TreeNode buildTree(int[] preorder, int left, int right, Map<Integer, Integer> map) {
        if(left > right) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int inIdx = map.get(root.val);
        
        root.left = buildTree(preorder, left, inIdx-1, map);
        root.right = buildTree(preorder, inIdx+1, right, map);
        
        
        return root;
    }
}