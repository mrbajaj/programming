/**
 * URL: https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 */
import java.util.Arrays;

public class Problem560 {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        // System.out.println("Ans: " + sol.subarraySum(new int[]{-1,-1,1}, 0) ); // 1
        // System.out.println("Ans: " + sol.subarraySum(new int[]{1,-1,-1}, 0) ); // 
        // System.out.println("Ans: " + sol.subarraySum(new int[]{1,1,1}, 1) ); // 3
        // System.out.println("Ans: " + sol.subarraySum(new int[]{1,1,1}, 2) ); // 2
        // System.out.println("Ans: " + sol.subarraySum(new int[]{5,3,2,5,1,5,4,6}, 10) ); // 4
        System.out.println("Ans: " + sol.subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7) ); // 4
        // System.out.println("Ans: " + sol.subarraySum(new int[]{1,2,1,1,1,3,2,1,1,2}, 3) );
    }

}

class Solution1 {
    // Time complexity = O(n2) and Space complexity = O(n)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] leftSum = new int[n];
        leftSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        System.out.println(Arrays.toString(leftSum));

        for(int i = 0; i < n; i++){
            for(int j = i; j< n; j++){
                int sum;
                if(i == 0){
                    sum = leftSum[j];
                }else{
                    sum = leftSum[j] - leftSum[i-1];
                }
                if(sum == k){
                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }

        return count;
    }
}

class Solution2 {
    // Time complexity = O(n2) and Space complexity = O(1)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        // System.out.println(Arrays.toString(leftSum)); // [3, 7, 14, 16, 13, 14, 18, 20]

        int sum_i_to_j = 0;
        int sum_0_to_i = 0;
        int sum_0_to_j = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j< n; j++){
                //TODO    
                sum_i_to_j = sum_0_to_j - sum_0_to_i; //Imp
                
            }
        }

        return count;
    }
}