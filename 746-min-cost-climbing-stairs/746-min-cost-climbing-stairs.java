class Solution {
    
    // Helper function of minCostClimbingStairsMemoization(cost)
    private int minCostClimbingStairsMemoizationUtil(int[] cost, int N, int[] dp) {
        //Base - case
        if(N <= 1) return 0; //we can either start from 0th stair or 1st stair without any cost
        
        //Main - logic
        if(dp[N] == -1) {
            int fromLastStep = cost[N-1] + minCostClimbingStairsMemoizationUtil(cost, N-1, dp);
            int fromSecondLast = cost[N-2] + minCostClimbingStairsMemoizationUtil(cost, N-2, dp);

            dp[N] = Math.min(fromLastStep, fromSecondLast);
        }
        return dp[N];
    }
    
    // Dp with Memoization :: TC --> O(N) || SC --> O(N)
    private int minCostClimbingStairsMemoization(int [] cost) {
        int N = cost.length;
        int[] dp = new int[N+1];
        Arrays.fill(dp, -1);
        return minCostClimbingStairsMemoizationUtil(cost, N, dp);
    }
    
    // Dp with Tabulation :: TC --> O(N) || SC --> O(N)
    private int minCostClimbingStairsTabulation(int[] cost) {
        int N = cost.length;
        
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i=2; i<=N; i++) {
            int fromLastStep = cost[i-1] + dp[i-1];
            int fromSecondLast = cost[i-2] + dp[i-2];
            dp[i] = Math.min(fromLastStep, fromSecondLast);
        }
        return dp[N];
    }
    
    private int minCostClimbingStairsTabulationSpaceOptimized(int[] cost) {
        int N = cost.length;
        
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        
        int a = 0, b = 0;
        int costA = cost[0], costB = cost[1];
        int c = 0;
        for(int i=2; i<=N; i++) {
            int fromLastStep = costA + a;
            int fromSecondLast = costB + b;
            c = Math.min(fromLastStep, fromSecondLast);
            
            a = b;
            b = c;
            
            costA = costB;
            if(i != N) {
                costB = cost[i];
            }
        }
        return c;
    }
    
    public int minCostClimbingStairs(int[] cost) {
        /* Approach 
        - Same as climbing stairs
        - To reach Nth step, we can jump directly from (N-1) or (N-2) steps
        - To reach N from(N-1) --> cost = cost[N-1]
        - To reach N from(N-1) --> cost = cost[N-2]
        - Return the min of the two in order to get min cost
        */
        // return minCostClimbingStairsMemoization(cost);
        // return minCostClimbingStairsTabulation(cost);
        return minCostClimbingStairsTabulationSpaceOptimized(cost);
    }
    
}