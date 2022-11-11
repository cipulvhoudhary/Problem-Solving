class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int j = 0;
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                while(s.charAt(j) != s.charAt(i)) {
                    set.remove(s.charAt(j));
                    j++;
                }
                j++;
                set.remove(s.charAt(i));
            }
            set.add(s.charAt(i));
            int len = i-j+1;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
    
}





//         Error :: TLE

//         if(s.length() == 0) return 0;      
//         int len = s.length();
//         for(int i=len; i>=2; i--) {
//             for(int j=0; j<len-i+1; j++) {
//                 HashSet<Character> set = new HashSet<>();
//                 for(int k=j; k<j+i; k++) {
//                     if(set.contains(s.charAt(k))) {
//                         k = j+i;
//                     }
//                     else {
//                         set.add(s.charAt(k));
//                     }
//                 }
//                 if(set.size() == i) return i;
//             }
//         }
//         return 1;
