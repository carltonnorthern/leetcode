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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1curr = l1;
        ListNode l2curr = l2;
        ListNode output = new ListNode();
        ListNode outputcurr = output;
        ListNode outputprev = null;
        int remainder = 0;

        while(l1curr != null || l2curr !=null) {

            if(l1curr !=null && l2curr != null) {
                int temp = l1curr.val + l2curr.val + remainder;
                if(temp > 9) {
                    int tempy = temp % 10;
                    outputcurr.val = temp % 10;
                    remainder = 1;
                } else {
                    outputcurr.val = temp;
                    remainder = 0;
                }
                l1curr = l1curr.next;
                l2curr = l2curr.next;
            } else if(l1curr != null ) {
                int temp = l1curr.val + remainder;
                if(temp > 9) {
                    outputcurr. val = temp % 10;
                    remainder = 1;
                } else {
                    outputcurr.val = temp;
                    remainder = 0;
                }
                l1curr = l1curr.next;
            } else if(l2curr != null ) {
                int temp = l2curr.val + remainder;
                if(temp > 9) {
                    outputcurr.val = temp % 10;
                    remainder = 1;
                } else {
                    outputcurr.val = temp;
                    remainder = 0;
                }
                l2curr = l2curr.next;
            }

            if(outputprev == null) {
                outputprev = outputcurr;
            } else {
                outputprev.next = outputcurr;
            }

            outputprev = outputcurr;
            outputcurr = new ListNode();

        }

        if (remainder == 1) {
            outputcurr.val = 1;
            outputprev.next = outputcurr;
        }

        return output;
    }
}