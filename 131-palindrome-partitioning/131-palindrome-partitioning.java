class Solution {
    
    private boolean isPalindrome(String str, int s, int e) {
        while(s < e) {
            if(str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    
    private void partitionUtil(int ind, String s, List<String> list, List<List<String>> res) {
        if(ind == s.length()) {
            List<String> clone = new ArrayList<>(list);
            res.add(clone);
            return;
        }
        
        for(int i=ind; i<s.length(); i++) {
            if(isPalindrome(s, ind, i)) {
                list.add(s.substring(ind, i+1));
                partitionUtil(i+1, s, list, res);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partitionUtil(0, s, list, res);
        return res;
    }
    
}