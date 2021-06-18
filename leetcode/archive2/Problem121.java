/**
 * URL: 
 * Tags: Easy, Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

 public class Problem121{

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans:" + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Ans:" + sol.maxProfit(new int[]{7,6,4,3,1}));
    }
 
}

 class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; int buyAt = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < prices.length; i++){
            if(prices[i] < buyAt){
                buyAt = prices[i];
            }else{
                //two choices -> sell today, or don't sell today
                maxProfit = Math.max( prices[i] - buyAt, maxProfit);
            }
        
        }

        return maxProfit;
        
    }
}