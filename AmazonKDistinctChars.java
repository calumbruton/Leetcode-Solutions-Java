// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.*;

class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int countKDistinctSubstrings(String inputString, int num)
	{
	    int strLen = inputString.length();
	    int count = 0; //Counter for the number of substrings
        for (int i=0; i < strLen; i++){
            Set<Character> chars = new HashSet<Character>();
            int j = i;
            chars.add(inputString.charAt(j));
            //Get to a string with the correct number of distinct chars
            while (chars.size()<num && j < strLen-1){
                j+=1;
                if (!chars.contains(inputString.charAt(j))){
                    chars.add(inputString.charAt(j));
                }
            }
            // Once there continue through the string incrementing the Counter
            // Until we there are too many distinct characters
            while (chars.size()==num){
                count += 1;
                // System.out.println(i + ", j=" + j + ", " + inputString.substring(i, j+1));
                if (j == strLen-1){
                    break;
                }
                j+=1;
                if (!chars.contains(inputString.charAt(j))){
                    chars.add(inputString.charAt(j));
                }
            }
        }
        System.out.println(count);
        return count;
    }
    // METHOD SIGNATURE ENDS


    // Function to count number of substrings 
    // with exactly k unique characters 
    int countkDist(String str, int k) 
    { 
        // Initialize result 
        int res = 0; 
  
        int n = str.length(); 
  
        // To store count of characters from 'a' to 'z' 
        int cnt[] = new int[26]; 
  
        // Consider all substrings beginning with 
        // str[i] 
        for (int i = 0; i < n; i++) 
        { 
            int dist_count = 0; 
  
            // Initializing count array with 0 
            Arrays.fill(cnt, 0); 
  
            // Consider all substrings between str[i..j] 
            for (int j=i; j<n; j++) 
            { 
                // If this is a new character for this 
                // substring, increment dist_count. 
                if (cnt[str.charAt(j) - 'a'] == 0) 
                    dist_count++; 
  
                // Increment count of current character 
                cnt[str.charAt(j) - 'a']++; 
  
                // If distinct character count becomes k, 
                // then increment result. 
                if (dist_count == k) 
                    res++; 
            } 
        } 
  
        System.out.println(res);
        return res; 
    } 
    public static void main(String args[])
    {
        Solution sol = new Solution();
        System.out.println("------My answer-------");
        sol.countKDistinctSubstrings("pqpqs", 2);
        sol.countKDistinctSubstrings("asdfas", 4);
        sol.countKDistinctSubstrings("", 4);
        sol.countKDistinctSubstrings("dasfdas", 0);
        sol.countKDistinctSubstrings("aaaa", 1);

        System.out.println("------Their Answer-------");
        sol.countkDist("pqpqs", 2);
        sol.countkDist("asdfas", 4);
        sol.countkDist("", 4);
        sol.countkDist("dasfdas", 0);  
        sol.countkDist("aaaa", 1);
    }
}