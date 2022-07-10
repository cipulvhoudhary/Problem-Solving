class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int N = nums.length;
        int maxConsecutive = 0;
        int cons = 0;
        for(int i=0; i<N; i++) {
            if(nums[i] == 1) {
                cons++;
                maxConsecutive = Math.max(maxConsecutive, cons);
            }
            else {
                cons = 0;
            }
        }
        return maxConsecutive;
    }
}