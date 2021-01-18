class Solution {
    private int min = Integer.MAX_VALUE;
    private int bucketSize = 0;
    
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        bucketSize = n / k;
        
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sets.add(new HashSet<>());
        }
        
        backtrack(nums, 0, sets, 0);
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void backtrack(int[] nums, int idx, List<Set<Integer>> sets, int acc) {
        if (idx >= nums.length) {
            min = Math.min(min, acc);
            return;
        }
        
        Set<Set<Integer>> visited = new HashSet<>();
        
        for (Set<Integer> set: sets) {
            if (set.contains(nums[idx]) || set.size() == bucketSize || visited.contains(set)) continue;
            int impact = computeImpact(set, nums[idx]);
            acc += impact;
            if (acc < min) {
                set.add(nums[idx]);
                backtrack(nums, idx+1, sets, acc);
                set.remove(nums[idx]);
            }
            acc -= impact;
            visited.add(set);
        }
    }
    
    private int computeImpact(Set<Integer> set, int num) {
        if (set.size() == 0) return 0;
        if (set.size() == 1) return Math.abs(num - set.iterator().next());
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        
        for (int x: set) {
            lo = Math.min(lo, x);
            hi = Math.max(hi, x);
        }
        
        if (num < lo) return lo - num;
        if (num > hi) return num - hi;
        return 0;
    }
}

/*
https://leetcode.com/problems/minimum-incompatibility/discuss/961470/Java-backtrack-solution-with-optimizations
*/
