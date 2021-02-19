  class KthLargest {
        final PriorityQueue<Integer> maxHeap;
        final int k;

        public KthLargest(int k, int[] nums) {
            this.k=k;
            maxHeap= new PriorityQueue<Integer>(k);
            for (int i=0; i<nums.length; i++){
                maxHeap.add(nums[i]);
            }
        }

        public int add(int n) {
            if (maxHeap.size() < k)
                maxHeap.offer(n);
            else if (maxHeap.peek() < n) {
                maxHeap.poll();
                maxHeap.offer(n);
            }
            return maxHeap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
