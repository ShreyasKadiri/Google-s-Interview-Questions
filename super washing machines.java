class Solution {
    public int findMinMoves(int[] machines) {
       int total = 0;
        for(int i=0; i<machines.length; i++){
            total+=machines[i];
        }
        if(total%machines.length!=0){
            return -1;
        }
        
        int average = total/machines.length;
        int count=0;
        int maximum=0;
        
        for(int i=0; i<machines.length; i++){
            count+=machines[i] - average; 
            maximum = Math.max(maximum, Math.max(Math.abs(count), machines[i]-average));
        }
        return maximum;
    }
}


/*
https://leetcode.com/problems/super-washing-machines/discuss/99185/Super-Short-and-Easy-Java-O(n)-Solution
*/
