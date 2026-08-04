class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
         return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        
        // DFS from node 0
        if (!dfs(visited, 0, adj, -1)) {
            return false;
        }
        
        // Check if all nodes are visited (graph is connected)
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }

    public boolean dfs(boolean[] visited, int node, List<List<Integer>> adj, int parent) {
        // If already visited, cycle detected
        if (visited[node])
         return false;
        
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent)
             continue;  // Skip the parent
            if (!dfs(visited, neighbor, adj, node)) {
                return false;
            }
        }
        return true;
    }
}