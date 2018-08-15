class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i<nums.length; i++){
            queue.add(nums[i]);
        }
        int max = 0;
        int curr = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            curr++;
            //continue to poll and increment counter if numbers are consecutive
            while (!queue.isEmpty() && (queue.peek()-1 == v || queue.peek() == v)){
                //if the next value is a duplicate just ignore it and continue
                if (queue.peek() == v) v = queue.poll();
                //else increase the counter and continue polling
                else{
                    curr++;
                    v = queue.poll();
                }
            }
            if(curr > max) max = curr;
            curr = 0;
        }
        return max;
    }
}