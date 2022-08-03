class Solution {
    /* Approach 
    - Application of House Robber 1
    - Apply hr1(0, n-2) and hr(1, n-1) 
    - Since 1st and last house are connected here
    */
    
    // House robber 1 :: TC --> O(N) || SC -- O(1)
    private int houseRobberSpaceOptimized(int[] nums, int start, int end) {
        //Base - case
        if(start == end) return nums[start];
        int N = end - start + 1;
        if(N == 1) return nums[start];
        if(N == 2) return Math.max(nums[start], nums[start+1]);
        
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start], nums[start+1]);
        int curr = 0;
        for(int i=start+2; i<=end; i++) {
            curr = Math.max(nums[i]+prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
    
    public int rob(int[] nums) {
        
        //Base - case
        if(nums.length == 1) return nums[0];     
        
        int x = houseRobberSpaceOptimized(nums, 0, nums.length-2);  
        int y = houseRobberSpaceOptimized(nums, 1, nums.length-1);
        return Math.max(x, y);
    }
    
}