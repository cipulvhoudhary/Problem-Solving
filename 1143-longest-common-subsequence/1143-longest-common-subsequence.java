class Solution {
    
    private int longestCommonSubsequenceUtil(int l1, int l2, String text1, String text2, int[][] dp) {
        // Base - case
        if(l1 == 0 && l2 == 0) {
            return (text1.charAt(l1) == text2.charAt(l2)) ? 1 : 0;
        }
        if(l1 == 0) return (text1.charAt(l1) == text2.charAt(l2)) ? 1 : longestCommonSubsequenceUtil(l1, l2-1, text1, text2, dp);
        if(l2 == 0) return (text1.charAt(l1) == text2.charAt(l2)) ? 1 : longestCommonSubsequenceUtil(l1-1, l2, text1, text2, dp);
        
        // Main - logic
        if(dp[l1][l2] == -1) {
            if(text1.charAt(l1) == text2.charAt(l2)) {
                return 1 + longestCommonSubsequenceUtil(l1-1, l2-1, text1, text2, dp);
            }
            else {
                dp[l1][l2] = Math.max(longestCommonSubsequenceUtil(l1, l2-1, text1, text2, dp), longestCommonSubsequenceUtil(l1-1, l2, text1, text2, dp));
            }
        }
        return dp[l1][l2];
    }
    
    private int longestCommonSubsequenceTabulation(int l1, int l2, String text1, String text2) {
        int[][] dp = new int[l1][l2];
        
        dp[0][0] = (text1.charAt(0) == text2.charAt(0)) ? 1 : 0;
        
        
        for(int j=1; j<l2; j++) { // filling first row
            dp[0][j] = (text1.charAt(0) == text2.charAt(j)) ? 1 : dp[0][j-1];
        }
        
        for(int i=1; i<l1; i++) { // filling first col
            dp[i][0] = (text1.charAt(i) == text2.charAt(0)) ? 1 : dp[i-1][0];
        }
        
        for(int i=1; i<l1; i++) {
            for(int j=1; j<l2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[l1-1][l2-1];
    }
    
    private int longestCommonSubsequenceSpaceOptimized(int l1, int l2, String text1, String text2) {
        int[] dp = new int[l2];
        
        dp[0] = (text1.charAt(0) == text2.charAt(0)) ? 1 : 0;
        
        
        for(int j=1; j<l2; j++) { // filling first row
            dp[j] = (text1.charAt(0) == text2.charAt(j)) ? 1 : dp[j-1];
        }
        
        
        for(int i=1; i<l1; i++) {
            
            int[] temp = new int[l2];
            temp[0] = (text1.charAt(i) == text2.charAt(0)) ? 1 : dp[0];
            
            int left = temp[0];
            
            for(int j=1; j<l2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    temp[j] = 1 + dp[j-1];
                }
                else {
                    temp[j] = Math.max(left, dp[j]);
                }
                left = dp[j];
            }
            dp = temp;
        }
        return dp[l2-1];
    }
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        
        // Mmeoization
//         int[][] dp = new int[l1][l2];
//         for(int[] row : dp) Arrays.fill(row, -1);
        
//         return longestCommonSubsequenceUtil(l1-1, l2-1, text1, text2, dp);
        
        // Tabulation
        // return longestCommonSubsequenceTabulation(l1, l2, text1, text2);
        
        // Space optimized 
        return longestCommonSubsequenceTabulation(l1, l2, text1, text2);
    }
    
}
