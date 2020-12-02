/**
 * URL: https://leetcode.com/problems/move-zeroes/
 * 
 */
import java.util.Arrays;

public class Problem283 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = new int[]{0,0,1,2,0};
        sol.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{0,0,0,0};
        sol.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    
}

class Solution{
    public void moveZeroes(int[] nums) {
        int zero = 0, nonzero = 0;
        
        while(zero < nums.length && nonzero < nums.length ){
            System.out.println(Arrays.toString(nums));
            while(zero < nums.length && nums[zero] != 0){
                zero++;
            }
            System.out.println(zero);
            nonzero = zero+1;
            while(nonzero < nums.length && nums[nonzero] == 0){
                nonzero++;
            }
            
            if(zero >= nums.length || nonzero >= nums.length ){

                break;
            }
            System.out.println("zero" + zero + "\tnonzero" + nonzero);
            
            nums[zero] = nums[nonzero];
            nums[nonzero] = 0;
            zero++;
            nonzero++;
        }
    }
}