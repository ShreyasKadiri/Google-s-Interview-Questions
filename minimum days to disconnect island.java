class Solution {
    public int minDays(int[][] grid) {
        if(countIslands(grid)!=1){
            return 0;
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(countIslands(grid)!=1){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
            
    return 2;
    }
    
    
    
     private int countIslands(int [][]grid){
        int numberOfIslands=0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    numberOfIslands++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return numberOfIslands;
    }
    
    public void dfs(int grid[][], int i, int j, boolean visited[][]){
    if(i<0 || j<0 || i==grid.length || j==grid[0].length || visited[i][j] || grid[i][j]==0){
            return ;
        }
            visited[i][j] = true;
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i, j+1, visited);
        
        return ;
    }
}
