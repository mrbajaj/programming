/**
 * URL: https://leetcode.com/problems/squares-of-a-sorted-array/
 * Tags: Array, Two Pointers
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

 public class Problem977{

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-1})));

        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-4,-1,0,3,10})));

        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-7,-3,2,3,11})));
    
    }
 }

 class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, size = nums.length;
        
        //O(n)
        while(i < size && nums[i] < 0){
            i++;
        }
        System.out.println(i);
        int p = i, n = i-1;
        int[] square = new int[size];

        i = 0;
        while (i < size && p < size && n >=0){
            if(Math.abs(nums[n]) <= nums[p]){
                square[i] = nums[n] * nums[n];
                n--;
            }else{
                square[i] = nums[p] * nums[p];
                p++;
            }
            
            i++;
        }

        while ( i < size && n >= 0){
            square[i] = nums[n] * nums[n];
            i++;
            n--;
        }

        while( i < size && p < size){
            square[i] = nums[p] * nums[p];
            p++;
            i++;
        }
     
        return square;
    }



       // i = 0;
        // //O(n)
        // while(i < size){
        //     if(n >=0 && p <= size && Math.abs(nums[n]) <= nums[p]){
        //         square[i] = nums[n] * nums[n];
        //         n--;
        //     }else{
        //         square[i] = nums[p] * nums[p];
        //         p++;
        //     }

        //     i++;
        // }
}