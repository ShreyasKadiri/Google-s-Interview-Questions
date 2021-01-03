class FriendsCircle{
    public int countFriendsCircle(char friends[][]){
        if(friends.length==0 || friends==null){
            return 0;
        }
        int totalFriendsCircle=0;
        boolean visited[] = new boolean[friends.length];
        Arrays.fill(visited, false);
        
        for(int i=0; i<friends.length; i++){
            if(!visited[i]){
                visited[i] = true;
                totalFriendsCircle+=1;
                
                checkForFriends(friends, visited, i);
            }
        }
        return totalFriendsCircle;
    }
    
    public void checkForFriends(char friends[][], boolean visited, int id){
        for(int i=0; i<friends.length; i++){
            if(!visited[i] && friends[id][i]=='Y' && i!=id ){
                visited[i]= true;
             checkForFriends(friends, visited, i);   
            }
        }
        return;
    }    
}
