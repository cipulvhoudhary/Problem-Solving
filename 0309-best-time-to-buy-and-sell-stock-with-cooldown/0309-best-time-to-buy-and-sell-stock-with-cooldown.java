class Solution {
    
    // Approach 1 :: Memoization
    // TC --> O(N) || SC --> O(N)
    private int maxProfitUtil(int ind, int canBuy, int N, int[] prices, int[][] dp) {
        // Base - case
        if(ind >= N) return 0;
        if(ind == N) {
            if(canBuy == 1) return 0;
            else return prices[ind];
        }
        
        // Main - logic
        if(dp[ind][canBuy] == -1) {
            int profit = 0;
            if(canBuy == 1) {
                int buy = -prices[ind] + maxProfitUtil(ind+1, 0, N, prices, dp);
                int notBuy = 0 + maxProfitUtil(ind+1, 1, N, prices, dp);
                profit = Math.max(buy, notBuy);
            }
            else {
                int sell = prices[ind] + maxProfitUtil(ind+2, 1, N, prices, dp);
                int notSell = 0 + maxProfitUtil(ind+1, 0, N, prices, dp);
                profit = Math.max(sell, notSell);
            }
            dp[ind][canBuy] = profit;
        }
        return dp[ind][canBuy];
    }
    
    
    // Approach 2 :: Tabulation
    // TC --> O(N) || SC --> O(N)
    private int maxProfitTabulation(int N, int[] prices) {
        int[][] dp = new int[N][2];
        
        // Base - case
        dp[N-1][1] = 0; 
        dp[N-1][0] = prices[N-1];
        
        // Main - logic
        for(int ind = N-2; ind>=0; ind--) {
            int profit = 0;
            for(int canBuy=1; canBuy>=0; canBuy--) {
                if(canBuy == 1) {
                    int buy = -prices[ind] + dp[ind+1][0];
                    int notBuy = 0 + dp[ind+1][1];
                    profit = Math.max(buy, notBuy);
                }
                else {
                    int sell = prices[ind];
                    if(ind+2 < N) {
                        sell += dp[ind+2][1];
                    }
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
        // int[][] dp = new int[N][2];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return maxProfitUtil(0, 1, N, prices, dp);
        
        // Approach 2 :: Tabulation
        return maxProfitTabulation(N, prices);
    }
}