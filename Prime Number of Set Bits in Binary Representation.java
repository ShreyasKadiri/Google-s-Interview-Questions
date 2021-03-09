//Naive --- O(n3)
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i=L; i<=R; i++){
            if(countSetBits(i)) {
                count++;
        }
    }
        return count;
    }
    
    public boolean countSetBits(int n){
        int count =0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        
        //check if the count is prime
        if (count<=1) 
            return false; 
  
        for (int i=2; i<count; i++) 
            if (count%i == 0) 
                return false; 
  
        return true;   
    }
}





class Solution{    
    private boolean isPrime (int n) {
        return n==2 || n==3 || n==5 || n==7 || n==11 || n==13 || n==17 || n==19;
    }
    
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        while (L<=R) {
            if (isPrime(Integer.bitCount (L++))) {
                ++result;
            }
        }
        return result;
    }
}
