class Solution {
    
    private int longestCommonSubsequence(int l1, int l2, String text1, String text2, int[][] dp) {
        // Base - case
        if(l1 == 0 && l2 == 0) {
            return (text1.charAt(l1) == text2.charAt(l2)) ? 1 : 0;
        }
        if(l1 == 0) return (text1.charAt(l1) == text2.charAt(l2)) ? 1 : longestCommonSubsequence(l1, l2-1, text1, text2, dp);
        if(l2 == 0) return (text1.charAt(l1) == text2.charAt(l2)) ? 1 : longestCommonSubsequence(l1-1, l2, text1, text2, dp);
        
        // Main - logic
        if(dp[l1][l2] == -1) {
            if(text1.charAt(l1) == text2.charAt(l2)) {
                return 1 + longestCommonSubsequence(l1-1, l2-1, text1, text2, dp);
            }
            else {
                dp[l1][l2] = Math.max(longestCommonSubsequence(l1, l2-1, text1, text2, dp), longestCommonSubsequence(l1-1, l2, text1, text2, dp));
            }
        }
        return dp[l1][l2];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        
        int[][] dp = new int[l1][l2];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return longestCommonSubsequence(l1-1, l2-1, text1, text2, dp);
    }
    
}
