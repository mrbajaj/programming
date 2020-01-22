/**
 * URL: https://leetcode.com/problems/array-partition-i/
 * 
 */

 import java.util.Arrays;

 class Problem561{

    public static void main(String[] args) {
        Problem561 obj = new Problem561();
        System.out.println("Ans: " + obj. arrayPairSum(new int[]{1,4,3,2}));
        System.out.println("Ans: " + obj. arrayPairSum(new int[]{-10,-20, -1, 5, 1, 50,71,10}));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < nums.length; i+=2){
            sum += nums[i];
        }

        return sum;
        
    }
 }