class Solution {
    
    private boolean canJumpUtil(int ind, int N, int[] nums, int[] dp) {
        // boundary - condition
        if(ind >= N) return false; 
        
        // Base - case :: 
        if(ind == N-1) return true; // if last index is reached -- true
        if(nums[ind] == 0) return false; // if jump is not possible
        
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
    
    private boolean canJumpUtil(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        
        dp[N-1] = 1;
        
        for(int i=N-2; i>=0; i--) {
            int maxJump = nums[i];
            if(maxJump == 0) continue;
            int j=maxJump;
            while(j >=1 && dp[i] != 1) {
                if(i+j < N && dp[i+j] == 1) dp[i] = 1;
                j--;
            }
        }
        return (dp[0] == 1) ? true : false;
    }
    
    private boolean canJumpHelper(int[] nums) {
        int N = nums.length;
        int reachable = 0;
        
        for(int i=0; i<N; i++) {
            if(reachable < i) 
                return false;
            
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }
    
    public boolean canJump(int[] nums) {
        // Memoization
        // int N = nums.length;
        // int[] dp = new int[N];
        // Arrays.fill(dp, -1);
        // return canJumpUtil(0, N, nums, dp);
        
        // Tabulation 
        // return canJumpUtil(nums);
        
        // Helper
        return canJumpHelper(nums);
    }
    
}