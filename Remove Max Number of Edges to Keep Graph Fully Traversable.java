/*
Ref: https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/discuss/831573/Python-Union-Find
*/

class UnionFind{
    int parent[];
    
    public UnionFind(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }   
    }
    
    public boolean union(int x, int y){
        int pX =  find(x);
        int pY =  find(y);
        if(pX==pY){
            return false;
        }
        parent[pX] = pY;
        return true;
    }
    
    
    public int find(int x){
        return  parent[x]  =  x == parent[x] ? x : find(parent[x]);
    }    
}


class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count1 = 0;
        int count2 = 0;
        int result= 0;
        UnionFind unionFind = new UnionFind(n+1);
        for (int[] edge : edges) {
            if (edge[0]==3) {
                if (unionFind.union(edge[1], edge[2])) {
                    count1++;
                    count2++;
                }
                else {
                    result++;
                }
            }
        }
        
        int[] parentList = unionFind.parent.clone();
        for (int[] edge : edges) {
            if (edge[0]==1) {
                if (unionFind.union(edge[1], edge[2])) {
                    count1++;
                }
                else {
                    result++;
                }
            }
        }
        unionFind.parent = parentList;
        for (int[] edge : edges) {
            if (edge[0]==2) {
                if (unionFind.union(edge[1], edge[2])) {
                    count2++;
                }
                else {
                    result++;
                }
            }
        }
        return count1==n-1 && count2==n-1 ? result:-1;
    }
}
