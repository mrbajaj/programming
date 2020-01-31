/**
 * URL: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * 
 */
class Problem1281{

    public static void main(String[] args) {
        Problem1281 obj = new Problem1281();

        System.out.println("Ans: " + obj.subtractProductAndSum(123));

        System.out.println("Ans: " + obj.subtractProductAndSum(234));
    }

    public int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;
       
        while(n != 0){
            int r = n%10;
            sum += r;
            prod *= r;
            n /= 10;
        }
       
        return prod - sum;
       
    }
}