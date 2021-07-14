/**
 * URL: 
 * Tags: Array
 * 
 * Best Time Complexity: O(n)
 * Best Space Complexity: O(1)
 */

 class Problem121{
     public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans:" + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Ans:" + sol.maxProfit(new int[]{7,6,4,3,1}));

     }
 }

 class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, minSoFar = prices[0];
        for(int i = 0; i < prices.length; i++){
            if((prices[i] - minSoFar) > profit){
                profit = prices[i] - minSoFar;
            }
            
            if(prices[i] < minSoFar){
                minSoFar = prices[i];
            }
        }
        
        
        return profit;
    }
}