/**
 * URL: https://leetcode.com/problems/number-of-1-bits/
 * 
 */

 class Problem191{
        public static void main(String[] args) {
        Problem191 obj = new Problem191();

        System.out.println("Ans: " + obj.hammingWeight(10));

        System.out.println("Ans: " + obj.hammingWeight(11));

        System.out.println("Ans: " + obj.hammingWeight(128));



    }

    public int hammingWeight(int n) {
        int oneCount = 0;
        
        while(n != 0) {
            oneCount += (n & 1);
            n >>>= 1;
        }
        
        return oneCount;
        
    }

 }