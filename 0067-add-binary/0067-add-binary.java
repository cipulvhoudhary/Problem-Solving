class Solution {
    // TC --> O(M+N) || SC --> O(M+N)
    // M : length of string1
    // N :: length of string1
    public String addBinary(String a, String b) {
        int i=a.length()-1, j = b.length()-1;
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        
        // Approach -->
        // till any one of the string has some character, it will be considered in the sum
        // Think of it like a basic addition we do perform of decimal number system, but here we have binary
        // sum = a+b
        // if a+b >= 2 , we take mod of (a+b) with 2 (because dealing with binary number system)
        // and place mod value below a and b
        // and take carry as sum / 2
        while(i >= 0 || j >= 0) {
            int sum = carry;
            
            if(i >= 0 && j >= 0) {
                sum += (a.charAt(i)-'0' + b.charAt(j)-'0');
                i--;
                j--;
            }
            else if(i >= 0) {
                sum += (a.charAt(i)-'0');
                i--;
            }
            else {
                sum += (b.charAt(j)-'0');
                j--;
            }
            
            int ch = (sum%2);
            sb.append(ch);
            carry = sum / 2;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}