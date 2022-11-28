class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        
        /* Approach 1
        TC --> O(N) || O(N)
        for every ith day, we buy at price[i], 
        if we somehow know the max price[i] from future i.e price --> [i+1] till [N-1]
        we can square off to get the profit/loss
        Right max array will help
        */
//         int[] rMax = new int[N];
//         rMax[N-1] = prices[N-1];
//         for(int i=N-2; i>=0; i--) {
//             rMax[i] = Math.max(prices[i], rMax[i+1]);
//         }
                
//         int maxProfit = 0;
//         for(int i=0; i<N-1; i++) {
//             int profit = rMax[i+1] - prices[i];
//             maxProfit = Math.max(maxProfit, profit);
//         }
//         return maxProfit;
        
        /* Approach 2 
        TC --> O(N) || SC -- > O(1)
        Traverse from last, and carry rMax as a int literal
        */
        int rMax = prices[N-1];
        int maxProfit = 0;
        for(int i=N-2; i>=0; i--) {
            int profit = rMax - prices[i];
            maxProfit = Math.max(maxProfit, profit);
            
            rMax = Math.max(rMax, prices[i]);
        }
        return maxProfit;
    }
}