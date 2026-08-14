class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return amount(nums,0,dp);
    }

    public int amount(int[] nums, int index, int[] dp){

        if(index >=nums.length)
            return 0;
        if(dp[index] != -1)
            return dp[index];            
        int take = nums[index] + amount(nums,index+2,dp);
        int skip = amount(nums,index+1,dp);
        return dp[index] = Math.max(take,skip);
    }
}
