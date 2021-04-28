//Recusrive Solution
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int result[][] = new int[grid.length][grid[0].length];
        return solve(result, grid, 0, 0);
    }
    
    public int solve(int result[][], int [][] grid, int i, int j){
        if(i>=grid.length || j>=grid[i].length){
            return 0;
        }
        if(grid[i][j] == 1){
            return 0;
        }
        if(i==grid.length-1 && j==grid[i].length-1){
            return 1;
        }
        if(result[i][j]!=0){
            return result[i][j];
        }
        else{
            result[i][j]= solve(result, grid, i, j+1) + solve(result, grid, i+1, j);
        }
        return result[i][j];
    }
}

//Dp
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int dp[][] = new int[grid.length][grid[0].length];
        boolean visited = false;
    
        for(int i=0; i<grid[0].length; i++){
            if(visited || grid[0][i]==1){          
                visited = true;
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }
        
        visited = false;
        for(int i=0; i<grid.length; i++){
            if(visited || grid[i][0]==1){            
                visited = true;
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }
        
        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                if(grid[i][j]==1){      
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
