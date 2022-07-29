class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*Approach - 1
        - TC --> O(max(N, M)) || SC --> O(M) || N, M are length of nums1 and nums2 respectively
        - Store elements of nums2 in a map :: key--> nums2[i], value --> freq of nums2[i]
        - Iterate over nums1, check if nums1[i] is present in map
        - if present insert it into res list and reduce the freq of nums1[i]
        */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : nums2) {
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int e : nums1) {
            if(map.containsKey(e)) {
                int val = map.get(e);
                if(val == 1) {
                    map.remove(e);
                }
                else {
                    map.put(e, val-1);
                }
                list.add(e);
            }
        }
        
        int[] res = new int[list.size()];
        int in = 0;
        for(int e : list) {
            res[in++] = e;
        }
        return res;
    }
}