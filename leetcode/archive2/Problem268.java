/**
 * URL: https://leetcode.com/problems/missing-number/
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Arrays;

public class Problem268{

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        
        System.out.println("Value: {0,} \t=> Ans: " + sol.missingNumber(new int[]{0}));
        
        System.out.println("Value: {3,0,1} \t=> Ans: " + sol.missingNumber(new int[]{3, 0, 1}));

        System.out.println("Value: {0,1} \t=> Ans: " + sol.missingNumber(new int[]{0, 1}));

        System.out.println("Value: {9,6,4,2,3,5,7,0,1} \t=> Ans: " + sol.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1) ) / 2; 

        for(int num : nums){
            sum -= num;
        }

        return sum;
    }
}