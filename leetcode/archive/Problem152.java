/**
 * URL: https://leetcode.com/problems/maximum-product-subarray/
 * 
 */
public class Problem152 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.maxProduct(new int[]{2,3,-2,4}));

        System.out.println("Ans: " + sol.maxProduct(new int[]{-2,0,-1}));

        System.out.println("Ans: " + sol.maxProduct(new int[]{-2,3,-4}));

    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int currMaxProd = nums[0];
        int currMinProd = nums[0];
        int finalMaxProd = nums[0];

        for(int i = 1; i < n; i++){
            int tmp = currMaxProd;
            
            currMaxProd = Math.max(Math.max(currMaxProd * nums[i], currMinProd * nums[i]), nums[i]);
            currMinProd = Math.min(Math.min(currMinProd * nums[i], tmp * nums[i]), nums[i]);

            if(currMaxProd > finalMaxProd){
                finalMaxProd = currMaxProd;
            }
        }

        return finalMaxProd;
    }

    
}