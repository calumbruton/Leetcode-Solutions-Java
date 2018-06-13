class Solution {
    public int compress(char[] chars) {
        //use three pointers -- 2 to keep track of number of chars - 1 used for in place rearrangment
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p2 < chars.length){
            //while p2 is on the same charachter
            while (p2<chars.length && chars[p2] == chars[p1]){
                p2++;
                System.out.println(p1 + ": " + p2);
            }
            int consecutive = p2-p1;
            
            //put the letter in it's proper spot
            chars[p3] = chars[p1];
            p3++;
            
            //if more than one letter put the number of it behind it
            if (consecutive > 1){
                //if more than 10 letters in a row
                while (consecutive >= 10){
                    int first = consecutive/10;
                    chars[p3] = (char) (first +'0');
                    consecutive = consecutive%10;
                    p3++;
                }
                chars[p3] = (char) (consecutive +'0');
                p3++;
            }
            
            //move p1 up to the next letter
            p1 = p2;
        }
        return p3;
    }    
}