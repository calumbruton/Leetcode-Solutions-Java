class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand==null || hand.length==0) return false;
        if (hand.length % W != 0) return false;
        
        //Use a tree map with value,occurence relationship
        TreeMap <Integer, Integer> tmap = new TreeMap <>();
        for (int i : hand) tmap.put(i, tmap.getOrDefault(i, 0)+1);
        
        //while map isn't empty, for W cards start from the min card and see if there are 3 consecutive cards
        //If the next highest keyEntry isn't 1 above or exist then false
        while (!tmap.isEmpty()){
            
            int curr = tmap.firstKey();
            updateTreeMap(tmap, curr);
            int count = 1;
            
            while(count<W){
                
                Map.Entry<Integer,Integer> next = tmap.higherEntry(curr);
                
                if (next == null || (next.getKey() - curr) != 1) return false;
                updateTreeMap(tmap, next.getKey());
                curr = next.getKey();
                count++;
            }
        }      
        return true;
    }
    
    public void updateTreeMap(TreeMap<Integer,Integer> map,int curr)
    {
        map.put(curr,map.get(curr)-1);
        if(map.get(curr)==0) 
            map.remove(curr);
        
    }
}