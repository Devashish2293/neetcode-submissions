class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0 ; i<n ; i++){
            adj.add(new ArrayList());
        }

        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components =0;

        for(int i = 0 ; i<n ; i++){
            if(visited[i]==false){
                bfs(adj,visited,i);
                components++;
            }
        }
        return components;
    }
    public void bfs(List<List<Integer>> adj,boolean[] visited, int start) {
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour: adj.get(node))
            {
                if(!visited[neighbour])
                {
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
            
        }
    }    
}
