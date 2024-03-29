class Solution {
    
    private int deleteAndEarnUtil(int ind, int[] points, int[] dp) {
        // Base - case
        if(ind == 0) return points[0]; // in case of single element
        if(ind == 1) return Math.max(points[0], points[1]); // in case of double element
        
        // Main - logic 
        if(dp[ind] == -1) {
            int notDeleted = 0 + deleteAndEarnUtil(ind-1, points, dp);
            int deleted = points[ind] + deleteAndEarnUtil(ind-2, points, dp);

            dp[ind] = Math.max(notDeleted, deleted);
        }
        return dp[ind];
    }
    
    public int deleteAndEarn(int[] nums) {
        /*
        Similar to house robber 1 
        - Conversion to house robber 1
        - if we take a frequency array, to store the number of occurnces of each element,
        ex -->  [2,2,3,3,3,4] || 
        index -- 0 1 2 3 4
        freq  -- 0 0 2 3 1
        Here, if we take 3 once 3 --> earning will be 3 + f([3, 3])
        again, ---------------- 3 --> --------------- 3 + f([3])
        again, ---------------- 3 --> --------------- 3 + f([]) = 3
        total --> 3 + 3 + 3 = 9
        
        Basically, we can not delete the occurnce of taking that number, 
        we can only delete (3-1) || (3+1) occurence's
        Once we decide that we want a num, we can add all the occurrences of num into the total.
        
        now, ex -->  [2,2,3,3,3,4] || 
                                 index -- 0 1 2 3 4
                                 freq  -- 0 0 2 3 1
             maxPointsEarnedPerElement -- 0 0 4 9 4 
             
        Just pass maxPointsEarnedPerElement into houseRobber1 function 
        */
        
        int[] freq = new int[2*10000 + 1];
        int N = nums.length;
        for(int i=0; i<N; i++) {
            freq[nums[i]]++;
        }
        
        // converting freq array to Points array
        for(int i=0; i<freq.length; i++) {
            freq[i] = i*freq[i];
        }
        
        // changing the reference for better readability
        int[] points = freq;
        
        int[] dp = new int[2*10000+1];
        Arrays.fill(dp, -1);
        
        return deleteAndEarnUtil(freq.length-1, points, dp);
    }
}