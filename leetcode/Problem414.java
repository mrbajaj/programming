/**
 * URL: https://leetcode.com/problems/third-maximum-number/
 * Tags: Stack
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem414{

    public static void main(String[] args) {
        Solution sol = new Solution();

        // System.out.println("Ans: " + sol.thirdMax(new int[]{3,2,1}));

        // System.out.println("Ans: " + sol.thirdMax(new int[]{1,2}));

        System.out.println("Ans: " + sol.thirdMax(new int[]{2,2,3,1}));

        System.out.println("Ans: " + sol.thirdMax(new int[]{1,2,-2147483648}));

    }
}

class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }

        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(nums[i] == max || nums[i] == secondMax || nums[i] == thirdMax){
                continue;
            }

            if(nums[i] >= max){
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            }else if(nums[i] >= secondMax){
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if(nums[i] >= thirdMax){
                thirdMax = nums[i];
            }
        }
        
        System.out.println(max + " " + secondMax + " " + thirdMax);

        if(thirdMax != 0){
            return (int)thirdMax;
        }
        return (int)max;
    }
}