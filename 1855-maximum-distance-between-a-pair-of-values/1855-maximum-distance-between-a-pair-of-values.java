class Solution {
    /* Approach - 1
    - TC --> O(N * logM) || SC --> O(1)
    - For each element in nums1, we need to find an element in nums2 for which i < j && nums1[i] <= nums2[j]
    - Distance = j - i, if above two condition met
    - To maximize distance, we need to find j such that j-i is maximum
    - To get maximum, if we somehopw find the last element which is >= nums1[i]. JOB IS DONE
    - Binary search's upper bound will help
    - Search space --> [i, M-1] || i is iterating in nums1 from L->R and M is the length of nums2
    - Now, in the search space find the last element which is >= target(nums1[i]) 
    */
    
    
    // This function return the index of element in nums2 array 
    // which is >= target (element of nums1)
    private int getIndexOfLastGreater(int[] nums2, int target, int low, int high) {
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(target > nums2[mid]) {
                high = mid - 1;
            }
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public int maxDistance(int[] nums1, int[] nums2) {
        int N = nums1.length, M = nums2.length;
        int maxD = 0;
        
//         for(int i=0; i<N; i++) {
//             int low = i;
//             int high = M-1;
//             int j = getIndexOfLastGreater(nums2, nums1[i], low, high);
            
//             if(j != -1) {
//                 maxD = Math.max(maxD, j-i);
//             }
//         }
//         return maxD;
        
        /*Approach 2 
        */
        int i = 0, j = 0;
        while(i < N && j < M) {
            if(j < i) {
                j = i;
                continue;
            }
            
            if(nums1[i] > nums2[j]) {
                ++i;
            }
            else{
                //condition met
                maxD = Math.max(maxD, j-i);
                j++;
            }
        }
        return maxD;
    }
}