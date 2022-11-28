class Solution {
    
    // Approach 1 :: Memoization
    // TC --> O(N) || SC --> O(N)
    // canBuy --> true (can buy) || canBuy --> false (already bought)
    private int maxProfitMemoization(int ind, int canBuy, int[] prices, int[][] dp) {
        // Base - case
        // if(ind == prices.length) return 0;
        if(ind == prices.length-1) {
            if(canBuy == 1) return 0;
            else return prices[prices.length-1];
        }
        
        // Main - logic
        if(dp[ind][canBuy] == -1) {
            int profit = 0;
            if(canBuy == 1) {
                int buy = -prices[ind] + maxProfitMemoization(ind+1, 0, prices, dp);
                int notBuy = 0 +  maxProfitMemoization(ind+1, 1, prices, dp);
                profit = Math.max(buy, notBuy);
            }
            else {
                int sell = prices[ind] + maxProfitMemoization(ind+1, 1, prices, dp);
                int notSell = 0 + maxProfitMemoization(ind+1, 0, prices, dp);
                profit = Math.max(sell, notSell);
            }
            dp[ind][canBuy] = profit;
        }
        return dp[ind][canBuy];
    }
    
    // Approach 2 :: Tabulation
    private int maxProfitTabulation(int[] prices) {
        int N = prices.length;
        int[][] dp = new int[N][2]; 
        
        dp[N-1][0] = prices[N-1];
        // base case is already covered with the initial config of dp[as array of int initializes from 0]
        
        for(int ind=N-2; ind>=0; ind--) {
            int profit = 0;
            for(int canBuy=1; canBuy>=0; canBuy--) {
                if(canBuy == 1) {
                    int buy = -prices[ind] + dp[ind+1][0];
                    int notBuy = 0 + dp[ind+1][1];
                    profit = Math.max(buy, notBuy);
                }
                else {
                    int sell = prices[ind] + dp[ind+1][1];
                    int notSell = 0 + dp[ind+1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[ind][canBuy] = profit;
            }
        }
        return dp[0][1];
    }
    
    public int maxProfit(int[] prices) {
        int N = prices.length;
        
        // Approach 1 :: Memoization
        int[][] dp = new int[N][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return maxProfitMemoization(0, 1, prices, dp);
        
        // Approach 2 :: Tabulation
        // return maxProfitTabulation(prices);
    }
}