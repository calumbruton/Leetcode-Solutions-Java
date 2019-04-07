public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
 
    private int max_capacity;
 
    public MyLinkedHashMap(int max_capacity){
        super();
        this.max_capacity = max_capacity;
    }
    
    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }
 
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > max_capacity;
    }
 
}


class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;  
        cache = new MyLinkedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            int val = cache.remove(key);
            cache.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //if map doesn't contain the key check if we are at capacity
        if(!cache.containsKey(key)){
            //if at capacity put will remove the oldest
            cache.put(key, value);
        }
        
        //If map does contain key then move to tail of queue
        else{
            cache.remove(key);
            cache.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */