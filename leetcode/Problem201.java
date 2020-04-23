/**
 * URL: https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * 
 */
public class Problem201 {

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution1 sol2 = new Solution1();

        System.out.println("Ans: " + sol1.rangeBitwiseAnd(5,7));
        System.out.println("Ans: " + sol1.rangeBitwiseAnd(1,15));
        System.out.println("Ans: " + sol1.rangeBitwiseAnd(0,1));
        System.out.println("Ans: " + sol1.rangeBitwiseAnd(14,15));
        System.out.println("Ans: " + sol1.rangeBitwiseAnd(2147483646,2147483647));
        System.out.println("---------");
        System.out.println("Ans: " + sol2.rangeBitwiseAnd(5,7));
        System.out.println("Ans: " + sol2.rangeBitwiseAnd(1,15));
        System.out.println("Ans: " + sol2.rangeBitwiseAnd(0,1));
        System.out.println("Ans: " + sol2.rangeBitwiseAnd(14,15));
        System.out.println("Ans: " + sol2.rangeBitwiseAnd(2147483646,2147483647));

        




    }
}

class Solution1 {
    public int rangeBitwiseAnd(long m, long n) {
        long andAns = m;
        for(long i = m+1; i <= n; i++){
            if(andAns == 0){
                return 0;
            }
            andAns = andAns & i;
        }
        return (int)andAns;
    }
}

class Solution2 {
    public int rangeBitwiseAnd(int m, int n) {
        while(n>m)
            n = n & n-1;
        return m&n;
    }
}
