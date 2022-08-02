class Solution {
    private int countLessThanEqualToMid(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        
        while(low <= high) {
            int mid = (low + high) >> 1;
            
            if(arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        //TC --> O(log(Range)*N*LogN)
        int N = matrix.length;
        int low = matrix[0][0], high = matrix[N-1][N-1];
        //Range --> high - low
        while(low <= high) {
            int mid = (low + high) >> 1;
            
            int count = 0, lastRowCount = count;
            for(int row=0; row<N; row++) { //O(N*logN)
                //since last row has no ele greater than mid, so it is sure that next row will have 0 elementn 
                if(row != 0 && lastRowCount == 0) break; 
                
                int cRow= countLessThanEqualToMid(matrix[row], mid); //O(logN)
                lastRowCount = cRow;
                count += cRow;
            }
            
            if(count < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}