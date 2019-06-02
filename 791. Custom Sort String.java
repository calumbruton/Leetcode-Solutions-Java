class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++){
            char l = T.charAt(i);
            if (map.containsKey(l)){
                map.put(l, map.get(l)+1);
            }
            else{
                map.put(l, 1);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++){
            char l = S.charAt(i);
            // build a string in the order they were
            if(map.containsKey(l)){
                for (int j = 0; j < map.get(l); j++){
                    builder.append(l);
                }
                map.remove(l);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char l = entry.getKey();
            for (int n=0; n < entry.getValue(); n++){
                builder.append(l);
            }
        }
        
        return builder.toString();
    }
}