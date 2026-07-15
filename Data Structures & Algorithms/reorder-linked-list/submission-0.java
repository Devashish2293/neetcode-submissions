class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half (starting from slow.next)
        ListNode curr = slow.next;
        slow.next = null;  // ✅ NEW: Cut the list
        ListNode previous = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }

        // Merge
        ListNode firstHead = head;
        ListNode secondHead = previous;  // ✅ CHANGED: Use previous (reversed second half)
        while (secondHead != null) {
            ListNode dummy = secondHead.next;
            secondHead.next = firstHead.next;
            firstHead.next = secondHead;
            firstHead = secondHead.next;  // ✅ CHANGED: Move firstHead forward
            secondHead = dummy;
        }
    }
}