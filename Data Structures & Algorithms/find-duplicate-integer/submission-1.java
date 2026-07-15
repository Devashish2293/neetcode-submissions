class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;          // ✅ Start at 0
        int fast = 0;          // ✅ Start at 0

        // Find intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find cycle entry (the duplicate)
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}