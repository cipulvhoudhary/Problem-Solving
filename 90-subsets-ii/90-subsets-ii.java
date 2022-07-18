class Solution {
    
    private void subsetsWithDupUtil(int ind, ArrayList<Integer> subset, int[] nums, List<List<Integer>> uniqueSubsets){
        //Assumption :: subsetsWithDupUtil() --> will build unique subsets
        
        //base - case :: if ind == N(nums.length) --> put the current subset in uniqueSubsets if it is unique
        if(ind == nums.length) {
            ArrayList<Integer> clone = new ArrayList<Integer>(subset);
            if(!uniqueSubsets.contains(clone)) {
                uniqueSubsets.add(clone);
            }
            return;
        }
        
        //Main - logic :: pick and non-pick
        
        //pick element
        subset.add(nums[ind]);
        subsetsWithDupUtil(ind+1, subset, nums, uniqueSubsets);
        
        //non-pick --> just removbe the last element added in subset data structure
        subset.remove(subset.size()-1);
        subsetsWithDupUtil(ind+1, subset, nums, uniqueSubsets);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniqueSubsets = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        subsetsWithDupUtil(0, subset, nums, uniqueSubsets);
        return uniqueSubsets;
    }
    
}