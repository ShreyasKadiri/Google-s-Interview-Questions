class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
     int maxUnits=0;
        //Sort the array based on second parameter in descending order
        Arrays.sort(boxTypes, (a,b) -> -Integer.compare(a[1],b[1]));
        for(int box[] : boxTypes){
            if(truckSize < box[0]){
                return maxUnits + truckSize*box[1];
            }
            maxUnits+= box[1]*box[0];
            truckSize-=box[0];
        }
        return maxUnits;
    }
}
