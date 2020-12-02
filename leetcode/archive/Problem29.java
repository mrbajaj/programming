/**
 * https://leetcode.com/problems/divide-two-integers/
 * 
 */
public class Problem29 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Ans:" + sol.divide(-2147483648, -1));
        System.out.println("Ans:" + sol.divide(10, -3));
        System.out.println("Ans:" + sol.divide(10, 3));

        // System.out.println("Ans:" + sol.divide(98, 3));

        // System.out.println("Ans:" + sol.divide(10, 5));

        // System.out.println("Ans:" + sol.divide(10, 5));


    }
}

class Solution {
    public int divide(int a, int b) {

        int quotientSign = ( (a < 0  && b > 0 ) || (b < 0  && a > 0 ))? -1: 1;
        
        Long dividend = (long)Math.abs(a);
        Long divisor = (long)Math.abs(b);

        long quotient = 0;
        while(dividend >= 0 ){
            dividend = dividend - divisor;
            if(dividend >= 0){
                quotient++;
            }
        }
        
        quotient = quotientSign < 0 ? makeItNegative(quotient) : quotient;

        if(quotient > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(quotient < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) quotient;
    }

   

    private long makeItNegative(long num){
        if(num > 0){
            num = num - num - num;
        }
        return num;
    }
}