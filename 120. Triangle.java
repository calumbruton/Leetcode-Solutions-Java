/*Bottom-up DP solution!*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //Starting at the second last layer move to the top
        for (int l = n-2; l >= 0; l--){
            //for each make it the min of it + one of the branches below it
            List<Integer> row = triangle.get(l);
            for (int i = 0; i<row.size(); i++){
                int value = Math.min(row.get(i) + triangle.get(l+1).get(i), row.get(i) + triangle.get(l+1).get(i+1));
                    
                row.set(i, value);
            }
            
        }
        
        return triangle.get(0).get(0);
        
    }
}




/*
Brute force approach
Time limit expires as expected
BFS doesn't work because no goal node, the last node can be the one that makes the path smaller
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int min_sum = 100000000;
        PriorityQueue<Entry> queue = new PriorityQueue<Entry>();
        queue.add(new Entry(triangle.get(0).get(0), 0, 0));
        int depth = 0;
        
        //Perform Best First Search
        while (!queue.isEmpty()){
            Entry path = queue.poll();
            int index = path.index;
            int next_depth = path.depth+1;
            
            //We have reached the bottom of the tree check if best path
            if (next_depth >= triangle.size()){
                if (path.cost < min_sum) min_sum = path.cost;
            
            }
            else {
                for (int i = 0; i < 2; i++){
                    int new_cost = path.cost + triangle.get(next_depth).get(index+i);
                    queue.add(new Entry(new_cost, index+i, next_depth));
                }
            }
        }
        return min_sum;
    }
}


class Entry implements Comparable<Entry>{
    int cost;
    int index;
    int depth;
    
    public Entry(int cost, int index, int depth){
        this.cost = cost;
        this.index = index;
        this.depth = depth;
    }
    
    public int compareTo(Entry other){
        return this.cost - other.cost;
    }
    
}