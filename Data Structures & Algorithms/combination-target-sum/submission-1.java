class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, result, current, 0,target);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index,int target) {

        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
            
         if (index == nums.length || target < 0) {
            return;
        }
        
        // Choice 1: Exclude
        backtrack(nums, result, current, index + 1,target);

        // Choice 2: Include
        current.add(nums[index]);
        backtrack(nums, result, current, index,target-nums[index]);
        current.remove(current.size() - 1);  // Backtrack 

    }
}
