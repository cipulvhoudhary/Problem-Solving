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
    
    private List<Integer> getRowSpaceOptimized(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        prevList.add(1);
            
        for(int ri=1; ri<=rowIndex; ri++) {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            for(int i=0; i<prevList.size()-1; i++) {
                currList.add(prevList.get(i) + prevList.get(i+1));
            }
            currList.add(1);
            
            // change reference of currList to prevList
            prevList = currList;
        }
        return prevList;
    }
    
    public List<Integer> getRow(int rowIndex) {    
        // Approach - 1 
        // return getRowUtil(rowIndex);        
        
        // Approach - 2
        return getRowSpaceOptimized(rowIndex);
        
    }
}