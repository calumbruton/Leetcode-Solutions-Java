class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        //iterate through each number in the array
        for(int i = 1; i < n; i++){
            //if the last number is the same as the current
            if (nums[i-1] == nums[i]){
                for (int y = i; y < n-1; y++){
                    nums[y] = nums[y+1];
                }
            n-=1;
            i-=1;
            }
        }
        return n;
    }
}