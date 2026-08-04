/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
         return null;
        
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> cloneMap = new HashMap<>();
        
        queue.offer(node);
        cloneMap.put(node, new Node(node.val));
        
        while (!queue.isEmpty()) {
            Node currOg = queue.poll();
            Node currClone = cloneMap.get(currOg);
            
            for (Node neighbor : currOg.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    cloneMap.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                currClone.neighbors.add(cloneMap.get(neighbor));
            }
        }
        return cloneMap.get(node);
    }
}