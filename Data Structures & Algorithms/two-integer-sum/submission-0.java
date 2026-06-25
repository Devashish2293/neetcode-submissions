class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> targetSubtractNumMap = new HashMap();
        for(int i = 0 ; i<nums.length ; i++)
        {   
            int difference = target-nums[i];
            targetSubtractNumMap.put(difference,i);
        }
        for(int i = 0 ; i<nums.length ; i++)
        {
            if(targetSubtractNumMap.containsKey(nums[i]) && targetSubtractNumMap.get(nums[i]) != i)
            {
                 return new int[]{i, targetSubtractNumMap.get(nums[i])};
             }

        }
        return new int[2];
    }
}
