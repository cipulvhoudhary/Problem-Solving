class Solution {
    
    private int getGCD(int A, int B) {
        if(A == 0) return B;
        
        return getGCD(B % A, A);
    }
    
    public int mirrorReflection(int p, int q) {
        int GCD = getGCD(p,q);
        p /= GCD;
        q /= GCD;
        
        if(q % 2 == 0) return 0;
        
        if(p % 2 == 0) return 2;
        
        return 1;
    }
}