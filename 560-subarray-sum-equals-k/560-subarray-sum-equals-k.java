class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = nums.length, count = 0, sum = 0;
        
        for(int i=0; i< N; i++) {
            sum += nums[i];
            
            if(sum ==  k) count++;
            
            int key = sum - k;
            if(map.containsKey(key)){
                count += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}