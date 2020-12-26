class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        
if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) //base condition
    return false;
        
        int rowIndex = 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int colIndex = n-1;
        
        while(rowIndex < m && colIndex >=0)
        {
        if(matrix[rowIndex][colIndex] == target)        //If the element is found
        return true;
            
    else if(matrix[rowIndex][colIndex] < target)//If the current array element is lesser than target
        rowIndex++;
            
    else if(matrix[rowIndex][colIndex] > target) //If the current array element is greaterr than target
                colIndex--;
        }
        
        return false;
    }
}
