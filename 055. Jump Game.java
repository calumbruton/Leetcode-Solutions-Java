class Solution {
        public boolean canJump(int[] A) {
        int max = 0;
        for (int i=0; i<=max && i<A.length; i++) {
            max = Math.max(A[i] + i, max);
        }
        return max >= A.length - 1;
    }
}