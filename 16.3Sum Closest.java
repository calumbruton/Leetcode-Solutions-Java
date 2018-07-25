class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int i = 0;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        
        while (i<nums.length-2){
            int l = i + 1;
            int r = nums.length - 1;
            while(l<r){
                int tmp = nums[i] + nums[l] + nums[r];
                int tmpDiff = Math.abs(tmp-target);
                if(tmpDiff < diff){
                    diff = tmpDiff;
                    res = tmp;
                }
                if(tmp > target){
                    r--;
                }
                else if (tmp < target){
                    l++;
                }
                else{
                    return tmp;
                }
            }
            i++;
        }
        return res;
    }
}