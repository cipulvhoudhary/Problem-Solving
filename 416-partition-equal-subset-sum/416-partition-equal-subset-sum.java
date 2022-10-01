class Solution {
    
    private boolean subsetSumUtil(int ind, int target, int[] nums, int[][] dp) {
        // Base - case
        if(target == 0) return true;
        if(ind < 0) return false;
        // if(ind == 0) return (nums[ind] == target);
        
        if(dp[ind][target] == -1) {
            boolean notTake = subsetSumUtil(ind-1, target, nums, dp);
            boolean take = false;
            if(nums[ind] <= target) {
                take = subsetSumUtil(ind-1, target-nums[ind], nums, dp);
            }
            dp[ind][target] = (notTake || take) ? 1 : 0;
        }
        return dp[ind][target] == 1 ? true : false;
    }
    
    
//     private boolean subsetSumTabulationUtil(int N, int target, int[] nums) {
//         boolean[][] dp = new boolean[N][target+1];
        
//         // Base - case
//         for(int ind=0, ind<N; ind++) {
//             dp[ind][0] = true;
//         }
        
//     }
    
    public boolean canPartition(int[] nums) {
        
        int totalSum = 0;
        for(int e : nums) totalSum += e;
        
        // Edge - case :: totalSum must be even
        if(totalSum%2 != 0) return false;
        
        int N = nums.length-1;
        int target = totalSum/2;
        
        int[][] dp = new int[N][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return subsetSumUtil(N-1, target, nums, dp);
        
    }
}