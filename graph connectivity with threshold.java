/*
Ref: https://leetcode.com/problems/graph-connectivity-with-threshold/discuss/899695/Java-Union-Find-8-lines
*/
class UnionFind{
    int parent[];
    
    public UnionFind(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    
    public int find(int x){
        return parent[x] = x == parent[x] ? x : find(parent[x]);
    }
    
    public boolean union(int x, int y){
        int pX = find(x);
        int pY =  find(y);
        if(pX == pY){
            return false;
        }
        parent[pX] = pY;
        return false;
    }   
}


class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind unionFind = new UnionFind(n+1);
        List<Boolean> result = new ArrayList<Boolean>();
        for(int i=threshold+1; i<n; i++){
            for(int j=i; j<=n-i; j+=i){
                unionFind.union(j, j+i);
            }
        }
        
        for(int query[] : queries){
            result.add (unionFind.find(query[0]) == unionFind.find(query[1]));        
        }
        return result;
    }
}
