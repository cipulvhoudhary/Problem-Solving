class Solution {
    
    //Function will build maxMin array with minimum and maximum element of nums
    private void getMaxMin(int[] nums, int[] maxMin) { 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int e : nums) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }
        maxMin[0] = min;
        maxMin[1] = max;
    }
    
    //Function will return the count of element larger than mid in nums[]
    private int getLargerCount(int[] nums, int mid) {
        int count = 0;
        for(int e : nums) {
            if(e > mid) count++;
        }
        return count;
    }
    
    public int findKthLargest(int[] nums, int k) {
        /* Approach 
        - TC --> O(N * log(Range)) || SC --> O(1)
        - Kth largest element will be present only between minimu and maximum element of nums[]\
        - So we apply binary search on that range
        - for searching, if count of element greater than (k-1) :: that means, we need a more larger number, so discarding left half
        - else we zero down to the (k-1)th element :: basically store the answer and move left i.e discard right half
        */
        int[] maxMin = new int[2];
        getMaxMin(nums, maxMin); //TC --> O(N)
        
        int low = maxMin[0], high = maxMin[1]; //Range
        int ans = -1;
        while(low <= high) { //TC --> O(log(Range))
            int mid = (low + high) / 2;
            
            int count = getLargerCount(nums, mid); //TC --> O(N)
            
            if(count > k-1) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    
}