class Solution {
    public int longestMountain(int[] A) {
        int max = 0;
        
        //From each number check if it is a peak and then how far left and right it goes
        for (int i=1; i<A.length-1; i++){
            int size = 1;
            int l = i-1; 
            int r = i+1; 
            
            //if left and right conditions don't hold skip iteration
            if ((A[l] >= A[i]) || (A[r] >= A[i])) continue;
            
            //while the left val is smaller increase mountain size
            while ((l>=0) && (A[l]<A[l+1])){
                size += 1;
                l--;
            }
                
            //while right is smaller increase mountain size
            while ((r<A.length) && (A[r]<A[r-1])){
                size += 1;
                r++;
            }
            
            if (size>=3) 
                max = (size>max) ? size : max;
        }
        
        return max;
    }
}