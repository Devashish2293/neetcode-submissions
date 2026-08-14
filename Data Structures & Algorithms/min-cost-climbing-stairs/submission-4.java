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


class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return Math.min(prev1, prev2);
    }
}