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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        
        
            Given nodes add child nodes to array
            store array in output array of arrays
            call function again on child nodes array
        
        */
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();
        
        if(root==null) {
            return outputList;
        }
        
        
        List<TreeNode> inputList = new ArrayList<TreeNode>();
        inputList.add(root);
        recursiveLevelOrder(inputList, outputList);
        return outputList;
        
    }
    
    public void recursiveLevelOrder(List<TreeNode> nodeList, List<List<Integer>> outputList) {
        
        List<TreeNode> childrenNodeList = new ArrayList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        for(TreeNode node : nodeList) {
            if(node.left!=null) {
                childrenNodeList.add(node.left);
            }
            if(node.right!=null) {
                childrenNodeList.add(node.right);
            }
            list.add(node.val);
        }
        
        outputList.add(list);
        
        if(childrenNodeList.size()>0) {
            recursiveLevelOrder(childrenNodeList, outputList);
        }
    }
}


