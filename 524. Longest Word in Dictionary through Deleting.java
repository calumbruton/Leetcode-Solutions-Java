class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        String longestWord = "";
        for (String word: d){
            int l1 = 0; //s pointer
            int l2 = 0; //word pointer
            int n1 = s.length();
            int n2 = word.length();
            
            while (l1 != n1 && l2 != n2){
                if(s.charAt(l1) == word.charAt(l2)){
                    l1++; 
                    l2++;
                }
                else{
                    l1++;
                }
            }
            //If the whole word could be made from the string 
            if(l2 == n2){
                if (word.length() > longestWord.length()){
                    longestWord = word;
                }
                else if(word.length() == longestWord.length()){
                    //smaller lexographic word
                    if(word.compareTo(longestWord) < 0){
                        longestWord = word;
                    }
                }
            }
        }
        return longestWord;
    }
}