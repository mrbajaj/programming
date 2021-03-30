/**
 * URL: https://leetcode.com/problems/climbing-stairs/
 * Tags: Easy, DP
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem70{
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.climbStairs(5));
    }
}

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}
