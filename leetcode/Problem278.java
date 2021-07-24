/**
 * 
 */

class Problem278{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.firstBadVersion(10));
    }
}

/**
 * dummy implmentation for VersionControl class for testing purpose
 */
class VersionControl{

    int firstBadVersion = 5;

    public boolean isBadVersion(int mid){
        if(mid >= firstBadVersion){
            return true;
        }
        return false;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return helper(1, n, n);
    }
    
    public int helper(int low, int high, int lastBad){
        if(low > high){
            return lastBad;
        }
        
        int mid = low + (high - low) / 2;
        
        boolean isMidBad = isBadVersion(mid);
        
        if(isMidBad == true){
            return helper(low, mid-1, mid);
        }else{
            return helper(mid+1, high, lastBad);
        }
        
    }
}