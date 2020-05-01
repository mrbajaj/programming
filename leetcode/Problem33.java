/**
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 */
import java.util.Arrays;
class Problem33{
    public static void main(String[] args) {
        Solution obj = new Solution();

        // System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 45 ));
        // System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 75 ));
        // System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 55 ));
        // System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 22 ));
        // System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 11 ));
        // System.out.println("Ans: " + obj.search(new int[]{5,7,9,11,22,25,45,75}, 5 ));
        
        //find pivot
        // System.out.println("Ans: " + obj.search(new int[]{1}, 0 ) + "\n");
        System.out.println("Ans: " + obj.search(new int[]{1,3}, 0 ) + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{4,5,6,7,0,1,2,3}, 6 ) + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{2,3,4,5,6,7,0,1}, 6 ) + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{7,0,1,2,3,4,5,6}, 6 ) + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{0,1,2,3,4,5,6,7}, 6 ) + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{0,1}, 6 )  + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{2,0,1}, 6 ) + "\n");
        // System.out.println("Ans: " + obj.search(new int[]{1,2,3,4,5,6,7,0}, 6 ) + "\n");
        
    }

    
}

class Solution {
    public int search(int[] nums, int target) {
        int n =  nums.length;
        if(n == 1){
            return (nums[0] == target)? 0 : -1;
        }
        int pivot = this.findPivot(nums, 0,n-1);
        System.out.println(Arrays.toString(nums) + " :: pivot=" + pivot);
        if(pivot == -1){
            return this.binarySearch(nums, 0, n-1, target);
        }

        if(target == nums[pivot]){
            return pivot;
        }

        return (nums[0] <= target) ? binarySearch(nums, 0, pivot-1, target) : binarySearch(nums, pivot+1, n-1, target); 

    }

    private int findPivot(int[] nums, int lowIndex, int highIndex){
        if(lowIndex > highIndex) return -1;

        int mid = lowIndex + ( (highIndex - lowIndex) / 2);

        if(mid < highIndex && nums[mid] > nums[mid+1]){
            return mid;
        }
        if(mid > lowIndex && nums[mid] < nums[mid-1]){
            return mid;
        }
        
        int left = findPivot(nums, lowIndex, mid-1);
        return (left != -1)? left : findPivot(nums, mid+1, highIndex);
    
    }

    private int binarySearch(int[] nums, int lowIndex, int highIndex, int target){
        if(lowIndex > highIndex){
            return -1;
        }
        int mid = lowIndex + ( (highIndex - lowIndex) / 2);

        if(mid <= highIndex && mid >= lowIndex && nums[mid] == target){
            return mid;
        }

        if(target > nums[mid]){
            return binarySearch(nums, mid+1, highIndex, target);
        }else{
            return binarySearch(nums, lowIndex, mid-1, target);
        }

    }
}