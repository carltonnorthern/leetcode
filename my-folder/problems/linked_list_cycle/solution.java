/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) {
            return false;
        }
        ListNode tortoise = head.next;
        ListNode hare = head.next.next;
        
        while(tortoise != hare) {
            if(tortoise.next==null) {
                return false;
            } else{
                tortoise = tortoise.next;
            }
            if (hare.next==null) {
                return false;
            } else if(hare.next.next==null){
                return false;
            } else {
                hare = hare.next.next;
            }
        }
        return true;
        /*tortoiseP = head;
        while(tortoise!=hare) {
            tortoise = toirtoise.next;
            hare = hare.next;
        }*/
    }
}