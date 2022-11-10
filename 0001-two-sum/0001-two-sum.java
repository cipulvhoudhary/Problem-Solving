class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        HashMap<Integer, Integer> dict = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            if(dict.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = dict.get(target - nums[i]);
                return res;
            }
            dict.put(nums[i], i);
        }
        return res;
    }
}