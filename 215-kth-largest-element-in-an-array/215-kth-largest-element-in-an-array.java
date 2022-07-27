class Solution {
    
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
    
    private int getLargerCount(int[] nums, int mid) {
        int count = 0;
        for(int e : nums) {
            if(e > mid) count++;
        }
        return count;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int[] maxMin = new int[2];
        getMaxMin(nums, maxMin);
        
        int low = maxMin[0], high = maxMin[1];
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            
            int count = getLargerCount(nums, mid);
            
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