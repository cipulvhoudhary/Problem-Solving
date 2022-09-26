class Solution {
    
    private int robUtil(int s, int e, int[] nums, int[] dp) {
        // Base - case
        if(e < s) return 0;
        
        if(dp[e] == -1) {
            int notTake = 0 + robUtil(s, e-1, nums, dp);
            int take = nums[e] + robUtil(s, e-2, nums, dp);
            dp[e] = Math.max(notTake, take);
        }
        return dp[e];
    }
    
    public int rob(int[] nums) {
        int N = nums.length;
        // Edge - cese
        if(N == 1) return nums[0];
        int[] dp = new int[N];
        
        Arrays.fill(dp, -1);
        int ans1 = robUtil(0, N-2, nums, dp);
        
        Arrays.fill(dp, -1); // Since dp is a reference type, we need to clear it again
        int ans2 = robUtil(1, N-1, nums, dp);
        
        return Math.max(ans1, ans2);
    }
    
}