import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        // Create graph (Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges (undirected)
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Visited array
        boolean[] visited = new boolean[n];
        
        // Call DFS
        return dfs(graph, source, destination, visited);
    }
    
    private boolean dfs(List<List<Integer>> graph, int current, int destination, boolean[] visited) {
        if (current == destination) {
            return true;
        }
        
        visited[current] = true;
        
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}