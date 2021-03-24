class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> maxHeap = new  PriorityQueue<int[]>((a,b)-> (b[1]  -a[1]));
        int shuffledArray[] = new int[A.length];
        for(int i=0; i<B.length; i++){
            maxHeap.offer(new int[]{i, B[i]});
        }
        
        int low= 0 ;
        int high = A.length-1;
        while(!maxHeap.isEmpty()){
            int top[] = maxHeap.poll();
            int maximum =  top[1];
            int index =  top[0];
            if(A[high] > maximum){
                //It is in advantage stage
                shuffledArray[index] = A[high];
                high-=1;
            }else {
                //maximum value in B is greater than or equal to maximum
                shuffledArray[index] = A[low];
                low++;
            }
        }
        
        return shuffledArray;
    }
}
