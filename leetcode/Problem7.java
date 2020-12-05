/**
 * URL: https://leetcode.com/problems/reverse-integer/
 * Tags: Easy, Maths, IntegerRange
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem7{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Value: 111 => Ans: " + sol.reverse(111));
        System.out.println("Value: 001 => Ans: " + sol.reverse(001));
        System.out.println("Value: 123 => Ans: " + sol.reverse(123));
        System.out.println("Value: -123 => Ans: " + sol.reverse(-123));
        System.out.println("Value: 120 => Ans: " + sol.reverse(120));
        System.out.println("Value: 0 => Ans: " + sol.reverse(0));
        System.out.println("Value: 1534236469 => Ans: " + sol.reverse(1534236469));
        System.out.println("Value: -2147483648 => Ans: " + sol.reverse(-2147483648));
    }
}

class Solution {
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        x = x * sign;
        long result = 0;
        while(x != 0){
            int lastDigit = x % 10;
            result = result * 10 + lastDigit;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result * sign;
    }
}