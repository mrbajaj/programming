/**
 * URL: https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Level: Medium
 * Tag: Array
 */

import java.util.Arrays;

public class Problem238{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans: " + Arrays.toString(sol.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println("Ans: " + Arrays.toString(sol.productExceptSelf(new int[]{-1,1,0,-3,3})));

        SolutionOptimised solOp = new SolutionOptimised();
        System.out.println("Ans: " + Arrays.toString(solOp.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println("Ans: " + Arrays.toString(solOp.productExceptSelf(new int[]{-1,1,0,-3,3})));
        
    }
}
/**
 * Space Complexity O(n)
 * Time Complexity O(n)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[n-1] = 1;
        for(int i = n-2; i >=0 ; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++){
            output[i] = left[i] * right[i];
        }
        return output;
    }
}

/**
 * Space Complexity O(1)
 * Time Complexity O(n)
 */
class SolutionOptimised {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;

        for(int i = 1; i < n; i++){
            output[i] = output[i-1] * nums[i-1];
        }
        int prod = 1;
        for(int i = n-2; i>=0; i--){
            prod = prod * nums[i+1];
            output[i] = output[i] * prod;
        }

        return output;
    }
}