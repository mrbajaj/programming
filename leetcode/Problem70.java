/**
 * 
 */

 public class Problem70{
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Ans: " + sol.climbStairs(5));
    }
 }

 class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        return helper(0, n);
    }
    
    private int helper(int curr, int dest){
        if(curr == dest){
            return 1;
        }
        if(curr > dest){
            return 0;
        }
        if(dp[curr] != 0){
            return dp[curr];
        }
        dp[curr] = helper(curr+1, dest) + helper(curr+2, dest);
        return dp[curr];
    }
}