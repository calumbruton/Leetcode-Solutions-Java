class Element implements Comparable<Element>{
    char ch;
    int freq;
    public Element(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
    public int compareTo(Element other){
        return other.freq-this.freq;
    }
}

public class Solution {
    public String frequencySort(String s) {
        //create hashmap -> Letter, Freq
        Map <Character, Integer> map = new HashMap<Character,Integer>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c,1);
        }
        //Iterate through entry set adding letter Freq to queue
        Queue<Element> queue = new PriorityQueue<Element>();
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            //create a new custom object
            Element ele = new Element(ch, freq);
            queue.add(ele);
        }
        
        //make string
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()){
            Element ele = queue.poll();
            for(int i = 0; i<ele.freq; i++)
                builder.append(ele.ch);
        }
        String ans = builder.toString();
    
        return ans;
    }
}


//Using Comparator

class Element{
    char ch;
    int freq;
    public Element(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

public class Solution {
    public String frequencySort(String s) {
        //create hashmap -> Letter, Freq
        Map <Character, Integer> map = new HashMap<Character,Integer>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c,1);
        }
        //Iterate through entry set adding letter Freq to queue
        Queue<Element> queue = new PriorityQueue<Element>(new Comparator<Element>(){
            public int compare(Element e1, Element e2){
                return e2.freq-e1.freq;
            }
        });
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            //create a new custom object
            Element ele = new Element(ch, freq);
            queue.add(ele);
        }
        
        //make string
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()){
            Element ele = queue.poll();
            for(int i = 0; i<ele.freq; i++)
                builder.append(ele.ch);
        }
        String ans = builder.toString();
    
        return ans;
    }
}



