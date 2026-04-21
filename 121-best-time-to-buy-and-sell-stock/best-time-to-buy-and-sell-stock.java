class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int minP=Integer.MAX_VALUE;
        int profit=0;

        for(int i=0;i<prices.length;i++)
        {
            minP=Math.min(prices[i],minP);
            profit=prices[i]-minP;
            max=Math.max(max,profit);
        }
        return max;
    }
}