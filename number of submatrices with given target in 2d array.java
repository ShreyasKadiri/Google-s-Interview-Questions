class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
    
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] prefixSum = new int[rows+1][columns];
        
        for (int i=0; i<columns; i++) {
            for (int j=0; j<rows; j++) {
                prefixSum[j+1][i] = prefixSum[j][i] + matrix[j][i];
//                preSum[i + 1][j] = preSum[i][j] + matrix[i][j];
            }
        }
        
        int result= 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for (int i=0; i<rows; i++) {
            for (int j=i; j<rows; j++) {
                map.clear();
                int sum = 0;
                for (int k=0; k<cols; col++) {
                    sum += prefixSum[j+1][k] - prefixSum[i][k];
                    
                    if (sum == target) {
                        result++;
                    }
                    
                    int difference = sum - target;
                    if (map.containsKey(difference)) {
                        result+= map.get(difference);
                    }
                    
                    if (map.containsKey(sum)) {
                        map.put(sum, map.get(sum) + 1);
                    } else {
                        map.put(sum, 1);
                    }
                }
            }
        }
        return result;
    }
}
