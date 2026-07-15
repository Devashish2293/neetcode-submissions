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
    public boolean hasCycle(ListNode head) {
        if(head ==null || head.next == null)
            return false;
        ListNode fastHead = head.next;
        while(fastHead!=null && fastHead.next!=null)
        {
            if(fastHead == head)
            return true;
            head = head.next;
            fastHead = fastHead.next.next;
        }
        return false;
    }
}
