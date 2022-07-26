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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        int leftMax = DFSLeftMax(root, 0);
        int rightMax = DFSRightMax(root, 0);
        for(int i=0; i<=leftMax+rightMax; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        Pair<TreeNode, Integer> pair = new Pair<TreeNode, Integer>(root, leftMax);
        queue.add(pair);
        
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int vert = p.getValue();
            if(node.left!=null) {
                queue.offer(new Pair(node.left, vert-1));
            }
            if(node.right!=null) {
                queue.offer(new Pair(node.right, vert+1));
            }
            list.get(vert).add(node.val);
        }
        
        return list;
    }
    
    private int DFSLeftMax(TreeNode node, int left) {
        if(node == null) {
            return left - 1;
        }
        
        return Math.max(DFSLeftMax(node.left, left+1), DFSLeftMax(node.right, left - 1));
    }
    
    private int DFSRightMax(TreeNode node, int right) {
        if(node == null) {
            return right - 1;
        }
        
        return Math.max(DFSRightMax(node.left, right - 1), DFSRightMax(node.right, right + 1));
    }
    
}