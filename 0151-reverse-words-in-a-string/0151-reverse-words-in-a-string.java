class Solution {
    
    private int getFisrstLetterIndex(String str, int ind, int N) {
        while(ind < N && str.charAt(ind) == ' ') {
            ind++;
        }
        return ind;
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    public String reverseWords(String s) {
        int N = s.length();
        String str = reverse(s);
        
        StringBuilder sb = new StringBuilder();
        
        int i=0;
        while(i<N) {
            i = getFisrstLetterIndex(str, i, N);
            if(i == N) break;
            
            int j=i;
            while(j<N && str.charAt(j) != ' ') {
                j++;
            }
            String word = reverse(str.substring(i, j));
            sb.append(word);
            sb.append(" ");
            i = j;
        }
        String res = sb.toString();
        return res.substring(0, res.length()-1);
    }
}