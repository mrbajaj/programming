/**
 * URL: https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class Problem540 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        
    }
}


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int a, b, c, n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        for(int i = 2; i < nums.length; i++){
            if(nums[i-2] != nums[i-1] &&  nums[i-1] != nums[i]){
                return nums[i-1];
            }
        }

        return -1;
    }
}