class Pair {
    int soldier;
    int ind;
    public Pair(int soldier, int ind) {
        this.soldier = soldier;
        this.ind = ind;
    }
}

class SortByWeakness implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if(p1.soldier == p2.soldier) {
            return p1.ind - p2.ind;
        }
        return p1.soldier - p2.soldier;
    }
}

class Solution {
    // This function will return the number of soldier present in a given row
    private int getTotalSoldierInRow(int[][] mat, int row) {
        // Basically find first index of civilian --> no of soldier in that row
        int low = 0, high = mat[0].length-1;
        int count = mat[0].length;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(mat[row][mid] == 1) {
                low = mid + 1;
            }
            else {
                count = mid;
                high = mid - 1;
            }
        }
        return count;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        /* Approach -
        - TC --> O(max(NlogM, NlogN)) || SC --> O(N)
        - Add all the soldier and index in a list
        - Use binary search to get all the soldier in a row
        - Sort the list w.r.t weakness according to problem statement in increasing order
        - Return the index of first k Pair in an array
        */
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0; i<mat.length; i++) {
            //row --> i
            int soldiers = getTotalSoldierInRow(mat, i); // TC --> O(logM) || M --> no of columns
            list.add(new Pair(soldiers, i));
        }
        
        Collections.sort(list, new SortByWeakness()); // TC --> O(N * logN)
        
        int[] ans = new int[k];
        int in = 0;
        for(int i=0; i<k; i++) { // TC--> O(K)
            ans[in++] = list.get(i).ind;
        }
        return ans;
    }
    
}