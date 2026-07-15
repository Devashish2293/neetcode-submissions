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
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length == 0)
        return null; 
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val); 
       for(ListNode list : lists){
            if(list !=null){
                minHeap.offer(list);
            }
       }

       ListNode dummy = new ListNode(0);
       ListNode tail = dummy; 
       while(!minHeap.isEmpty())
       {
        ListNode node = minHeap.poll();
        tail.next = node;
        tail = tail.next;

        node = node.next;
        if(node!=null)
            minHeap.offer(node);
       }
       return dummy.next;
    }
}