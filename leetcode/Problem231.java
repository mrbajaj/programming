/**
 * URL: https://leetcode.com/problems/power-of-two/
 */

 class Problem231{

    public static void main(String[] args) {
        Problem231 obj = new Problem231();
        // int n = 1;
        // int n = 8;
        // int n = 6;
        int n = 11;
        // int n = 2048 * 2048;


        System.out.println("Ans: " + obj.isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }

        return (n != 0 && (n & (n-1)) == 0);
    }
    
}