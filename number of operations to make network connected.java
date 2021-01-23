class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1){
            return -1; 
        }
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0; i<n; i++){
            graph[i] = new ArrayList<>();  
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        int components=0;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++){
            components+=dfs(i,graph,visited);
        }
        return components-1; 
    }
    
    public int dfs(int i, List<Integer>[] graph, boolean[] visited) {
        if (visited[i]) 
            return 0;
        visited[i]=true;
        for (int node: graph[i]){
          dfs(node, graph, visited);  
        } 
        return 1;
    }
}
