class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0)
            return true;
        List<List<Integer>> adj  = new ArrayList();
        List<Integer> result = new ArrayList();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            adj.add(new ArrayList());
        }
        for(int[] pre: prerequisites){
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        boolean[] visited = new boolean[numCourses];

        Queue<Integer> queue = new ArrayDeque();
          for(int i = 0; i<numCourses; i++){
            if(indegree[i]==0)
                queue.offer(i) ;   

        }

        while(!queue.isEmpty()){
            int node = queue.poll();

            if(indegree[node] == 0)
            {
                result.add(node);
                for(int neighbour: adj.get(node))
                {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
        System.out.println(result.size());
        return result.size()==numCourses;

    }
}
