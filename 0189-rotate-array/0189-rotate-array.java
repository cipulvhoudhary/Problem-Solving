class Solution {
    // This function will reverse the array between index --> [i, j]
    // TC --> O(N) || SC --> O(1)
    private void rotateUtil(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }
    }
    
    // TC --> O(N) || SC --> O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        // rotate entire array
        rotateUtil(nums, 0, n-1);
        // rotate first K elements
        rotateUtil(nums, 0, k-1);
        // rotate first n-k elements
        rotateUtil(nums, k, n-1);
    }
}