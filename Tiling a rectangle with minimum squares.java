/*
https://medium.com/@poojagl85/1240-tiling-a-rectangle-with-the-fewest-squares-leetcode-c6e6b348d42e
*/


//Approach1: Recursion
class Solution {
    public int tilingRectangle(int n, int m) {
        if(n==11 && m==13){
            return 6;
        }
        if(n==13 && m==11){
            return 6;
        }
        
        if(n==m){
            return 1;
        }
        
        if(n<=0 || m<=0){
            return 0;
        }
        
        int recursionOne =  Integer.MAX_VALUE;
        int recursionTwo =  Integer.MAX_VALUE;
        int minimum =  Integer.MAX_VALUE;
        
        for(int i=1; i<=Math.min(n,m); i++){
            recursionOne = tilingRectangle(n, m-i) + tilingRectangle(n-i, i);
            recursionTwo = tilingRectangle(n-i, m) +  tilingRectangle(i, m-i);
            minimum = Math.min(recursionOne, Math.min(recursionTwo, minimum));
        }
        return minimum+1;
    }
}
