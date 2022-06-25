class LRUCache {
    
    
    private int size;
    private HashMap<Integer, DLLNode> map;
    private DLLNode head;
    private DLLNode tail;

    private class DLLNode {
        public int key;
        public int value;
        public DLLNode prev;
        public DLLNode next;

        public DLLNode(){

        }

        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(DLLNode dllNode) {
        DLLNode prev = tail.prev;
        prev.next = dllNode;
        dllNode.next = tail;
        dllNode.prev = prev;
        tail.prev = dllNode;
        map.put(dllNode.key, dllNode);
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, DLLNode>();
        this.size = capacity;
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLLNode result = map.get(key);
        if(result!=null) {
            deleteNode(result);
            addNode(result);
            return result.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //already in cache
        DLLNode result = map.get(key);
        if(result!=null) {
            deleteNode(result);
        } else if(map.size() == size){
            deleteNode(head.next);
        }
        addNode(new DLLNode(key, value));
    }

    private void deleteNode(DLLNode dllNode) {
        DLLNode prev = dllNode.prev;
        DLLNode next = dllNode.next;
        prev.next = next;
        next.prev = prev;
        map.remove(dllNode.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */