class Solution {
   public int getNumberOfBacklogOrders(int[][] orders) {
       int result = 0;
       int mod = (int)1e9 + 7;
       //Buyinglist of orders : MaxHeap
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
       
        //Sellinglist of orders : MaxHeap
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
       
       
        for (int[] order : orders) {
            if (order[2] == 0)
                buy.offer(order);
            else
                sell.offer(order);
            while (!buy.isEmpty() && !sell.isEmpty() && sell.peek()[0] <= buy.peek()[0]) {
                int difference = Math.min(buy.peek()[1], sell.peek()[1]);
                buy.peek()[1] -= difference;
                sell.peek()[1] -= difference;
                if (buy.peek()[1] == 0){
                     buy.poll();
                }
                if (sell.peek()[1] == 0) {
                    sell.poll();
                }
            }
        }
        
        for (int[] order : sell){
            result = (result + order[1]) % mod;
        }
            
       
        for (int[] order : buy){
            result = (result + order[1]) % mod;
        }
       
        return result;
    }
}
