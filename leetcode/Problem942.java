/**
 * URL: https://leetcode.com/problems/di-string-match/
 */
import java.util.Arrays;

class Problem942{

    public static void main(String[] args) {
        Problem942 obj = new Problem942();

        System.err.println("Ans: " + Arrays.toString( obj.diStringMatch("IDID") ));

        System.err.println("Ans: " + Arrays.toString( obj.diStringMatch("III") ));

        System.err.println("Ans: " + Arrays.toString( obj.diStringMatch("DDI") ));

    }

    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] ans = new int[N + 1];
        int min = 0, max = N;
        for(int i = 0; i < N; i++) {
            if(S.charAt(i) == 'I') ans[i] = min++;
            else if(S.charAt(i) == 'D') ans[i] = max--;
        }
        ans[N] = max;
        return ans;
        
    }
}