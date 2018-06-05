class TrieNode{
    public TrieNode[] children;
    public int val = 0;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}

public class MapSum {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
    
        for (int i = 0; i<key.length(); i++){
            char c = key.charAt(i);
             if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        int sum = 0;

        //get to the final node of the prefix, if a node doesn't exist return 0 nothing has the prefix
        for (int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null)
                  return 0;
            cur = cur.children[c - 'a'];
        }
        
        //sum up all the words using the prefix
        return recSum(cur);
    }
    
    public int recSum (TrieNode cur){
        int res = 0;
        if (cur == null)
            return 0;
        res += cur.val;
        for (TrieNode kid : cur.children){
            res += recSum(kid);
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */