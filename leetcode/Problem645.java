/**
 * URL: https://leetcode.com/problems/set-mismatch/
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Arrays;

public class Problem645{

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Value: {1,1} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{1,1})));

        System.out.println("Value: {2,2,3} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{2,2,3})));

        System.out.println("Value: {2,2} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{2,2})));
        
        System.out.println("Value: {1,1,2,3} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{1,1,2,3})));

        System.out.println("Value: {1,2,3,3} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{3,3,1,2})));

        System.out.println("Value: {1,2,4,4} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{1,2,4,4})));

        System.out.println("Value: {1,2,2,3,5} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{1,2,2,3,5})));

        System.out.println("Value: {1,2,4,2,5} \t=> Ans: " + Arrays.toString(sol.findErrorNums(new int[]{1,2,4,2,5})));
    }
}

class Solution {
    /* 
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Mismatch.
    Memory Usage: 40.4 MB, less than 73.08% of Java online submissions for Set Mismatch.
    */
    public int[] findErrorNums(int[] nums) {
        int[] dummy = new int[nums.length+1];
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++){
            int value = nums[i];
            if(dummy[value] == 1){
                ans[0] = value;
            }
            dummy[value] = 1;
        }
        for (int i = 1; i <= nums.length; i++){
            if(dummy[i] == 0){
                ans[1] = i;
            }
        }
        return ans;
    }
}

