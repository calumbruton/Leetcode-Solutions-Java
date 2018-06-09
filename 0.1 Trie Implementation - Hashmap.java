class TrieNode {
    private char c;
    public boolean leaf = false;
    public Map<Character, TrieNode> children = new HashMap<>();
    
    public TrieNode() {}
    public TrieNode(char c) {this.c = c;}
};


public class Trie {
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //If the trie node doesn't contain the next letter add it to that nodes map
            if (cur.children.containsKey(c)==false){
                cur.children.put(c, new TrieNode(c));
            }               
            cur = cur.children.get(c);
            if (i==word.length()-1)
                cur.leaf = true;
        }     
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (cur.children.containsKey(c)==false){
                return false;
            }
            cur = cur.children.get(c);
        }
        return (cur.leaf == true) ? true : false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for (char c : prefix.toCharArray()){
            if (cur.children.containsKey(c)==false){
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */