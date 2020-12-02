/**
 * URL: 
 */
public class Problem367 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        System.out.println("Ans: " + sol.isPerfectSquare(1));
        System.out.println("Ans: " + sol.isPerfectSquare(16));
        System.out.println("Ans: " + sol.isPerfectSquare(100));
        System.out.println("Ans: " + sol.isPerfectSquare(808201));
        System.out.println("Ans: " + sol.isPerfectSquare(20));
        
    }
}

class Solution1 {
    public boolean isPerfectSquare(int num) {
        for(int i = 1; i * i <= num; i++){
            if(i*i == num){
                return true;
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) 
                return true; 
            if (mid * mid < num) // mid is small -> go right to increase mid
                left = mid + 1;
            else
                right = mid - 1; // mid is large -> to left to decrease mid
        }
        return false;
    }
}