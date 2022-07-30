class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        int low = 0, high = N-1;
        int ans = N;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(letters[mid] > target) {
                high = mid - 1;
            }
            else {
                ans = mid + 1;
                low = mid + 1;
            }
        }
        if(ans == N) {
            return letters[0];
        }
        return letters[ans];
    }
}