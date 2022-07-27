class Solution {
    private int getPivot(int[] nums) { //TC --> O(logN) || SC --> O(1)
        int N = nums.length;
        int low = 0, high = N-1;
        int pivot = 0;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] >= nums[0]) {
                low = mid + 1;
            }
            else {
                pivot = mid;
                high = mid - 1;
            }
        }
        return pivot;
    }
    
    private int searchUtil(int[] nums, int target, int low, int high) { //TC --> O(logN) || SC --> O(1)
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return-1;
    }
    private int searchHelper(int[] nums, int target) {
        int N = nums.length;
        
        int low = 0, high = N-1;
        while(low <= high) {
            int mid =  (low + high) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            //left portion is sorted
            if(nums[mid] >= nums[low]) {
                //check if element might liest in the left half
                if(target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            
            //right portion is sorted
            else {
                //check if target lies in right portion (which will eventually be sorted)
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        /* Approach - 1
        - Find the pivot point (point from which the elements are rotated)
        - two half will be there --> [0, pivot-1] && [pivot, N-1]
        - according possible occurence in the two half, apply binary search for target
        //TC --> O(logN) || SC --> O(1)
        */
        
//         if(nums[0] == target) {
//             return 0;
//         }
        
//         int N = nums.length;
//         int pivot = getPivot(nums);
        
//         if(target > nums[0] && pivot != 0) {
//             return searchUtil(nums, target, 0, pivot-1);
//         }
//         else {
//             return searchUtil(nums, target, pivot, N-1);
//         }
        
        /* Approach - 2
        - Simple binary search template 
        - if left half is sorted and target (might)belongs to [low, mid] --> discard right half
        - else discard left half
        - TC --> O(logN) || SC --> O(1)
        */
        return searchHelper(nums, target);
    }
}