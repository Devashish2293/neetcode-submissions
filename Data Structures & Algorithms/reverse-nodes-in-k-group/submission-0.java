class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        
        while (true) {
            // Step 1: Find the k-th node from current position
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;  // Fewer than k nodes left
            
            ListNode groupNext = kth.next;
            
            // Step 2: Reverse the current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            
            // Step 3: Connect back to the list
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }
    
    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}