class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] lMax = new int[N];
        int[] rMax = new int[N];
        
        lMax[0] = height[0];
        for(int i=1; i<N; i++) {
            lMax[i] = Math.max(height[i], lMax[i-1]);
        }
        
        rMax[N-1] = height[N-1];
        for(int i=N-2; i>=0; i--) {
            rMax[i] = Math.max(height[i], rMax[i+1]);
        }
        
        int trappedWater = 0;
        for(int i=0; i<N; i++) {
            trappedWater += (Math.min(lMax[i], rMax[i]) - height[i]);
        }
        return trappedWater;
    }
}