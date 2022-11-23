class Solution {
    
    private int minCostClimbingStairsMemoization(int ind, int[] cost, int[] dp) {
        // Base - case
        if(ind >= cost.length) return 0;
        
        // Main - logic
        if(dp[ind] == -1) {
            int oneStep = minCostClimbingStairsMemoization(ind+1, cost, dp);
            int twoStep = minCostClimbingStairsMemoization(ind+2, cost, dp);
            dp[ind] = (cost[ind] + Math.min(oneStep, twoStep));
        }
        return dp[ind];
    }
    
    private int minCostClimbingStairsTabulation(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N+1];
        
        // Base - case :: to reach top from last step, we need cost = cost[N-1];
        dp[N-1] = cost[N-1];
        
        for(int ind = N-2; ind>=0; ind--) {
            dp[ind] = cost[ind] + Math.min(dp[ind+1], dp[ind+2]);
        }
        int cost1 = dp[0]; // Started climbing from 0th index
        int cost2 = dp[1]; // Started climbing from 1st index
        return Math.min(cost1, cost2);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        // Approach 1 :: Memoization
        int N = cost.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return Math.min(minCostClimbingStairsMemoization(0, cost, dp), minCostClimbingStairsMemoization(1, cost, dp));
        
        // Approach 2 :: Tabulation
        // return minCostClimbingStairsTabulation(cost);
    }
    
}