class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        
        int temp = Math.abs(x);
        
        while(temp%10 == 0) temp /= 10;
        
        long rev = 0;
        while(temp != 0) {
            int last = temp % 10;
            rev = rev * 10 + last;
            temp /= 10;
        }
        
        if(rev >= Integer.MIN_VALUE && rev <= Integer.MAX_VALUE) {
            return (x < 0) ? -1*(int)rev : (int)rev;
        }
        return 0;
    }
}