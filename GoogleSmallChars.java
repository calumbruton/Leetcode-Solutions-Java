// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
class Solution {

    // Written by Calum Bruton for Google!!
    // O(A * B) time complexity where we compare each split string from A to each string from B
    // I believe this could be possible to make faster by sorting the array of B strings based
    // on this lexographic comparison. Then when we go through the strings in A we can stop iterating
    // through once we have reached a string in B that is larger. This would have the same worst case
    // But could save time in application with very large arrays :)
    public int[] solution(String A, String B) {
        // write your code in Java SE 8
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");

        int[] res = new int[arrB.length];
        for (String strA: arrA){
            for (int i = 0; i<arrA.length-1; i++){
                String strB = arrB[i];
                // If true stringA is smaller than stringB increment spot of res
                if (!bLarger(strA, strB)){
                    res[i]++;
                }
            }
        }
        return res;
    }
    
    // Return true if B is larger
    public boolean bLarger(String A, String B){
        int[] aChars = new int [26];
        int[] bChars = new int [26];

        // check smallst charachter in each string using arrays
        // If same smallest charachter then count occurence and return 
        for (char a: A.toCharArray()){
            aChars[a - 'a']++;
        }
        for (char b: B.toCharArray()){
            bChars[b - 'a']++;
        }

        // Go through the charachters array from a-z
        for (int i = 0; i<=25; i++){
            if (aChars[i] > bChars[i]){
                return true;
            }
            if (bChars[i] > aChars[i]){
                return false;
            }
        }

        // Test what this should be if strings are same
        return false;
    }


    public static void main(String args[])
    {
        Solution sol = new Solution();
        int[] x = sol.solution("abcd aabc bd", "aaa aa");
        for (int i: x){
            System.out.println(i);
        }
    }
}