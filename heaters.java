class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || heaters == null){
             return Integer.MAX_VALUE;
        }
           
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for(int i=0; i<houses.length; i++){
            int radius = findRadiusBetweenHouse(houses[i], heaters);
            result = Math.max(radius, result);
        }
        return result;
    }
    
    private int findRadiusBetweenHouse(int house, int[] heaters){
        int low = 0;
        int high=heaters.length-1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE ;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            int currentHeater = heaters[mid];
            if(currentHeater == house){
                return 0;
            }
            else if(currentHeater>house){
                right = currentHeater-house;
                high = mid-1;
            } else{
                left = house-currentHeater;
                low = mid+1;
            }
        }
        
        return  Math.min(left, right);
    }
}
