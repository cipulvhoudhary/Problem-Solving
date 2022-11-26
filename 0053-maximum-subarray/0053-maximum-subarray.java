class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}