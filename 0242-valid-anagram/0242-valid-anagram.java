class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) 
            return false;
        
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        
        for(int i=0; i<n; i++) {
            char key = s.charAt(i);
            
            if(!map.containsKey(key))
               return false;
            
            int count = map.get(key);
            
            if(count == 1) {
                map.remove(key);
            }
            else {
                map.put(key, count-1);
            }
        }
        return true;
    }
}