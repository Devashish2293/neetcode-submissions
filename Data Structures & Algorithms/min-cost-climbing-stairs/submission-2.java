class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        int minCost = Math.min(minCost(cost,cost.length-1,dp),minCost(cost,cost.length-2,dp));
        return minCost;   
    }
    public int minCost(int[] cost, int index, int[] dp)
    {
        if(index == 0 || index == 1 )
            return cost[index];

        if(dp[index] != -1)
            return dp[index];
        
        return dp[index] = cost[index] + Math.min(minCost(cost,index-1,dp),minCost(cost,index-2,dp));
    }
}
