class Solution {
    public int maximumScore(int a, int b, int c) {
        int maxScore = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x1, x2) -> (x2 - x1));
        maxHeap.offer(a);  maxHeap.offer(b);  maxHeap.offer(c);
        while (maxHeap.size() > 1) {
            int firstPile = maxHeap.remove();
            int secondPile = maxHeap.remove();
            maxScore += 1;
            firstPile -= 1;
            secondPile -= 1;
            if (firstPile > 0) 
                maxHeap.add(firstPile);
            if (secondPile > 0)
                maxHeap.add(secondPile);
        }
        return maxScore;
    }
}
