class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        // Base case: reached the end → add current permutation
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        // Try every element from index to end
        for (int i = index; i < nums.length; i++) {
            // 1. Swap
            swap(nums, index, i);
            
            // 2. Recurse
            backtrack(nums, index + 1, result);
            
            // 3. Swap back (Backtrack!)
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}