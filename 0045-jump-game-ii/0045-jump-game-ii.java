class Solution {
    
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[n-1] = 0;
        
        for(int i=n-2; i>=0; i--) {
            if(nums[i] == 0) {
                dp[i] = 0;
                continue;
            }
            
            int canJump = nums[i];
            int minJump = Integer.MAX_VALUE;
            for(int jump=canJump; jump>=1; jump--) {
                if(i+jump == n-1) {
                    minJump = 0;
                    break;
                }
                
                if(i+jump < n && dp[i+jump] != 0) {
                    minJump = Math.min(minJump, dp[i+jump]);
                }
            }
            if(minJump == Integer.MAX_VALUE) {
                dp[i] = 0;
            }
            else {
                dp[i] = 1 + minJump;
            }
        } 
        return dp[0];
    }
}