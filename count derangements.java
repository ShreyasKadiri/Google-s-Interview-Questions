class Solution{
    public int countDerangements(int n) { 
          if(n==1 || n==2) {
            return n-1;
        }
          int first=0;
          int second=1;
       
        for (int i=3; i<=n; ++i) {
            int currentValue= (i-1)*(first+second);
              first=second;
              second= currentValue;
        }
        return second; 
    }
}
//f(n) = (n-1) [f(n-1) + f(n-2)]
