class Solution {
    
    // Memoization 
    // TC --> O(N) || SC --> O(N)
    private int houseRobber1Util(int s, int e, int[] nums, int[] dp) {
        // Base - case
        if(e == s) return nums[e];
        if(e == s+1) return (Math.max(nums[s], nums[e]));
        
        // Main - logic
        if(dp[e] == -1) {
            int notRobbed = houseRobber1Util(s, e-1, nums, dp);
            int robbed = nums[e] + houseRobber1Util(s, e-2, nums, dp); 

            dp[e] = Math.max(notRobbed, robbed);
        }
        return dp[e];
    }
    
    // Tabulation
    // TC --> O(N) || SC --> O(N)
    private int houseRobber1Tabulation(int s, int e, int[] nums) {
        int[] dp = new int[e - s + 1];
        
        dp[0] = nums[s]; // if only single house is present
        if(s < e) dp[1] = Math.max(nums[s], nums[s+1]); // if 2 or more than one house is there
        
        for(int ind=s+2; ind<=e; ind++) {
            int notRobbed = 0 + dp[ind-1-s];
            int robbed = nums[ind] + dp[ind-2-s];
            
            dp[ind-s] = Math.max(notRobbed, robbed);
        }
        return dp[e-s];
    }
    
    // Space - optimized
    // TC --> O(N) || SC --> O(1)
    private int houseRobber1SpaceOptimized(int s, int e, int[] nums) {
        if(s == e) return nums[s]; // single element
        int prev2 = nums[s];
        int prev = 0;
        if(s < e) prev = Math.max(nums[s], nums[s+1]);
        
        for(int ind=s+2; ind<=e; ind++) {
            int notRobbed = 0 + prev;
            int robbed = nums[ind] + prev2;
            
            int curr = Math.max(notRobbed, robbed);
            
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    private int houseRobber1(int s, int e, int[] nums) {
        
        // Memoization 
        // int N = nums.length;
        // int[] dp = new int[N];
        // Arrays.fill(dp, -1);
        // return houseRobber1Util(s, e, nums, dp);
        
        // Tabulation
        // return houseRobber1Tabulation(s, e, nums);
        
        // Space - optimized
        return houseRobber1SpaceOptimized(s, e, nums);
    }
    
    
    public int rob(int[] nums) {
        /* 
        Approach 
        if we break the circle 
        robber can now rob just like house robber problem
        1st time --> can rob [0, N-2] 
        2nd time --> can rob [1, N-1]
        the maximum money robbed in both the solution is the answer
        */
        int N = nums.length;
        
        // Edge - case
        if(N == 1) return nums[0];
        
        int rob1 = houseRobber1(0, N-2, nums);
        int rob2 = houseRobber1(1, N-1, nums);
        return Math.max(rob1, rob2);
    }
    
}