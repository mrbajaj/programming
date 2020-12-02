/**
 * URL: https://leetcode.com/problems/maximum-subarray/
 * 
 */
public class Problem53 {

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        System.out.println("Ans: " + sol1.maxSubArray(new int[]{2,1,-3,4,-1,2,1,-5,4}));

        Solution2 sol2 = new Solution2();
        System.out.println("Ans: " + sol2.maxSubArray(new int[]{2,1,-3,4,-1,2,1,-5,4}));
    }
}

class Solution1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int[] maxSum = new int[n];
        maxSum[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++){
            int tmp = maxSum[i-1] + nums[i];
            maxSum[i] = (nums[i] > tmp) ? nums[i] : tmp;

            if(maxSum[i] > max){
                max = maxSum[i];
            }
        }

        return max;
        
    }
}

class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int currMax = nums[0];
        int finalMax = nums[0];

        for(int i = 1; i < n; i++){
            int tmp = currMax + nums[i];
            currMax = (nums[i] > tmp) ? nums[i] : tmp;

            if(currMax > finalMax){
                finalMax = currMax;
            }
        }

        return finalMax;
        
    }
}