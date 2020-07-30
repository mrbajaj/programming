/**
 * 
 */
import java.util.Arrays;

public class Problem1480 {
   public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = new int[]{1,2,3,4,5};
        int[] rSum = sol.runningSum(arr);
        System.out.println(Arrays.toString(rSum));
   }
}

class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}