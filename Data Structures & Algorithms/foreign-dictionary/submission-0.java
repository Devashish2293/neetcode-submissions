class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Build adjacency list and indegree map
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        // Initialize all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build edges from adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            
            // Check for invalid prefix case: "abc" before "ab"
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;  // Only the first difference matters
                }
            }
        }
        
        // Step 3: Kahn's Algorithm
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            for (char neighbor : adj.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If not all characters are included, there's a cycle
        return result.length() == indegree.size() ? result.toString() : "";
    }
}