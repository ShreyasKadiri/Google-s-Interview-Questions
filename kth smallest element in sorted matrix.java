class Solution {
   public int kthSmallest(int[][] matrix, int k) {
   int low=matrix[0][0];
   int high=matrix[matrix.length-1][matrix.length-1];
    while (low<=high) {
        int mid=low+(high-low)/2;
        int count=0;
        int c=matrix[0].length-1; 
        for(int i=0; i<matrix.length; i++) {
            while(c>=0 && matrix[i][c] > mid) 
                c--; 
            count+=(c+1);
        }
        if(count<k) 
            low=mid+1;
        else
            high=mid-1;
    }
    return low;
}
}
