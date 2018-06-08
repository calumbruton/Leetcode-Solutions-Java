public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Use priority queue (heap) to poll k highest 
        PriorityQueue <Element> queue = new PriorityQueue<Element>();
        
        //Use hash map to count freq of each value
        HashMap <Integer, Integer> map = new HashMap <Integer, Integer>();
        for (int i = 0; i<nums.length; i++){
            if (map.containsKey(nums[i])) {map.put(nums[i], (map.get(nums[i]))+1);}
            else map.put((nums[i]), 1);
        }
        
        //Iterate through the map taking key value pairs making them elements and adding them to the queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            Element e = new Element(entry.getKey(), entry.getValue());
            queue.add(e);
        }
        
        //Poll k elements
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i<k; i++){
            ans.add(queue.poll().val);
        }
        return ans;
    }
}

//Element stores a value and freq of the value
class Element implements Comparable<Element>{
    int val;
    int freq;
    
    //Used to sort elements by frequency
    public int compareTo(Element e){
        return e.freq - this.freq;
    }
    
    //Constructor
    public Element(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}