/**
 * 
 */

public class Problem91{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans" + sol.numDecodings("236"));
        System.out.println("Ans" + sol.numDecodings("0"));
        System.out.println("Ans" + sol.numDecodings("01"));
        System.out.println("Ans" + sol.numDecodings("10"));
    }

}

class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= s.length(); i++){
            Integer singleDigit = Integer.valueOf(s.substring(i-1, i));
            Integer doubleDigit = Integer.valueOf(s.substring(i-2, i));
            
            if(singleDigit >= 1){
                dp[i] += dp[i-1]; 
            }
            if(doubleDigit >= 10 && doubleDigit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}