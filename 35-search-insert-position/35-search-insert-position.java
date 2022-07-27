class Solution {
    /* Approach 
    - Simple binary search template
    - If nums[mid] and target are same return mid
    - if nums[mid] > target --> target will never lie in right portion
    - if nums[mid] < target --> target might lie in left portion, save mid's next index as answer
    - TC --> O(logN) || SC --> O(1)
    */
    public int searchInsert(int[] nums, int target) {
        
        int low = 0, high = nums.length-1;
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                ans = mid + 1;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}