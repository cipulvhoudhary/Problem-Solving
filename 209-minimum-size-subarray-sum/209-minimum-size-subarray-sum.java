class Solution {
    /* Approach 
    - TC --> O(N * logN)|| SC --> O(N)
    - Build a prefix array, this way a sorted array will be formed
    - Now for every element i, in prefex sum, if we find the index j of (ps[i] - target) 
    - ... tnen sum from [j+1 ... i] == target. Length = i - j. Return min length
    - Since prefix sum array is sorted, we can perfrom binaryu search
    */
    
    //This function will return the index of newTarget in prefixSum[] if present, or will retrun teh lower bound
    private int getNewTargetIndex(int[] prefixSum, int newTarget, int low, int high) {
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(prefixSum[mid] == newTarget) {
                return mid;
            }
            else if(prefixSum[mid] < newTarget) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    public int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
        int minL = Integer.MAX_VALUE;
        // Building prefix sum array
        int[] prefixSum = new int[N];
        prefixSum[0] = nums[0];        
        for(int i=1; i<N; i++) { //O(N)
            //check if any element is equal to target 
            if(nums[i] == target) return 1;
            
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        
        //O(N * logN)
        for(int i=0; i<N; i++) { 
            if(prefixSum[i] >= target) {
                minL = Math.min(minL, i+1); //Edge-case 2
            }
            int newTarget = prefixSum[i] - target; 
            if(newTarget > 0) {
                int j = getNewTargetIndex(prefixSum, newTarget, 0, N-1);
                if(j != -1 && j < i) { // new target is present in range [0 ... i-1]
                    minL = Math.min(minL, i-j);
                }
            }
        }
        
        if(minL != Integer.MAX_VALUE) return minL;
        return 0;
    }
    
}