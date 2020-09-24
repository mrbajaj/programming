/**
 * URL: https://leetcode.com/problems/shuffle-the-array/submissions/
 * Sept2020 Session
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
        int ans[] = new int[2*n];
        int i = 0, j = n;
        for(int k=0; k < 2*n; k++){
            if(k%2 == 0){
                ans[k] = nums[i];
                i++;
            }else{
                ans[k] = nums[j];
                j++;
            }
        }
        return ans;
    }
}