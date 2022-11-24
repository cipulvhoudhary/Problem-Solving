class Solution {
    
    // Approach 1 :: Memoization
    // TC --> O(N) || SC --> O(N)
    private int robMemoization(int ind, int[] nums, int[] dp) {
        // Base - case
        if(ind == 0) return nums[ind];
        if(ind == 1) return Math.max(nums[0], nums[1]);
        
        // Main - logic
        if(dp[ind] == -1) {
            int notRobbed = 0 + robMemoization(ind-1, nums, dp);
            int robbed = nums[ind] + robMemoization(ind-2, nums, dp);

            dp[ind] = Math.max(notRobbed, robbed);
        }
        return dp[ind];
    }
    
    // Approach 2 :: Tabulation
    // TC --> O(N) || SC --> O(N)
    private int robTabulation(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        
        // Base - case
        dp[0] = nums[0];
        if(N > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        
        for(int ind=2; ind<N; ind++) {
            int notRobbed = 0 + dp[ind-1];
            int robbed = nums[ind] + dp[ind-2];

            dp[ind] = Math.max(notRobbed, robbed);
        }
        return dp[N];
    }
    
    // Approach 3 :: Space - optimized
    // TC --> O(N) || SC --> O(1)
    private int robSpaceOptimized(int[] nums) {
        int N = nums.length;
        
        // Base - case
        if(N == 1) return nums[0];
        
        int prev2 = nums[0];
        int prev = 0;
        if(N > 1) {
            prev = Math.max(nums[0], nums[1]);
        }
        
        for(int ind=2; ind<N; ind++) {
            int notRobbed = 0 + prev;
            int robbed = nums[ind] + prev2;

            int curr = Math.max(notRobbed, robbed);
            
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    public int rob(int[] nums) {
        /*
        Approach 
        if a robber robs, ith house then he has *i coins + he can rob before (i-2)th house,... 
        ...as, if he tries to rob (i-1)th house, alarm will beep and he will be arrested
        if the robber does not rob ith house, he get 0 coins + he can rob the (i-1)th house...
        ... without alerting the police
        */
        
        // Approach 1 :: Memoization
        // int N = nums.length;
        // int[] dp = new int[N];
        // Arrays.fill(dp, -1);
        // return robMemoization(N-1, nums, dp);
        
        // Approach 2 :: Tabulation
        // return robTabulation(nums);
        
        // Approach 3 :: Space - optimized
        return robSpaceOptimized(nums);
    }
}