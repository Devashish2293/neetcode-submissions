class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        
        while (left <= right) {  // ✅ Change to <=
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            
            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                if (nums[left] < nums[right]) break;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }
}