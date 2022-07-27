class Solution {
    public int maxArea(int[] height) {
        int p1 = 0, p2 = height.length-1;
        int maxVol = Integer.MIN_VALUE;
        
        while(p1 < p2) {
            int width = p2 - p1;
            int ht = Math.min(height[p1], height[p2]);
            int vol = width * ht;
            maxVol = Math.max(maxVol, vol);
            
            if(height[p1] <= height[p2]) {
                p1++;
            }
            else {
                p2--;
            }
        }
        return maxVol;
    }
}