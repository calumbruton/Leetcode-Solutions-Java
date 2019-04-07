class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            if (i==0)
                builder.append(arr[i]);
            else{
                builder.append(arr[i]+" ");
            }
        }        
        return builder.toString();
    }
}