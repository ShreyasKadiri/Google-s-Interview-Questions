import java.math.BigInteger;
class Solution{
    public BigInteger findLargeFactorial(int n){
        BigInteger factorial = BigInteger.ONE;
        for(int i=n; i>=2; i--){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
