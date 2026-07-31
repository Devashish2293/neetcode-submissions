class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // sort
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Skip duplicates at this level
        // ✅ NEW: If the next element is the same, skip it
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }
        backtrack(nums, result, current, nextIndex);  // Skip all duplicates

        // Choice 2: Include current element
        current.add(nums[index]);
        backtrack(nums, result, current, index + 1);
        current.remove(current.size() - 1);
    }
}