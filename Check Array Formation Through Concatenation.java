/*
    https://leetcode.com/problems/check-array-formation-through-concatenation/discuss/996434/JAVA-or-~O(n)-1ms-runtime-or-with-Explanation
    */

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
    for(int piece[] : pieces){
        map.put(piece[0], new ArrayList<>());
        for(int i=1; i<piece.length; i++){
            map.get(piece[0]).add(piece[i]);
        }
    }
        
    int index = 0;
        while(index < arr.length){
            if(!map.contains(arr[index])){
                return false;
            }
            
            //Get all the values corresponding to this piece element
            ArrayList<Integer> currentValues = map.get(arr[index++]);
            for(int i=0; i<currentValues.size(); i++){
                if(index>=arr.length || currentValues.get(i)!=arr[index]){
                    return false;
                }
                index++;
            }
            
        }
        return true;
    }
}
