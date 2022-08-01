class Solution {
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
    public int removeElement(int[] nums, int val) {
        int i=0, j=nums.length;
        while(i < j) {
            if(nums[i] == val) {
                --j;
                swap(nums, i, j);
            }
            else {
                i++;
            }
        }
        return i;
    }
}