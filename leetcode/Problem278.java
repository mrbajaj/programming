/**
 * 
 */

public class Problem278 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.firstBadVersion(2));
        System.out.println("Ans: " + sol.firstBadVersion(2126753390));
        
    }

}


class VersionControl{
    public boolean isBadVersion(int n){
        System.out.println("API: " + n);
        return (n >= 1702766719) ? true : false;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1){
            return 1;
        }
        return helper(1, n);
    }

    private int helper(int s, int n){
        if(s > n){ return Integer.MAX_VALUE; }
        int mid = s + ((n - s) / 2);
        boolean isMidBad = super.isBadVersion(mid);

        int other;
        if(isMidBad == true){
            other = helper(s, mid - 1);
        }else{
            other = helper(mid + 1, n );
        }
        
        return (isMidBad == true && mid <= other)? mid : other;
        
    }

}