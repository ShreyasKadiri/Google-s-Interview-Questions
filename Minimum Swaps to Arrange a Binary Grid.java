class Solution {
    public int minSwaps(int[][] grid) {
        int[] trailingeroes = new int[grid.length]; 
        for (int i=0; i<grid.length; ++i){
            int counter=0;
            for (int j=grid.length-1; j>=0; j--){
                if (grid[i][j]!= 0)
                    break;
                counter++;
            }
            trailingeroes[i]=counter;
        }
        
        int required=grid.length-1;
        int result=0;
        while (required>0){
            boolean flag = false;
            for (int i=grid.length-required-1; i<grid.length; i++){
                if (trailingeroes[i] >=required){
                    int temp = trailingeroes[i];
                    for (int k=i; k>grid.length-required-1; k--)
                        trailingeroes[k]=trailingeroes[k-1];
                    trailingeroes[grid.length-required-1]=temp;
                    flag=true;
                    result+=i-(grid.length-required-1);
                    break;
                }
            }
            if (!flag)
                return -1;
            required--;
        }
        return result;
    }
}
