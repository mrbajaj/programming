import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Also solved for not given sorted array
 * 
 */
class Problem26{
    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println("Ans: " + obj.removeDuplicates(new int[]{1,1,2,2,3,3,4,4,5,5,6}));
        System.out.println("Ans: " + obj.removeDuplicates(new int[]{1,2,1}));
        System.out.println("Ans: " + obj.removeDuplicates(new int[]{1,1,2}));
        
        System.out.println("Ans: " + obj.removeDuplicates(new int[]{0,1,2,3,4,5}));
        System.out.println("Ans: " + obj.removeDuplicates(new int[]{0,3,4,5,1,2}));

        System.out.println("Ans: " + obj.removeDuplicates(new int[]{1,1,2,3,3,4,1,2,0,0}));
        System.out.println("Ans: " + obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}

class Solution {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int uniqueIndex = 0;

        int itr = 0;
        while(itr < n){
            nums[uniqueIndex] = nums[itr];

            while(itr < n && nums[uniqueIndex] == nums[itr]){
                itr++;
            }

            uniqueIndex++;
        }

       System.out.println("Done:" + Arrays.toString(nums));
       return uniqueIndex;
    }
}