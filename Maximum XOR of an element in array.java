class Solution {

    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }

    Trie root;

    public int[] maximizeXor(int[] nums, int[][] q) {
        int n = nums.length;
        int index=0;
        root = new Trie();
        int[][] queries = new int[q.length][3];

        for(int i=0; i<q.length; ++i){
            queries[i][0] = q[i][0];
            queries[i][1] = q[i][1];
            queries[i][2] = i;
        }

        int[] result = new int[queries.length];
        Arrays.sort(nums);
        Arrays.sort(queries, (o1, o2) -> o1[1]-o2[1]);


        for(int i=0;i<queries.length;++i){
            while(index<n && nums[index]<=queries[i][1]){
                add(nums[index]);
                index++;
            }
            if(nums[0]>queries[i][1])
                result[queries[i][2]] = -1;
            else 
                result[queries[i][2]] = max_ans(queries[i][0]);
        }

        return result;

    }

    public void add(int num){
        Trie curNode = root;
        for(int i = 31; i >= 0; i --) {
            int curBit = (num >>> i) & 1;
            if(curNode.children[curBit] == null) {
                curNode.children[curBit] = new Trie();
            }
            curNode = curNode.children[curBit];
        }
    }


    public int max_ans(int num){
        Trie curNode = root;
        int curSum = 0;
        for(int i = 31; i >= 0; i --) {
            int curBit = (num >>> i) & 1;
            if(curNode ==null || curNode.children==null)
                break;
            if(curNode.children[curBit ^ 1] != null) {
                curSum += (1 << i);
                curNode = curNode.children[curBit ^ 1];
            }else {
                curNode = curNode.children[curBit];
            }
        }

        return curSum;
    }
}
