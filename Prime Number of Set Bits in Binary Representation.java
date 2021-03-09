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
