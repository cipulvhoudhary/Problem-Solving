class Solution {
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public String longestPalindrome(String s) {
        int N = s.length();
        
        if(isPalindrome(s, 0, N-1)) {
            return s;
        }
        
        int maxLen = 1;
        String res = s.substring(0, 1);
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(isPalindrome(s, i, j)) {
                    int length = j-i+1;
                    if(length > maxLen) {
                        res = s.substring(i, j+1);
                        maxLen = length;
                    }
                }
            }
        }
        return res;
    }
}