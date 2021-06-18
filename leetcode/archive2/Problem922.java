/**
 * URL: https://leetcode.com/problems/sort-array-by-parity-ii/
 * Tags: Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

 public class Problem922{

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(sol.sortArrayByParity(arr)));
    
    }
 }

 class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int size = arr.length;

        int even = 0, odd = 1;

        while(even < size && odd < size){
            if(arr[even] % 2 == 0){
                even += 2;
                continue;
            }

            if(arr[odd] % 2 != 0){
                odd += 2;
                continue;
            }

            if(arr[even] % 2 != 0 && arr[odd] % 2 == 0){
                int tmp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = tmp;
                even+=2;
                odd+=2;
            }
        }
        return arr;
    }
}