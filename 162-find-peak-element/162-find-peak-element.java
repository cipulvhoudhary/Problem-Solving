class Solution {
    public int findPeakElement(int[] nums) {
        /*Approach
        - TC --> O(logN) || SC --> O(1)
        - If element is a peak element, it will be greater than both its's neighbour
        - If a<b<c --> b(mid) --> chances of getting peak is higher on right portion, so discard left half
        - if a>b>c --> b(mid) --> chances of getting peak is higher on left portion, so discard right half
        */
        int N = nums.length;
        int low = 1, high = N-2;
        while(low <= high) {
            int mid = (low + high) >> 1;
            
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(nums[mid] < nums[mid+1]) {
                // chances of getting peak element is higher in right portion
                low = mid + 1;
            }
            else if(nums[mid] < nums[mid-1]) {
                // chances of getting peak element is higher in left portion
                high = mid - 1;
            }
        }
        //Single element 
        if(N==1) return 0;
        //sincle nums[-1] = -inf = nums[N]
        if(N > 1 && nums[0] > nums[1]) return 0;
        if(N>1 && nums[N-1] > nums[N-2]) return N-1;
        return 0;
    }
}