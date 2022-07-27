class Solution {
    public int mySqrt(int x) {
        
        long low = 0, high = x;
        int ans = -1;
        while(low <= high) {
            long mid = low + (high - low)/2;
            
            long sq = mid * mid;
            if(sq <= (long)x) {
                ans = (int)mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}