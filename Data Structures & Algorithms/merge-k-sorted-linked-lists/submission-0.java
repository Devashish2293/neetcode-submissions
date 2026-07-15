class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        if (length == 1) return lists[0];
        
        // Merge the last two lists
        ListNode merged = mergeTwoLists(lists[length - 1], lists[length - 2]);
        
        // Create a new array with one less element
        ListNode[] newList = new ListNode[length - 1];
        for (int i = 0; i < length - 2; i++) {
            newList[i] = lists[i];
        }
        newList[length - 2] = merged;
        
        return mergeKLists(newList);
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}