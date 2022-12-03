class Solution {
    
    private void generate(int numRows, List<List<Integer>> outerList) {
        // Base - case
        if(numRows == 1) {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            outerList.add(currList);
            return ;
        }
        
        // Main - logic
        generate(numRows-1, outerList);
        
        List<Integer> prevList = outerList.get(outerList.size()-1);
        
        List<Integer> currList = new ArrayList<>();
        currList.add(1);
        for(int i=0; i<prevList.size()-1; i++) {
            currList.add(prevList.get(i) + prevList.get(i+1));
        }
        currList.add(1);
        outerList.add(currList);
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outerList = new ArrayList<>();
        
        generate(numRows, outerList);
        
        return outerList;
    }
}