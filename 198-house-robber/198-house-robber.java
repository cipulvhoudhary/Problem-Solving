class Solution {
    
    private int robMemoizationUtil(int[] nums, int ind, int[] dp) {
        // base - case
        if(ind < 0) return 0;
        
        //Main - logic :: Rob or not-rob
        if(dp[ind] == -1) {
            //Rob :: if we rob ith house, we cannot rob (i-1)th house.
            int rob = nums[ind] + robMemoizationUtil(nums, ind - 2, dp); 
            //Not-Rob :: if we don't rob ith house, we can rob (i-1)th house
            int notRob = 0 + robMemoizationUtil(nums, ind - 1, dp);
            dp[ind] = Math.max(rob, notRob);
        }
        return dp[ind];
    }
    
    private int robMemoization(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N+1]; 
        Arrays.fill(dp, -1);
        return robMemoizationUtil(nums, N-1, dp);
    }
    
    private int robTabulation(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N+1];
        
        dp[0] = nums[0]; // we can maximize profit if we loot the first house, if there was only 1 house
        
        for(int ind=1; ind<N; ind++) {
            if(ind == 1) {
                dp[ind] = Math.max(nums[ind-1], nums[ind]);
                continue;
            }
            
            // dp[i] = Max of rob || notRob
            dp[ind] = Math.max(nums[ind] + dp[ind-2], 0 + dp[ind-1]);
        }
        return dp[N-1];
    }
    
    private int robTabulationSpaceOptimized(int[] nums) {
        int N = nums.length;
        if(N == 1) return nums[0];
        if(N == 2) return Math.max(nums[0], nums[1]);
        
        int a = nums[0], b = Math.max(nums[0], nums[1]), c = 0;
        for(int i=2; i<N; i++) {
            c = Math.max(nums[i]+a, b);
            a = b;
            b = c;
        }
        return c;
    }
    
    public int rob(int[] nums) {
        // return robMemoization(nums);  
        // return robTabulation(nums);
        return robTabulationSpaceOptimized(nums);
    }
    
}