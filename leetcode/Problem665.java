/**
 * URL: https://leetcode.com/problems/non-decreasing-array/
 * Tags: Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem665{
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Ans: " + sol.checkPossibility(new int[]{4,2,3}));

        System.out.println("Ans: " + sol.checkPossibility(new int[]{4,2,1}));

        System.out.println("Ans: " + sol.checkPossibility(new int[]{1,1,1}));
    }
}

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean used = false;

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                if(used){ return false; }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]){
                    nums[i - 1] = nums[i]; // decrease nums[i - 1]
                } else {
                    nums[i] = nums[i - 1]; // increase nums[i]
                }
                used = true;
            }
        }
        return true;
    }
}