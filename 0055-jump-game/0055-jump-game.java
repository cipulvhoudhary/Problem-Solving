class Solution {
    
    private boolean canJumpUtil(int ind, int N, int[] nums, int[] dp) {
        // boundary - condition
        if(ind >= N) return false; 
        
        // Base - case :: 
        if(ind == N-1) return true; // if last index is reached -- true
        if(nums[ind] == 0) return false; // if jump is not possible
        
        // Main - logic
        if(dp[ind] != -1) return (dp[ind]==1) ? true : false;
        
        int maxJump = nums[ind];
        for(int jump=1; jump<=maxJump; jump++) {
            if(canJumpUtil(ind+jump, N, nums, dp)) {
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        int N = nums.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return canJumpUtil(0, N, nums, dp);
    }
    
}