/**
 * URL: https://leetcode.com/problems/counting-bits/
 * 
 */
import java.util.Arrays;

public class Problem338 {

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();
        Solution3 sol3 = new Solution3();

        System.out.println("Ans: " + Arrays.toString(sol1.countBits(2)));
        System.out.println("Ans: " + Arrays.toString(sol1.countBits(7)));

        System.out.println("Ans: " + Arrays.toString(sol2.countBits(2)));
        System.out.println("Ans: " + Arrays.toString(sol2.countBits(7)));

        System.out.println("Ans: " + Arrays.toString(sol3.countBits(2)));
        System.out.println("Ans: " + Arrays.toString(sol3.countBits(7)));
    }
}

class Solution1 {

    // using the built in method to calculate no of set bits
    public int[] countBits(int num) {
        int[] ans = new int[num+1];

        for(int i=0; i<= num; i++){
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }
}

class Solution2 {

    // using the recursive method to calculate the no of bits using the concept of [n & (n-1)]
    public int[] countBits(int num) {
        int[] ans = new int[num+1];

        for(int i=0; i<= num; i++){
            ans[i] = this.setBits(i);
        }

        return ans;
    }

    public int setBits(int n){
        if(n== 0){
            return 0;
        }else {
            return 1 + setBits(n & (n-1));
        }
    }
}


class Solution3 {

    // using the recursive method to calculate the no of bits using the concept of [n & (n-1)]
    // also utilizing the already calculated results instead of recalculation
    public int[] countBits(int num) {
        int[] ans = new int[num+1];

        for(int i=0; i<= num; i++){
            ans[i] = this.setBits(i, ans);
        }

        return ans;
    }

    public int setBits(int n, int[] ans){
        if(ans[n] != 0){
            // this is to speed up the calculations by avoiding already calculated results
            return ans[n];
        }
        if(n== 0){
            return 0;
        }else {
            return 1 + setBits( (n & (n-1)), ans);
        }
    }
}