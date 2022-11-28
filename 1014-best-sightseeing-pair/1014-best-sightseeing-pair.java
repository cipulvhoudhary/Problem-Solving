class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int N = values.length;
        
        /* Approach 1 --> TLE
        TC --> O(N^2) || SC --> O(1)
        int maxScore = Integer.MIN_VALUE;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                int score = values[i] + values[j] + i - j;
                maxScore = Math.max(maxScore, score);
            }
        }
        return maxScore;
        */
        
        /* Approach 2 
        // Score = values[i] + values[j] + i - j
        //         (values[i] + i) + (values[j] - j)
        // for every i, we know values[i] + i
        // if we somehow compute values[j] - j --> for every j > i, 
        // and get the maximum of values[j] - j after i, we can just add them to get the score
        
        int[] num1 = new int[N]; // represent : values[i] + i
        int[] num2 = new int[N]; // represent : values[j] - j
        for(int i=0; i<N; i++) {
            num1[i] = values[i] + i;
            num2[i] = values[i] - i;
        }
        
        int[] rMax = new int[N];
        rMax[N-1] = num2[N-1];
        for(int i=N-2; i>=0; i--) {
            rMax[i] = Math.max(rMax[i+1], num2[i]);
        }
        
        int maxScore = Integer.MIN_VALUE;
        for(int i=0; i<N-1; i++) {
            int score = num1[i] + rMax[i+1];
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
        */
        
        // Approach - 3
        // TC --> O(N) || SC --> O(1)
        int maxScore = Integer.MIN_VALUE;
        int rMax = values[N-1] - (N-1);
        
        for(int i=N-2; i>=0; i--) {
            int score = values[i] + i + rMax;
            maxScore = Math.max(maxScore, score);
            
            int otherHalf = values[i] - i; // values[j] - j
            rMax = Math.max(rMax, otherHalf);
        }
        return maxScore;
    }
}