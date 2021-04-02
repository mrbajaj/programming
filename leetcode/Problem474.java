/**
 * URL: https://leetcode.com/problems/ones-and-zeroes/
 * Tags: DP, 01KnapSack
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Arrays;

public class Problem474{

    public static void main(String[] args) {
        SolutionMemoization  sol = new SolutionMemoization();
        int ans = sol.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3);
        System.out.println("Ans: " + ans);

        ans = sol.findMaxForm(new String[]{"10","0","1"}, 1, 1);
        System.out.println("Ans: " + ans);
        ans = sol.findMaxForm(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66);
        System.out.println("Ans: " + ans);

        SolutionRecursive  solRec = new SolutionRecursive();
        ans = solRec.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3);
        System.out.println("Ans: " + ans);

        ans = solRec.findMaxForm(new String[]{"10","0","1"}, 1, 1);
        System.out.println("Ans: " + ans);
        ans = solRec.findMaxForm(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66);
        System.out.println("Ans: " + ans);
    }
}

class SolutionMemoization {
    int[][][] dp;
    int[][] strCounts;
    public int findMaxForm(String[] strs, int m, int n) {
        int strCount = strs.length;
        dp = new int[m+1][n+1][strCount];
        strCounts = new int[strCount][2];
        for(int i = 0; i < strCount; i++){
            strCounts[i] = countZerosOnes(strs[i]);
        }

        int ans = this.findMaxFormMemoize(strs, strCount, m, n, 0);
        return ans;
    }
    
    private int findMaxFormMemoize(String[] strs, int strCount, int m, int n, int index) {
        if(index >= strCount){
            return 0;
        }
        if(m <=0 && n <= 0){
            return 0;
        }
        if(dp[m][n][index] > 0){
            return dp[m][n][index];
        }
        int[] zo = strCounts[index];
        
        if(zo[0] <= m && zo[1] <= n){
            dp[m][n][index] = Math.max( 1 +  findMaxFormMemoize(strs, strCount, m - zo[0], n - zo[1], index+1), findMaxFormMemoize(strs, strCount, m, n, index+1));
        }else{
            dp[m][n][index] = findMaxFormMemoize(strs, strCount, m, n, index+1);
        }
        return dp[m][n][index];
    }
    
    private int[] countZerosOnes(String str){
        int[] count = new int[2];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                count[0] = count[0] + 1;
            }
            if(str.charAt(i) == '1'){
                count[1] = count[1] + 1;
            }
        }
        return count;
    }
}

class SolutionRecursive {
    int[][] strCounts;
    public int findMaxForm(String[] strs, int m, int n) {
        int strCount = strs.length;
        strCounts = new int[strCount][2];
        for(int i = 0; i < strCount; i++){
            strCounts[i] = countZerosOnes(strs[i]);
        }
        return this.findMaxFormRecursive(strs, strs.length, m, n, 0);   
    }
    
    private int findMaxFormRecursive(String[] strs, int strCount, int m, int n, int index) {
        if(index >= strCount){
            return 0;
        }
        if(m <=0 && n <= 0){
            return 0;
        }
        int[] zo = strCounts[index];
        
        if(zo[0] <= m && zo[1] <= n){
            return Math.max( 1 +  findMaxFormRecursive(strs, strCount, m - zo[0], n - zo[1], index+1), findMaxFormRecursive(strs, strCount, m, n, index+1));
        }else{
            return findMaxFormRecursive(strs, strCount, m, n, index+1);
        }
    }
    
    private int[] countZerosOnes(String str){
        int[] count = new int[2];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                count[0] = count[0] + 1;
            }
            if(str.charAt(i) == '1'){
                count[1] = count[1] + 1;
            }
        }
        return count;
    }
}