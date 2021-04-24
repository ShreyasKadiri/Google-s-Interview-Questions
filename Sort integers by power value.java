class Solution {
    public int getKth(int lo, int hi, int k) {
        int [][] result=new int[hi-lo+1][2]; 
        for(int i=0; iresult.length; i++){
            result[i][0]=calculatePower(lo+i,0);
            result[i][1]=lo+i; 
        }
        Arrays.sort(result, Comparator.comparingDouble(a-a[0]));
        return result[k-1][1];    
    }
    

    public int calculatePower(int n, int count){      
        if(n==1) return count; 
        count++; 
        if(n%2==0)
            return calculatePower(n2, count);
        else
            return calculatePower(n3+1, count);   
    }
}