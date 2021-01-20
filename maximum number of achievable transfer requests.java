//DFS Solution
class Solution {
    int maximum = 0;
    public int maximumRequests(int n, int[][] requests) {
     dfs(requests, 0, new int[n], 0);
        return maximum;
    }
    
    public void dfs(int requests[][], int index, int count[], int value){
        //See if all the buildings are balanced i.e if they are zero
        if(index==requests.length){
            for(int i=0; i<count.length; i++){
                if(i!=0){
                    return ;
                }
            }
            maximum = Math.max(maximum,value);
        }
        
        //choosing the requests
        
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        dfs(requests, index+,count,value+1);
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        
        //Not choosing the requests
        dfs(requests, index+1, count, value);
    }
}
