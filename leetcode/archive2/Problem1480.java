/**
 * URL: https://leetcode.com/problems/running-sum-of-1d-array/
 * Tags: Easy, Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

public class Problem1480{

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.runningSum(new int[]{1,2,3,4})));
    }
}

class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}