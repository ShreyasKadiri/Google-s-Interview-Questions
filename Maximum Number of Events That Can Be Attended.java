class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);
        Set<Integer> set = new HashSet<Integer>();
        
        for(int[] event : events) {
            if(event[1] == event[0]) {
                set.add(event[0]);
            } else {
                for(int i=event[0]; i<=event[1]; i++) {
                    if(!set.contains(i)) {
                        set.add(i);
                        break;
                    }
                }
            }
        }
        return set.size();
    }
}
