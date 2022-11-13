class Solution {
    
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
    private int getFirstLetterIndex(int ind, String str) {
        while(ind < str.length()) {
            if(str.charAt(ind) != ' ') {
                return ind;
            }
            ind++;
        }    
        return str.length();
    }
    
    public String reverseWords(String s) {
        String rev = reverse(s);
        
        StringBuilder sb = new StringBuilder();
        
        int i=0;
        while(i < rev.length()) {
            i = getFirstLetterIndex(i, rev);
            if(i >= rev.length()) break;
            
            int j = i;
            
            
            while(j < rev.length() && rev.charAt(j) != ' ') {
                j++;
            }
            
            String word = reverse(rev.substring(i, j));
            sb.append(word);
            sb.append(' ');
            i = j;
        }
        
        int len = sb.length();
        return sb.toString().substring(0, len-1);
    }
}