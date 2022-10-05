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
    
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int e : nums) totalSum += e;
        
        // total sum must be even if need to partitioned equally
        if(totalSum%2 != 0) return false;
        
        int N = nums.length;
        int target = totalSum/2;
        
        int[][] dp = new int[N][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return canPartitionMemoizationUtil(N-1, nums, target, dp);
    }
}