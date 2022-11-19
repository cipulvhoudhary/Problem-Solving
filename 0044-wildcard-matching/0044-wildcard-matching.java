class Solution {
    
    private boolean isMatchUtil(int lenS, int lenP, String s, String p, int[][] dp) {
        // Base - case
        if(lenS ==  0 && lenP == 0) return true;
        if(lenP == 0) return false;
        if(lenS == 0) {
            if(p.charAt(lenP-1) == '*') {
                return isMatchUtil(lenS, lenP-1, s, p, dp); 
            }
            return false;
        }
        
        // Main - logic
        if(dp[lenS][lenP] == -1) {
            if(p.charAt(lenP-1) == '?' || s.charAt(lenS-1) == p.charAt(lenP-1)) {
                dp[lenS][lenP] = (isMatchUtil(lenS-1, lenP-1, s, p, dp) ? 1 : 0);
            }
            else if(p.charAt(lenP-1) == '*') {
                dp[lenS][lenP] = ((isMatchUtil(lenS, lenP-1, s, p, dp) || isMatchUtil(lenS-1, lenP, s, p, dp)) ? 1 : 0);
            }
            else {
                dp[lenS][lenP] = 0;
            }
        }
        return ((dp[lenS][lenP]==1) ? true : false); 
    }
    
    public boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        
        int[][] dp = new int[lenS+1][lenP+1];
        for(int[] row : dp)  Arrays.fill(row, -1);
        
        return isMatchUtil(lenS, lenP, s, p, dp);
    }
}