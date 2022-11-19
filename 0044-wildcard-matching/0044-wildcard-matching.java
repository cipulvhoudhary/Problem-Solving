class Solution {
    
    private boolean isMatchMemoization(int lenS, int lenP, String s, String p, int[][] dp) {
        // Base - case
        if(lenS ==  0 && lenP == 0) return true;
        if(lenP == 0) return false;
        if(lenS == 0) {
            if(p.charAt(lenP-1) == '*') {
                return isMatchMemoization(lenS, lenP-1, s, p, dp); 
            }
            return false;
        }
        
        // Main - logic
        if(dp[lenS][lenP] == -1) {
            if(p.charAt(lenP-1) == '?' || s.charAt(lenS-1) == p.charAt(lenP-1)) {
                dp[lenS][lenP] = (isMatchMemoization(lenS-1, lenP-1, s, p, dp) ? 1 : 0);
            }
            else if(p.charAt(lenP-1) == '*') {
                dp[lenS][lenP] = ((isMatchMemoization(lenS, lenP-1, s, p, dp) || isMatchMemoization(lenS-1, lenP, s, p, dp)) ? 1 : 0);
            }
            else {
                dp[lenS][lenP] = 0;
            }
        }
        return ((dp[lenS][lenP]==1) ? true : false); 
    }
    
    private boolean isMatchTabulation(String s, String p) {
        int lengthS = s.length(), lengthP = p.length();
        int[][] dp = new int[lengthS+1][lengthP+1];
        
        // Base - case
        dp[0][0] = 1;
        for(int lenP=1; lenP<=lengthP; lenP++) {
            if(p.charAt(lenP-1) == '*') {
                dp[0][lenP] = dp[0][lenP-1];
            }
        }
        
        // Main - logic
        for(int lenS=1; lenS<=lengthS; lenS++) {
            for(int lenP=1; lenP<=lengthP; lenP++) {
                if(p.charAt(lenP-1) == '?' || s.charAt(lenS-1) == p.charAt(lenP-1)) {
                    dp[lenS][lenP] = dp[lenS-1][lenP-1];
                }
                else if(p.charAt(lenP-1) == '*') {
                    dp[lenS][lenP] = ((dp[lenS][lenP-1]) | (dp[lenS-1][lenP]));
                }
                else {
                    dp[lenS][lenP] = 0;
                }
            }
        }
        return ((dp[lengthS][lengthP]==1) ? true : false);
    }
    
    public boolean isMatch(String s, String p) {
//         int lenS = s.length(), lenP = p.length();
        
//         int[][] dp = new int[lenS+1][lenP+1];
//         for(int[] row : dp)  Arrays.fill(row, -1);
        
//         return isMatchMemoization(lenS, lenP, s, p, dp);
        
        return isMatchTabulation(s, p);
    }
}