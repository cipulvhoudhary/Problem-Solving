class Solution {
    
    private boolean wordBreakUtil(int i, int j, String s, int N, HashSet<String> dict, int[][] dp) {
        // Base - case
        if(j == N) {
            if(i == N) 
                return true;
            return false;
        }
        
        // Main - logic
        if(dp[i][j] != -1) return (dp[i][j] == 1) ? true : false;
        
        if(dict.contains(s.substring(i, j+1))) {
            if(wordBreakUtil(j+1, j+1, s, N, dict, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }
        boolean res = wordBreakUtil(i, j+1, s, N, dict,dp);
        dp[i][j] = (res) ? 1 : 0;
        return res;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        
        for(String str : wordDict) dict.add(str);
        int N = s.length();
        
        int[][] dp = new int[N][N];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return wordBreakUtil(0, 0, s, N, dict, dp);
    }
}