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
        ListNode sum = null;
        ListNode curr = null;
        int carry = 0 ;
        while(l1 !=null && l2 !=null)
        {
            if(sum==null)
            {
                carry = (l1.val + l2.val)>= 10 ? 1 : 0;
                sum = new ListNode((l1.val + l2.val)%10);
                sum.next = null;
                l1 = l1.next;
                l2 = l2.next;
                curr = sum;
                continue;
            }
            ListNode nextSum = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)>=10?1 :0;
            curr.next = nextSum;
            nextSum.next = null;
            curr = nextSum;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null)
        {
            ListNode nextSum = new ListNode((l1.val + carry)%10);
            carry = (l1.val + carry)>=10?1 :0;
            curr.next = nextSum;
            nextSum.next = null;
            curr = nextSum;
            l1 = l1.next;
        }
         while(l2 != null)
        {
            ListNode nextSum = new ListNode((l2.val + carry)%10);
            carry = (l2.val + carry)>=10?1 :0;
            curr.next = nextSum;
            nextSum.next = null;
            curr = nextSum;
            l2 = l2.next;
        }
        if(carry>0){
            curr.next = new ListNode(1);
            curr = curr.next;
        }
            
        return sum;
    }
}
