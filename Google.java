// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;


class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] ans = new int[K]; //Solution Array

        // First thought is to use a sliding window and save the winner of each battle
        for (int i = 0; i<K; i++){
            ans[i] = A[i];
        }
        // Slide the window making each contiguous sub array fight
        for (int l = 0; l <= A.length-K; l++){
            int r = l+K;
            int[] curr = Arrays.copyOfRange(A, l, r);
            if (greater(curr, ans)){
                ans = curr;
            }
        }
        // Return the champion
        return ans;
    }

    // Return true if array B is greater than array C
    public boolean greater(int[] B, int[] C){
        // They must be the same length so no check required
        for (int i = 0; i < B.length; i++){
            if (B[i] > C[i]){
                return true;
            }
            else if (B[i] < C[i]){
                return false;
            }
        }
        // At this point they are the same so it doesn't matter
        return false;
    }


    public static void main(String args[])
    {
        Solution sol = new Solution();
        int[] temp = {1,4,3,2,5};
        int[] x = sol.solution(temp, 4);
        for (int i: x){
            System.out.println(i);
        }
    }
}