/***
 * URL: https://leetcode.com/problems/merge-sorted-array/
 * 
 */

import java.util.Arrays;

class Problem88{
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int m = 5, n = 6;
        // int[] nums1 = new int[m+n];
        // int[] nums2 = new int[]{3,5,8,10,11,14};
        // nums1[0] = 1; nums1[1] = 4; nums1[2] = 6; nums1[3] = 9; nums1[4] = 15;

        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));
        // sol.merge(nums1, m, nums2, n);
        // System.out.println(Arrays.toString(nums1));

        int m = 3, n = 3;
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        sol.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        // int m = 1, n = 0;
        // int[] nums1 = new int[m+n];
        // int[] nums2 = new int[n];
        // nums1[0] = 1;
        // sol.merge(nums1, m, nums2, n);
        // System.out.println(Arrays.toString(nums1));
    
        
    }

    

}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m + n;
        int i = m -1, t = x - 1, j, k;
        while(i >= 0){
            nums1[t] = nums1[i];
            i--; t--;
        }
        i = n; j = 0; k = 0;
        while(i < x && j < n){
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums1[i];
                i++;
            }else{
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < x){
            nums1[k] = nums1[i];
            i++;
            k++;
        }

        while(j < n){
            nums1[k] = nums2[j];
            j++;
            k++;
        }

    }
}