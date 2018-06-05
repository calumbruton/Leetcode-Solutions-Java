class TrieNode {
    public TrieNode [] children;
    public boolean isWord = false;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}

public class Solution {
    private TrieNode root;
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        //Insert a list of words into the trie
        for(String word : dict){
            insert(word); 
        }
        
        //Split the words in the sentence 
        String [] spltWords = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        
        //Iterate through the words changing them to the shortest prefix word
        for (int i = 0; i<spltWords.length; i++){
            String retWord = repWord(spltWords[i]);
            builder.append(retWord + " ");
        }
        
        String result = builder.toString();    
        return result.substring(0,result.length()-1);
    }
    
    //Insert a word into the trie
    public void insert(String word){
        TrieNode cur = root;
    
        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
             if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    //return a words shortest legitimate prefix word from the trie
    public String repWord(String word){
        TrieNode cur = root;
        String retStr = "";
        
        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            
            //return the original word if no prefix was found
            if (cur.children[c - 'a'] == null)
                  return word;
            retStr += c;
            if (cur.children[c - 'a'].isWord)
                return retStr;
            cur = cur.children[c - 'a'];
        }
        return word;
    }
}