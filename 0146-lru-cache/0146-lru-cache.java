class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    
    int capacity;
    
    // Initial config.
    HashMap<Integer, ListNode> cache = new HashMap<>();
    
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;    
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // if cache already has the cache ? yes : no
        if(cache.containsKey(key)) {
            // get adress of the key
            ListNode node = cache.get(key);
            // get the value from that node's adress
            int val = node.val;
            // delete that node from list as well as cache
            delete(node);
            // create a new node with same key, val
            ListNode newNode = new ListNode(key, val);
            // insert that node at the start in list as well as cache
            insert(newNode);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // Create a new node
        ListNode newNode = new ListNode(key, value);
        
        // check if cache already has key ? yes : no
        
        if(cache.containsKey(key)) {
            // yes :: get the key's address from cache
            // visit that adress and delete that node 
            // also remove from cache
            ListNode prevNode = cache.get(key);
            delete(prevNode); // delete will delete that node, and also remove the key from cache
        }
        else {
            // check cache capacity ? reached : not reached
            if(cache.size() == capacity) {
                // delete node just before tail :: least recently used
                ListNode leastFrequentlyUsed = tail.prev;
                delete(leastFrequentlyUsed);
            }
        }
        insert(newNode); // insert will insert that node, as well as insert in cache
    }
    
    
    public void insert(ListNode node) {
        cache.put(node.key, node);
        
        ListNode before = head;
        ListNode after = head.next;
        
        node.next = after;
        node.prev = before;
        before.next = node;
        after.prev = node;
    }
    
    public void delete(ListNode node) {
        cache.remove(node.key);
        
        ListNode before = node.prev;
        ListNode after = node.next;
        
        before.next = before.next.next;
        after.prev = after.prev.prev;
        node.next = null;
        node.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */