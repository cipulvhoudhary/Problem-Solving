class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        int i = 0;
        while(i < N-2) {
            int target = 0 - nums[i];
            
            int j=i+1, k=N-1;
            
            while(j < k) {
                
                int twoSum = nums[j] + nums[k];
                
                if(twoSum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triplets.add(triplet);
                    j++;
                    k--;
                    
                    while(j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while(k > j && nums[k] == nums[k+1]) {
                        k--;
                    }
                    
                }
                else if(twoSum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
            i++;
            while(i < N && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return triplets;
    }
}