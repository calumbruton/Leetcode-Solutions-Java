class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int max = 1;
        int min = 1;
        int oldMax = max;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] < 0){
                oldMax = max;
                max = Math.max(nums[i] , min * nums[i]);
                min = Math.min(nums[i], oldMax * nums[i]);
            } else {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            }
            globalMax = Math.max(globalMax , max);
        }
        return globalMax;
    }
}