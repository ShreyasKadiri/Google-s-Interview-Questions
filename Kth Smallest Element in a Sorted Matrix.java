class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix.length-1];
        while(low < high){
            int mid = low + (high - low)/2;
            int placement = findSmallerElementsThanMid(matrix, mid);
            if(placement < k){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
    
    public int findSmallerElementsThanMid(int matrix[][], int mid){
        int count = 0;
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j<matrix.length){
            if(matrix[i][j] > mid){
                i--;
            }else {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }
}
