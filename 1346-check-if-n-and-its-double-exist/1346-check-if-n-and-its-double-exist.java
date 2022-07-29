class Solution {
    public boolean checkIfExist(int[] arr) {
        /* Approach 
        - TC --> O(N) || SC --> O(N)
        - for every element, check if 2*element or element/2 is present in set
        - if present --> return true. Pair found!
        - else there is no pair in the array with such characteristics
        */
        HashSet<Integer> set = new HashSet<>();
        for(int e : arr) {
            if(set.contains(2*e) || (e%2 == 0 && set.contains(e>>1))) {
                return true;
            }
            set.add(e);
        }
        return false;
    }
}