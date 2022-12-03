class Solution {
    
    private List<Integer> getRowUtil(int rowIndex) {
        // Base  - case
        if(rowIndex == 0) {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            return currList;
        }
        
        // Main - logic        
        List<Integer> prevList = getRowUtil(rowIndex-1);
        
        List<Integer> currList = new ArrayList<>();
        currList.add(1);
        for(int i=0; i<prevList.size()-1; i++) {
            currList.add(prevList.get(i) + prevList.get(i+1));
        }
        currList.add(1);
        
        return currList;
    }
    
    public List<Integer> getRow(int rowIndex) {        
        List<Integer> res = getRowUtil(rowIndex);
        return res;
    }
}