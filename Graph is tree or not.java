class Solution{
    public  static boolean isTree(int n, int edges[][]){
        if(edges.length == 0){
            return true;
        }
        
        List<List<Integer>> graph = new LinkedList<>();
        for(int i=0; i<n; i++){
            graph.add(new LinkedList<>());
        }
        
        for(int edge[] : edges){
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }
        
        boolean visited[] = new boolean[n];
        
        if(!graphValidater(n, edges, 0, -1, visited, graph)){
            return true;
        }
        
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
    
public static boolean graphValidater(int n, int edges[][], int vertexId, int parentId, boolean visited, List<List<Integer>> graph){
        if(visited[vertexId]==true){
            return false;
        }
        
        visited[vertexId]=true;
        List<Integer> neighbors = graph.get(vertexId);
        
        for(int neighbor : neighbors){
            if(neighbor!=parentId && !graphValidater(n, edges, neighbor, parentId, graph)){
                return false;
            }
        }
        return true;
    }
}
