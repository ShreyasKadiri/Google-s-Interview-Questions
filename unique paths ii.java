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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = onstacleGrid[0].length;
        
        
        int dp[][] = new int[m][n];
        boolean obstacleSeen = false;
        
        
        //Filling in first row
        for(int i=0; i<n; i++){
            if(obstacleSeen || obstacleGrid[0][i]==1){          //Obstacle is indicated by 1
                obstacleSeen = true;
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }
        
        
        obstacleSeen = false;
        //Filling in first column
        for(int i=0; i<m; i++){
            if(obstacleSeen || obstacleGrid[i][0]==1){            //Obstacle is indicated by 1
                obstacleSeen = true;
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }
        
        
        
      //For the rest of the matrix grid
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1){      //If there is an obstacle
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = d[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
