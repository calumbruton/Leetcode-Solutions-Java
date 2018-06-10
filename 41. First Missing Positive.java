class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        
        //put vals from range 0 to len(nums) in their appropriate index-1, ignore others
        int counter = 0;
        while (counter < nums.length){
            int val = nums[counter];
            //make sure the num is in the index range is not already in the correct spot and is not a duplicate
            if (val > 0 && val <= nums.length && val != counter+1 && nums[nums[counter] - 1] != nums[counter]){
                int temp = nums[val-1];
                nums[val-1] = val;
                nums[counter] = temp;
            }
            else
                counter++;
        }
        
        //Check if index value matches the value in its spot, if not that is the first missing positive value
        for (int i = 0; i<nums.length; i++){
            if (nums[i]!=(i+1)){
                return i+1;
            }
        }
        return nums.length+1;   
    }
}