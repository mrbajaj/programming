/**
 * URL: 
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem62{

    public static void main(String[] args) {
        SolutionDP sol = new SolutionDP();

        System.out.println("Ans:" + sol.uniquePaths(3, 7));

        System.out.println("Ans:" + sol.uniquePaths(3, 2));
    }
    
}

class Solution {
    public int uniquePaths(int m, int n) {
        return findPathRec(m, n, 0, 0);
    }
    private int findPathRec(int m, int n, int i, int j){
        if(i == m -1 && j == n-1){
            return 1;
        }else if(isValid(m, n, i, j)){
            //go right + //go down
            return findPathRec(m, n, i, j+1) + findPathRec(m, n, i+1, j);
        }
        return 0;
    }
    
    private boolean isValid(int m, int n, int i, int j){
        if(i >= 0 && j >= 0 && i < m && j < n){
            return true;
        }
        return false;
    }
}

class SolutionDP {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
    
    
    private boolean isValid(int m, int n, int i, int j){
        if(i >= 0 && j >= 0 && i < m && j < n){
            return true;
        }
        return false;
    }
}