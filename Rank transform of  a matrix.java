class UnionFind{
    int parent[];
    
    public UnionFind(int n){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    
    public int find(int x){
    return parent[x]  = parent[x] == x ? x : find(parent[x]); 
    }
    

    public Pair<Integer, Integer> union (int x, int y){
        int pairX = find(x);
        int pairY = find(y);
        parent[pairX] = pairY;
        
        return new Pair<>(pairX, pairY);
    }
}



class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int rank[] = new int[matrix.length + matrix[0].length];
        Map<Integer, List<Pair<Integer, Integer>>> map = new TreeMap<>();
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                map.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i,j));
            }
        }
        
        for(int key : map.keySet()){
            UnionFind unionFind = new UnionFind(matrix[0].length + matrix.length);
            int rank2[] = rank.clone();
    for (Pair<Integer, Integer> current : map.get(key)) {
        Pair<Integer, Integer> result = unionFind.union(current.getKey(), current.getValue() + matrix.length);
        rank2[result.getValue()] = Math.max(rank2[result.getValue()], rank2[result.getKey()]);
        }
    for (Pair<Integer, Integer> current : map.get(key)) {
    rank[current.getKey()] = rank[current.getValue() + matrix.length] = matrix[current.getKey()][current.getValue()] = rank2[unionFind.find(current.getKey())] + 1;
            }
        }
        return matrix;
    }
}
