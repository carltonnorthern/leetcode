/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        ListNode revHead;
        ListNode revPrev = new ListNode(head.val);
        ListNode newNode = new ListNode();
        while(node.next!=null) {
            ListNode prev = node;
            node = node.next;
            newNode = new ListNode(node.val);
            newNode.next = revPrev;
            revPrev = newNode;
        }
        revHead = newNode;
        
        node = head;
        ListNode revNode = revHead;
        
        while(node.next!=null) {
            if(node.val == revNode.val) {
                node = node.next;
                revNode = revNode.next;
            } else {
                return false;
            }
        }
        
        return true;
        
    }
}