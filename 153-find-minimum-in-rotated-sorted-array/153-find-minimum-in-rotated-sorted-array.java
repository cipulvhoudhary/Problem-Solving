class Solution {
    /* Approach
    - TC --> O(logN) || SC --> O(1)
    - Just finding the pivot index will do the job.
    - Zeroing down approach
    - If middle element is greater than or equal to first element, 
    - ... that mean arr[first index element ... middle index is already sorted] 
    - ... so the minimum answer can never be in this range or it will be the first index itself, 
    - ... therefore starting ans with 0 th index
    - If element at bmiddle index is less, that means the middle element will definately be present in right half
    - ...discard left half ans make search in right half
    */
    public int findMin(int[] nums) {
        //retrun the pivot element 
        int ans = 0, N = nums.length;
        int low = 0, high = N-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= nums[0]) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return nums[ans];
    }
}