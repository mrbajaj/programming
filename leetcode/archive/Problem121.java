/**
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * 
 */
class Problem121{

    public static void main(String[] args) {

        Problem121 obj = new Problem121();
        
        // assert obj.maxProfit(new int[]{7,1,5,3,6,4}) == 5 : " Incorrect Answer"; 

        System.out.println("Expected: 5 \tAns: " + obj.maxProfit_bruteforce(new int[]{7,1,5,3,6,4}));
        
        System.out.println("Expected: 0 \tAns: " + obj.maxProfit_bruteforce(new int[]{7,6,4,3,1}));

        System.out.println("Expected: 4 \tAns: " + obj.maxProfit_bruteforce(new int[]{4,5,8,3,2,1}));
        

        System.out.println("Expected: 5 \tAns: " + obj.maxProfit_optimal(new int[]{7,1,5,3,6,4}));
        
        System.out.println("Expected: 0 \tAns: " + obj.maxProfit_optimal(new int[]{7,6,4,3,1}));

        System.out.println("Expected: 4 \tAns: " + obj.maxProfit_optimal(new int[]{4,5,8,3,2,1}));
        
        
    }

    public int maxProfit_bruteforce(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        int buyPrice, sellPrice, netProfit;

        for(int i=0; i<n-1; i++){
            buyPrice = prices[i];
            sellPrice = prices[i+1];
            for(int j=i+1; j < n; j++){
                if(sellPrice < prices[j]){
                    sellPrice = prices[j];
                }
                
            }
            netProfit = sellPrice - buyPrice;
            if( netProfit > maxProfit){
                maxProfit = netProfit;
            }
        }
        
        return maxProfit;
    }

    public int maxProfit_optimal(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int price: prices){
            if(price < buyPrice){
                buyPrice = price;
            }
            int profit = price - buyPrice;

            maxProfit = Math.max(profit, maxProfit);
        }
        
        return maxProfit;
    }
}