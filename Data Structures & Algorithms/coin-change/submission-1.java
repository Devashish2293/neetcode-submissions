class Solution {
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],-1);
        }
        int ans = (int)coinCount(0,coins,amount,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public long coinCount(int i ,int[] coins, int amount,long[][] dp ){

        if(i==coins.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE; //dead end
        }
        if(amount==0)
            return 0;
        if (dp[i][amount] != -1) return dp[i][amount];    
        long skip = coinCount(i+1,coins,amount,dp);
        if(amount-coins[i]<0) return dp[i][amount] = skip;
        long pick = 1 + coinCount(i,coins,amount-coins[i],dp);

        return dp[i][amount] = Math.min(skip,pick);

    }
}
