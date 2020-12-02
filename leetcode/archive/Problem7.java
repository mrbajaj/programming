/**
 * URL: https://leetcode.com/problems/reverse-integer/
 * 
 */

public class Problem7 {

    public static void main(String[] args) {
        Solution2 obj = new Solution2();

        System.out.println("Ans: " + obj.reverse(1234));
        // System.out.println("Ans: " + obj.reverse(1));
        // System.out.println("Ans: " + obj.reverse(999));
        System.out.println("Ans: " + obj.reverse(1100));
        System.out.println("Ans: " + obj.reverse(-123));
        System.out.println("Ans: " + obj.reverse(-2147483648));
        System.out.println("Ans: " + obj.reverse(2147483647));
        // System.out.println("Ans: " + obj.reverse(2147483641));
        System.out.println("Ans: " + obj.reverse(1534236469));

    }

    
 }


 class Solution {
    public int reverse(int x) {
        long l = x;
        long r = 0, tmp = l;
        while(tmp != 0){
            long digit = tmp % 10;

            r = 10 * r + digit;
        
            tmp /= 10;
            // System.out.println(r);
            if ( (x < 0 && r < Integer.MIN_VALUE) || (x > 0 && r > Integer.MAX_VALUE)) {
                return 0;
            }
        }

        return (int) r; 
    }
}

class Solution2{

    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        int tmp = sign * x;

        int digit, r = 0, prev_r = 0;

        while( tmp > 0){
            digit = tmp % 10;
            tmp = tmp / 10;
            r = r*10 + digit;

            if ((r - digit)/10 != prev_r) 
            { 
                // overflow
                return 0; 
            } 
            // System.out.println("reversed: " + r + ", digit:" + digit + ", tmp:" + tmp + ", prev_y:" + prev_r) ;
            prev_r = r;
            
        }

        return r * sign;
        
    }
}