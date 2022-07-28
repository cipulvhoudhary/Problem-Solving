class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        /* Approach :: 
        - TC --> O(logN) || SC --> O(1)
        - use simple binary search template to find the mid element
        - leave first and last element as per question that there must be a mountain
        - if middle element satisfies mountain condition --> return index of mid
        - if a,b,c is monotonously increasing, we can discard left half, as potential answer will never lie in the left portion
        - if a,b,c is monotonously decreasing, we can discard right half, as potential answer will never lie in the right portion
        */
        int N = arr.length;
        int low = 1, high = N-2; 
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            //As per question
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            
            //If the *mid-1 > *mid > *mid+1 :: potential answer will be on left portion of the array
            if(arr[mid] < arr[mid-1]) {
                high = mid - 1;
            }
            
            //If the *mid-1 < *mid < *mid+1 :: potential answer will be on right portion of the array
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
