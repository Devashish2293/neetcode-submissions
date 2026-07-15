class LRUCache {
    // Node class for doubly linked list
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;  // Most recently used
    private Node tail;  // Least recently used
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);  // Dummy head
        tail = new Node(0, 0);  // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        removeNode(node);
        addToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() == capacity) {
                // Remove least recently used (node before tail)
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}