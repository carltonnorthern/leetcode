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
    public int countNodes(TreeNode root) {
        
         if(root==null) {
            return 0;
        }
        int height = findHeight(root);
        int upperCount = (int) Math.pow(2, (height-1)) - 1;
        int left = 0;
        int right = (int) Math.pow(2, (height-1)) - 1;
        int middleIndex = (int) Math.ceil((left + right) / 2.0);
        while (left < right) {
            if(doesNodeExist(middleIndex, height, root)) {
                left = middleIndex;
            } else {
                right = middleIndex - 1;
            }
            middleIndex = (int) Math.ceil((left + right) / 2.0);
        }

        return upperCount + left + 1;
    }

    private static boolean doesNodeExist(int nodeToFindIndex, int height, TreeNode node) {
        int count = 1;
        int left = 0;
        int right = (int) Math.pow(2, (height-1)) - 1;
        while(count<height){
            int middleIndex = (int) Math.ceil((left + right) / 2.0);
            if(nodeToFindIndex<middleIndex) {
                node = node.left;
                right = middleIndex-1;
            } else {
                node = node.right;
                left = middleIndex;
            }
            count++;
        }
        if(node==null) {
            return false;
        } else {
            return true;
        }
    }

    private static int findHeight(TreeNode node) {
        int count = 0;
        while(node!=null) {
            node = node.left;
            count++;
        }
        return count;
    }
}