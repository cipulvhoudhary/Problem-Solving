class Solution {
    private int getFirstOccurence(int ind, int[] nums) {
        if(nums[ind-1] == nums[ind]) {
            return ind-1;
        }
        return ind;
    }
    
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        if(N == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[N-1] != nums[N-2]) return nums[N-1];
        
        int low=1, high=N-2;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            
            //check for single num
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            
            int firstOccurence = getFirstOccurence(mid, nums);
            if(firstOccurence % 2 == 0) {
                //firstOccurence is at even index => single number is on right
                low = mid + 1;
            }
            else {
                //firstOccurence is at odd index => single number is on left
                high = mid - 1;
            }
        }
        return -1;
    }
}