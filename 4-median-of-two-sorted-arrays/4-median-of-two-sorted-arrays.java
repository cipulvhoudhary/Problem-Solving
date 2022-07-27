class Solution {
    private void merge(int[] nums1, int[] nums2, int[] merged) {
        int i=0, j=0;
        int in = 0;
        int M = nums1.length, N = nums2.length;
        while(i < M && j < N) {
            if(nums1[i] <= nums2[j]) {
                merged[in++] = nums1[i++];
            }
            else {
                merged[in++] = nums2[j++];
            }
        }
        
        if(i == M) {
            while(j != N) {
                merged[in++] = nums2[j++];
            }
        }
        if(j == N) {
            while(i != M) {
                merged[in++] = nums1[i++];
            }
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        merge(nums1, nums2, merged);
        
        int N = merged.length;
        if(N%2 == 0) {
            double x = merged[(N/2)-1];
            double y = merged[N/2];
            return (x+y) / 2;
        }
        else {
            return merged[N/2];
        }
    }
}