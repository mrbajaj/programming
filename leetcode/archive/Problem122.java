/**
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 */
public class Problem122 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println("Ans: " + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Ans: " + sol.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println("Ans: " + sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}

class Solution1 {
    public int maxProfit(int[] prices) {
        
        return helper(prices, 0, prices.length - 1);

    }

    private int helper(int[] prices, int s, int e ){
        if(s >= e){
            return 0;
        }

        int buyDay = this.getBuyDayIndex(prices, s, e);
        int sellDay = buyDay;
        while(sellDay < e && prices[sellDay] < prices[sellDay+1]){
            sellDay++;
        }

        int profit = prices[sellDay] - prices[buyDay];
        return profit + helper(prices, s, buyDay-1) + helper(prices, sellDay+1, e);
        
    }
    private int getBuyDayIndex(int[] prices, int s, int e ){
        int minIndex = s;
        for(int i = s+1; i <= e; i++){
            if(prices[minIndex] > prices[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}

class Solution2 {
    // mountain approach (valley and peak)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int valleyIndex = -1;
        int peakIndex = -1;
        int maxProfit = 0;
        for(int i =0; i < n;  i++){
            // System.out.print("\t" + i);
            while(i < n-1 && prices[i] > prices[i+1]){
                i++;
            }
            // System.out.println("\t" + i);
            if(i < n){
                valleyIndex = i;
                // System.out.print("*\t" + peakIndex);
                while(i < n-1 && prices[i] < prices[i+1]){
                    i++;
                }
                if(i < n){
                    peakIndex = i;
                    // System.out.println("\t" + peakIndex);
                    maxProfit = maxProfit + prices[peakIndex] - prices[valleyIndex];
                }
                
            }
            
        }
        
        return maxProfit;
    }

}