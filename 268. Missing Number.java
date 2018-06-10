class Solution {
    public int missingNumber(int[] nums) {

        int idx = 0;      
        while (idx < nums.length){
            int val = nums[idx];
            
            //if it's not the one number that would be to large
            if (val < nums.length && val != idx){
                int temp = nums[val];
                nums[val] = val;
                nums[idx] = temp;
            }
            else idx++;
        }
        
        //The location of the number without an associated index (i.e the spot of 9 in a array of length 9)
        //is the spot of our missing value
        for (int i = 0; i<nums.length; i++){
            if (nums[i] >= nums.length) return i;
        }
        
        //The largest number is missing
        return nums.length;
    }
}