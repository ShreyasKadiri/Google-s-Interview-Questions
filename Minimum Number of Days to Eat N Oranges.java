class Solution {
    public int minDays(int n) {
    if(n<3){
        return n;
    }
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int result=0;
        queue.offer(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
              int currentElement = queue.poll();
                if(set.contains(currentElement)){
                    --size;
                    continue;
                }else {
                    set.add(currentElement);
                }
                if(currentElement==1){
                    return result+1;
                }
                if(currentElement%3==0){
                    queue.add(currentElement/3);
                }
                if(currentElement%2==0){
                    queue.add(currentElement/2);
                }
                queue.add(currentElement-1);
                --size;
            }
            ++result;
        }
        return -1;
    }
}
