/**
 * URL: 
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */


public class Problem326{
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Ans: " + sol.isPowerOfThree(27));

        System.out.println("Ans: " + sol.isPowerOfThree(9));

        System.out.println("Ans: " + sol.isPowerOfThree(81));

        System.out.println("Ans: " + sol.isPowerOfThree(45));

        System.out.println("Ans: " + sol.isPowerOfThree(444));
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        int maxIntPowerOfThree = 1162261467;
        if(n <= 0 || n > maxIntPowerOfThree){return false;}
        return maxIntPowerOfThree % n == 0;
    }
}