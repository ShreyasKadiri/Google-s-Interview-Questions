class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> filteredRestaurants = new ArrayList<Integer>();
    
        //Sort with respect to id's from highest to lowest, if the ratings are same
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(  (a,b) -> b[1] == a[1]? b[0] - a[0]: b[1]-a[1] );
        
        
        for(int i=0; i<restaurants.length; i++){
            
            //For parameter veganfriendly
            if(veganFriendly == 1){
                //Gather the veganFriendly parameter from every ith item of array
                if(veganFriendly!= restaurants[i][2])
                    continue;
            }
            
            //For parameter maxPrice and maxDistance
            if(maxPrice >= restaurants[i][3] && maxDistance>=restaurants[i][4]){
                maxHeap.offer(restaurants[i]);
            }
        }
            
            while(!maxHeap.isEmpty()){
                filteredRestaurants.add(maxHeap.poll()[0]);
            }   
        return filteredRestaurants;
    }
}
