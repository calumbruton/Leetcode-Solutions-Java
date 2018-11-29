class Solution {
    public void sortColors(int[] nums) {
        //3 pointers - i iterates through
        int l = 0;
        int r = nums.length-1;
        int i = 0;

        while (i <= r) {
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                i += 1;
                l += 1;
            }
            else if (nums[i] == 1){
                i++;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            }
        }       
    }
}