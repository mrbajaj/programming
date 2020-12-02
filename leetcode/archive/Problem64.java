/**
 * URL: https://leetcode.com/problems/minimum-path-sum/
 * 
 */
public class Problem64 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Ans: " + sol.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        return helper(grid, 0, 0, m, n, dp);
    }
    private int helper(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        

        int result;
        if(i == m-1 && j == n-1){
            // bottom-right item
            result = grid[i][j];
            System.out.println(i + " " + j + "=> down:" + 0 + ", right: " + 0);
        }else if(i == m-1){
            // bottom most row
            int right = helper(grid, i, j+1, m, n, dp);
            result = grid[i][j] + right;
            System.out.println(i + " " + j + "=> down:" + 0 + ", right: " + right);
        }else if(j == n-1){
            // right most column
            int down = helper(grid, i+1, j, m, n, dp);
            result = grid[i][j] + down;
            System.out.println(i + " " + j + "=> down:" + down + ", right: " + 0);
        }else {
            // intermediate colum
            int down = helper(grid, i+1, j, m, n, dp);
            int right = helper(grid, i, j+1, m, n, dp);
            result = grid[i][j] + Math.min(down, right);
            System.out.println(i + " " + j + "=> down:" + down + ", right: " + right);
        }
        
        dp[i][j] = result;
        return result;

    }
}