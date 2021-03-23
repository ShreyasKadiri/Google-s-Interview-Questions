class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();        
        int result = 0;
        int mod = 1000000007;
        for (int i=0; i<arr.length; i++) {
            result = (result + map.getOrDefault(target - arr[i], 0)) % mod;
            
            for (int j=0; j<i; j++) {
                int currentValue = arr[i] + arr[j];
                map.put(currentValue, map.getOrDefault(currentValue, 0) + 1);
            }
        }
        return result;
    }
}
