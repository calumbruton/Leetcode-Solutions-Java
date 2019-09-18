class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buyOne = Integer.MAX_VALUE;
        int buyTwo = Integer.MIN_VALUE;
        int sellOne = Integer.MIN_VALUE;
        int sellTwo = Integer.MIN_VALUE;
        for (int i : prices){
            buyOne = Math.min(buyOne, i); // Keep track of the minimum that can be bought
            sellOne = Math.max(i-buyOne, sellOne); // Max profit of the current trade or previous one
            
            buyTwo = Math.max(sellOne - i, buyTwo); // Current profit from first trade - second buy, or the profit from buying earlier
            sellTwo = Math.max(buyTwo + i, sellTwo); // Profit from selling after the second buy
            
        }
        return Math.max(sellOne, sellTwo);
    }
}