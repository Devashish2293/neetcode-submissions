class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();
        backtrack(nums,result,current,0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result,List<Integer> current, int index)
    {
        if(index == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        //choice 1
        backtrack(nums,result,current,index+1);

        //choice 2
        current.add(nums[index]);
        backtrack(nums,result,current,index+1);
        current.remove(current.size()-1);
    }
}