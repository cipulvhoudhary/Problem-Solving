class Solution {
    
    // Approach 1 :: Memoization
    // TC --> O(N) || SC --> O(N)
    private int maxProfitMemoization(int ind, int canBuy, int N, int[] prices, int fee, int[][] dp) {
        
        // Boundary - condition
        if(ind >= N) return 0;
        
        // Base - case
        if(ind == N-1) {
            if(canBuy == 1) {
                // no profit can be made, as we have to buy, 
                // but since there is no point in buying at last, we will not buy.    
                return 0; 
            }
            else {
                // As we have already bought stock, we need to square off 
                // to gain some profit atleast. But here we will have to pay transaction fee also
                // if profit made is negative, we will not sell 
                // sell only if profit made is positive
                return (prices[ind] - fee < 0) ? 0 : prices[ind] - fee;
            }
        }
        
        // Main - logic
        if(dp[ind][canBuy] == -1) {
            int profit = 0;
            if(canBuy == 1) {
                int buy = -prices[ind] + maxProfitMemoization(ind+1, 0, N, prices, fee, dp);
                int notBuy = 0 + maxProfitMemoization(ind+1, 1, N, prices, fee, dp);
                profit = Math.max(buy, notBuy);
            }
            else {
                int sell = (prices[ind] - fee) + maxProfitMemoization(ind+1, 1, N, prices, fee, dp);
                int notSell = 0 + maxProfitMemoization(ind+1, 0, N, prices, fee, dp);
                profit = Math.max(sell, notSell);
            }
            dp[ind][canBuy] = profit;
        }
        return dp[ind][canBuy];
    }
    
    
    // Approach 2 :: Tabulation
    // TC --> O(N) || SC --> O(N)
    private int maxProfitTabulation(int[] prices, int N, int fee) {
        int[][] dp = new int[N][2];
        
        // Base - case
        dp[N-1][0] = (prices[N-1] - fee < 0) ? 0 : prices[N-1] - fee;
        
        // Main - logic
        for(int ind=N-2; ind>=0; ind--) {
            int profit = 0;
            for(int canBuy=1; canBuy>=0; canBuy--) {
                if(canBuy == 1) {
                    int buy = -prices[ind] + dp[ind+1][0];
                    int notBuy = 0 + dp[ind+1][1];
                    profit = Math.max(buy, notBuy);
                }
                else {
                    int sell = (prices[ind] - fee) + dp[ind+1][1];
                    int notSell = 0 + dp[ind+1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[ind][canBuy] = profit;
            }
        }
        return dp[0][1];
    }
    
    
    // Approach 3 :: Space - optimization
    // TC --> O(N) || SC --> O(1)
    private int maxProfitSpaceOptimized(int[] prices, int N, int fee) {
        int[] dp = new int[2];
        
        // Base - case
        dp[0] = (prices[N-1] - fee < 0) ? 0 : prices[N-1] - fee;
        
        // Main - logic
        for(int ind=N-2; ind>=0; ind--) {
            int profit = 0;
            for(int canBuy=1; canBuy>=0; canBuy--) {
                if(canBuy == 1) {
                    int buy = -prices[ind] + dp[0];
                    int notBuy = 0 + dp[1];
                    profit = Math.max(buy, notBuy);
                }
                else {
                    int sell = (prices[ind] - fee) + dp[1];
                    int notSell = 0 + dp[0];
                    profit = Math.max(sell, notSell);
                }
                dp[canBuy] = profit;
            }
        }
        return dp[1];
    }
    
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        
        // Approach 1 :: Memoization
        // int[][] dp = new int[N][2];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // int canBuy = 1;
        // return maxProfitMemoization(0, canBuy, N, prices, fee, dp);
        
        // Approach 2 :: Tabulation
        // return maxProfitTabulation(prices, N, fee);
        
        // Approach 3 :: Space - optimization
        return maxProfitSpaceOptimized(prices, N, fee);
    }
}