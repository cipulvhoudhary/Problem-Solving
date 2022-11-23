class Solution {
    
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
    
    public int rob(int[] nums) {
        /*
        Approach 
        if a robber robs, ith house then he has *i coins + he can rob before (i-2)th house,... 
        ...as, if he tries to rob (i-1)th house, alarm will beep and he will be arrested
        if the robber does not rob ith house, he get 0 coins + he can rob the (i-1)th house...
        ... without alerting the police
        */
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return robMemoization(N-1, nums, dp);
    }
}