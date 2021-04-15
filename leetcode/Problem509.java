/**
 * URL: 
 * Tags: DP, Memoization
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem509{

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fib(10));
    }

}

class Solution {
    
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

}

class SolutionDP {
    int[] dp = new int[31];
    public int fib(int n) {
        if(dp[n] != 0 ){
            return dp[n];
        }
        if(n == 0 || n == 1){
            return n;
        }
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
        // return fib(n-1) + fib(n-2);
    }

}