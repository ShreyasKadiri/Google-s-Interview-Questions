class Solution {
    public int[] frequencySort(int[] nums) {
        int frequencySorted[] = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer, Integer>> frequencies = new ArrayList(map.entrySet());
        Collections.sort(frequencies, (a,b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies) {
            int count = entry.getValue();
            int key = entry.getKey();
            for (int i=0; i<count; i++) {
                frequencySorted[index++] = key;
            }
        }
        return frequencySorted;
    }
}
