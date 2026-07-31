class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, 0, target);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == nums.length || target < 0) {
            return;
        }
        
        // Choice 1: Include 
        current.add(nums[index]);
        backtrack(nums, result, current, index + 1, target - nums[index]);
        current.remove(current.size() - 1);
        
        // remove  duplicates
         int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++;
        }

        // Choice 2: Exclude (move to next non duplicate index)
        backtrack(nums, result, current, nextIndex, target);


    }
}