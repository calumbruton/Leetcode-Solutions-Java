class Solution {
    public boolean isPalindrome(String s) {
        String ns = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int n = ns.length()-1;
        for(int i = 0; i<n; i++){
            if (ns.charAt(i) != ns.charAt(n)) return false;
            n--;
        }
        return true;
    }
}