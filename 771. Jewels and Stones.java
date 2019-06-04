class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet jewels = new HashSet();
        for (int i = 0; i < J.length(); i++) {
          jewels.add(J.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if(jewels.contains(S.charAt(i))){
                ans += 1;
            }
        }
        return ans;
    }
}