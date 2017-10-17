class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //O(n) solution

        if (nums.length == 0){return 0;}
        int longest = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if (nums[i] > nums[i-1]){
                count++;
            }
            else{
                if (count > longest){longest=count;}
                count = 1;
            }
        }
        if (count > longest){longest=count;}
        return longest;
        
    } //End of findLengthOfLCIS
}