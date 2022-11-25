class Solution {
    
    private boolean canJumpUtil(int ind, int N, int[] nums, int[] dp) {
        // Base - case :: if last index is reached -- true
        if(ind == N-1) return true;
        
        // Main - logic
        if(dp[ind] == -1) {
            boolean canReach = false;
            int maxJump = nums[ind];
            for(int jump=1; jump<=maxJump; jump++) {
                if(canJumpUtil(ind+jump, N, nums, dp)) {
                    canReach = true;
                    break;
                }
            }
            dp[ind] = (canReach) ? 1 : 0; 
        }
        return (dp[ind] == 1) ? true : false; 
    }
    
    public boolean canJump(int[] nums) {
        int N = nums.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return canJumpUtil(0, N, nums, dp);
    }
    
}