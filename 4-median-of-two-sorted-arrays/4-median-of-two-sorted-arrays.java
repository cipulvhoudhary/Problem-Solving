class Solution {
    // TC --> O(log(n + m)) || SC --> O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n  = nums1.length, m = nums2.length; 
        if(m < n) return findMedianSortedArrays(nums2, nums1);
        int noOfEle = n + m;
        int half = (noOfEle + 1) / 2;
        
        int low = 0, high = n;
        while(low <= high) {
            //cut1 is the partition in nums1[]. No of elements pick from nums1
            int cut1 = (low + high)>>1;
            //cut2 is the partition in nums2[]. No of elements pick from nums2
            int cut2 = half - cut1;
            
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1]; //if no ele is picked from nums1[], we take l1 as -infinity
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1]; //if no ele is picked from nums2[], we take l2 as -infinity
            
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];  //if all ele is picked from nums1[], we take r1 as +infinity
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];  //if all ele is picked from nums1[], we take r2 as +infinity
            
            
            //sincle array is sorted.
            if(l1 <= r2 && l2 <= r1) {
                if((noOfEle)%2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1, r2))/2.0;
                }
                else {
                    return Math.max(l1, l2);
                }
            }
            //We have to reduce the count of ele picked from nums2 --> we have to increase count from nums1
            else if(l2 > r1) {
                low = cut1 + 1;
            }
            //We have to reduce the count of ele picked from nums1 --> we have to increase count from nums2
            else if(l1 > r2) {
                high = cut1 - 1; 
            }
        }
        return 0;
    }
}