/**
 * 
 */
import java.util.Arrays;

public class Problem88{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = new int[7]; nums1[0] = 1; nums1[1] = 2; nums1[2] = 3;
        int[] nums2 = new int[]{2,5,6,7};
        sol.merge(nums1, 3, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1, i = m-1, j = n-1;
        
        while(i >= 0 && j >=0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}