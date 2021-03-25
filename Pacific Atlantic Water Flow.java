class Solution {
       public List<int[]> pacificAtlantic(int[][] matrix) {
      List<int[]> result = new ArrayList<>();
      if(matrix.length == 0){
          return result;
      } 
      boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
      boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
           
      int[][] directions = {{-1,1},{1,0},{0,-1},{-1,0}};
    
      for(int i=0; i<matrix.length; i++){
        dfs(matrix, directions, pacific, i,  0);
        dfs(matrix, directions, atlantic, i, matrix[0].length-1);
      }   
      
      for(int i=0; i<matrix[0].length; i++){
        dfs(matrix, directions, pacific, 0,  i);
        dfs(matrix, directions, atlantic, matrix.length-1, i);
      }
      
      for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
          if(pacific[i][j] && atlantic[i][j]) {
              result.add(new int[]{i,j});
          }
        }
      }
      return result;   
    }
    
    void dfs (int[][] matrix, int[][] directions, boolean[][] visited, int i, int j){
      visited[i][j] = true;
      for(int[] direction : directions){
        int X = i + direction[0];
        int Y = j + direction[1];
if(X<0 || Y<0 || X>=matrix.length || Y>=matrix[0].length || visited[X][Y] || matrix[i][j]>matrix[X][Y]){
          continue;
        }
        dfs(matrix, directions, visited, x, y);
      }
    }
}
