/**
 * URL: 
 * Tags: Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */



class Problem153{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans:" + sol.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println("Ans:" + sol.findMin(new int[]{1,2,3,4,0}));
        System.out.println("Ans:" + sol.findMin(new int[]{0,1,2,4,5,6,7}));
    }
}

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        
        int x = (nums[0] > nums[n-1]) ? nums[n-1] : nums[0];
        
        int y = x;
        
        for(int i = 1; i < n ; i++){
            if(nums[i-1] >= nums[i]){
                y = nums[i];
                break;
            }
        }
        return x > y ? y : x;
    }
}