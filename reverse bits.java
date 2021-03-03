public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        for(int i=0; i<32; i++){
            reverse <<= 1;
            reverse  |= (n & 1);
            n >>= 1;
        }
        return reverse;
    }
}
