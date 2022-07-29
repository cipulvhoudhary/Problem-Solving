class Solution {
    
    private int getIndexOfTarget(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < target) {
                low = mid + 1;
            } 
            else if(arr[mid] > target) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    
    public boolean checkIfExist(int[] arr) {
        /* Approach - 1
        - TC --> O(N) || SC --> O(N)
        - for every element, check if 2*element or element/2 is present in set
        - if present --> return true. Pair found!
        - else there is no pair in the array with such characteristics
        */
        /*
        HashSet<Integer> set = new HashSet<>();
        for(int e : arr) {
            if(set.contains(2*e) || (e%2 == 0 && set.contains(e>>1))) {
                return true;
            }
            set.add(e);
        }
        return false;
        */
        
        /* Approach - 2
        - TC --> O(NlogN) + O(NlogN) || SC --> O(1)
        - Sort the array
        - for every element at ind i, search if 2*arr[i] is present in search space [0, N-1], get the index
        */
        
        int N = arr.length;
        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
            int target = 2 * arr[i];
            int ind = getIndexOfTarget(arr, target);
            if(ind != -1 && ind != i) { // If index is present and is not same index as i
                return true;
            }
        }
        return false;
    }
}