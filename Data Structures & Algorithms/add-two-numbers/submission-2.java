class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode curr = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int total = val1 + val2 + carry;
            carry = total >= 10 ? 1 : 0;
            
            if (sum == null) {
                sum = new ListNode(total % 10);
                sum.next = null;
                curr = sum;
            } else {
                ListNode nextSum = new ListNode(total % 10);
                curr.next = nextSum;
                nextSum.next = null;
                curr = nextSum;
            }
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return sum;
    }
}