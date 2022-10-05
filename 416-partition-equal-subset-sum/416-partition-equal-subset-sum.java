class Solution {
    
    private boolean canPartitionMemoizationUtil(int ind, int[] nums, int target, int[][] dp) {
        // Base - case
        if(target == 0) return true;
        if(ind == 0) {
            return (nums[0] == target) ? true : false;
        }
        
        // Main - logic
        if(dp[ind][target] == -1) {
            boolean notTake = canPartitionMemoizationUtil(ind-1, nums, target, dp);
            boolean take = false;
            if(target >= nums[ind]) {
                take = canPartitionMemoizationUtil(ind-1, nums, target-nums[ind], dp);
            }
            dp[ind][target] = (notTake || take) ? 1 : 0;
        }
        return (dp[ind][target] == 1) ? true : false;
    }
    
    private boolean canPartitionTabulationUtil(int N, int[] nums, int target) {
        boolean[][] dp = new boolean[N][target+1];
        
        // Base - case
        for(int ind=0; ind<N; ind++) {
            dp[ind][0] = true; // when target = 0
        }
        for(int t=1; t<=target; t++) {
            if(nums[0] == t) dp[0][t] = true;
        }
        
        // Main - logic
        for(int ind=1; ind<N; ind++) {
            for(int t=1; t<=target; t++) {
                boolean notTake = dp[ind-1][t];
                boolean take = false;
                if(t >= nums[ind]) {
                    take = dp[ind-1][t-nums[ind]];
                }
                dp[ind][t] = (notTake || take);
            }
        }
        return dp[N-1][target];
    }
    
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int e : nums) totalSum += e;
        
        // total sum must be even if need to partitioned equally
        if(totalSum%2 != 0) return false;
        
        int N = nums.length;
        int target = totalSum/2;
        
//         int[][] dp = new int[N][target+1];
//         for(int[] row : dp) Arrays.fill(row, -1);
        
//         return canPartitionMemoizationUtil(N-1, nums, target, dp);
        
        return canPartitionTabulationUtil(N, nums, target);
    }
}