class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        int minCost = Math.min(minCost(cost,cost.length-1,dp),minCost(cost,cost.length-2,dp));
        return minCost;   
    }
    public int minCost(int[] cost, int index, int[] dp)
    {
        if(index == 0 )
            return dp[0] = cost[0];

        if(index == 1)
            return dp[1] = cost[1];    
        
        int cost1 = dp[index-1] != 0 ? dp[index-1] : minCost(cost,index-1,dp);
        int cost2 = dp[index-2] != 0 ? dp[index-2] : minCost(cost,index-2,dp);

        dp[index] = cost[index] + Math.min(cost1,cost2);
        return dp[index];
    }
}
