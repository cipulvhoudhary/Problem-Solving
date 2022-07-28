class Solution {
    /* Approach ::
    - TC --> O(logN) || SC --> O(1)
    - get first and last occurence of target using simple binary search template using upper bound and lower bound
    */
    private int getFirstOrLastOccurence(int[] nums, int k, boolean flag) { //flag --> true :: first occurence, else last occurence
        int N = nums.length;
        int low = 0, high = N-1;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < k) {
                low = mid + 1;
            }
            else if(nums[mid] > k) {
                high = mid - 1;
            }
            else {
                ans = mid;
                if(flag) {  //compute first occurence
                    high = mid - 1;
                }
                else { //Computing for last occurence
                    low = mid + 1;
                }
            }
        }
        return ans;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        int first = getFirstOrLastOccurence(nums, target, true);
        if(first == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        
        int last = getFirstOrLastOccurence(nums, target, false);
        
        res[0] = first;
        res[1] = last;
        return res;
    }
}