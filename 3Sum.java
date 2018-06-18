class Solution {
    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            int center = left + 1;
            int right = nums.length - 1;
            while(center < right) {
                int sum = nums[left] + nums[center] + nums[right];
                if (sum == 0) set.add(Arrays.asList(nums[left], nums[center], nums[right]));
                if (sum <= 0 && center < right) center++;
                if (sum >= 0 && center < right) right--;
            }
        }
        return new ArrayList<>(set);
    }
}