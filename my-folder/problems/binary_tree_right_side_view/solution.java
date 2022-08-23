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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> outputList = new ArrayList<Integer>();
        
        if(root==null) {
            return outputList;
        }
        
        
        List<TreeNode> inputList = new ArrayList<TreeNode>();
        inputList.add(root);
        recursiveLevelOrder(inputList, outputList);
        return outputList;
        
    }
    
    public void recursiveLevelOrder(List<TreeNode> nodeList, List<Integer> outputList) {
        
        List<TreeNode> childrenNodeList = new ArrayList<TreeNode>();
        Stack<Integer> stack = new Stack<Integer>();
        for(TreeNode node : nodeList) {
            if(node.left!=null) {
                childrenNodeList.add(node.left);
            }
            if(node.right!=null) {
                childrenNodeList.add(node.right);
            }
            stack.push(node.val);
        }
        
        outputList.add(stack.pop());
        
        if(childrenNodeList.size()>0) {
            recursiveLevelOrder(childrenNodeList, outputList);
        }
    }
}