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
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        while(currentNode!=null){
            ListNode next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        return previousNode;
    }
}
