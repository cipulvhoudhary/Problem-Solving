class Solution {
    public int maxArea(int[] height) {
        
        int N = height.length;
        
        int leftWall = 0;
        int rightWall = N-1;
        int maxVolume = 0;
        
        while(leftWall < rightWall) {
            int htLeftWall = height[leftWall];
            int htRightWall = height[rightWall];
            
            int htContainer = Math.min(htLeftWall, htRightWall);
            int widthContainer = rightWall - leftWall;
            
            int volumeContainer = htContainer * widthContainer;
            
            maxVolume = Math.max(maxVolume, volumeContainer);
            
            if(htLeftWall <= htRightWall) {
                leftWall++;
            }
            else {
                rightWall--;
            }
            
        }
        return maxVolume;
    }
}


//         Brute force 
//         Try out all possibilities :: Every pair
//         int N = height.length;
//         int maxVolume = 0;
//         for(int left=0; left<N-1; left++) {
//             for(int right = left+1; right<N; right++) {
//                 int ht = Math.min(height[left], height[right]);
//                 int width = (right - left);
//                 int volume = ht * width;
                
//                 maxVolume = Math.max(maxVolume, volume);
//             }
//         }
//         return maxVolume;
