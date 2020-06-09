/**
 * URL: https://leetcode.com/problems/shuffle-the-array/submissions/
 * 
 */

import java.util.Arrays;

public class Problem1470 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.shuffle(new int[]{2,5,1,3,4,7}, 3)));
        System.out.println(Arrays.toString(sol.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
        System.out.println(Arrays.toString(sol.shuffle(new int[]{1,1,2,2}, 2)));
    }

}

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i = 0, j = n, k = 0;k < 2*n;){
            res[k] = nums[i];
            i++; k++;
            res[k] = nums[j];
            j++; k++;
        }
        
        return res;
    }
}