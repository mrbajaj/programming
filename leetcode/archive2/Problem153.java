/**
 * URL: https://leetcode.com/problems/deepest-leaves-sum/
 * Tags: Array, BinarySearch
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

 import java.util.Arrays;

 public class Problem153{

    public static void main(String[] args) {
        SolutionIterative sol = new SolutionIterative();
        System.out.println("Ans:" + sol.findMin(new int[]{5,6,7,1,2,3,4})+ "\n");
        System.out.println("Ans:" + sol.findMin(new int[]{4,5,6,1,2,3})+ "\n");
        System.out.println("Ans:" + sol.findMin(new int[]{2,3,4,5,6,1})+ "\n");
        System.out.println("Ans:" + sol.findMin(new int[]{1,2,3,4,5,6})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{7,1,2,3,4,5,6})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{3,4,5,6,7,1,2})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{3,4,5,6,7,1,1,2})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{4,5,1,1,1,2,3})+ "\n");
        

        
        System.out.println("Ans:" + sol.findMin(new int[]{5,1,2,3,4}) + "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{4,5,6,7,0,1,2}) + "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{4,5,6,7,1,2})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{11,13,15,17})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{3,4,5,1,1,2})+ "\n");
        // System.out.println("Ans:" + sol.findMin(new int[]{4,5,1,1,2,3})+ "\n");
    }
 }

 class SolutionIterative {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]) {
                //search left
                end = mid;
            } else {

                start = mid + 1;
            }
        }
        return nums[end];
    }
}

 class SolutionRecursion {
    public int findMin(int[] nums) {
        int N = nums.length;
        // System.out.println(Arrays.toString(nums));
        int minIndex = binarySearch(nums, 0, N-1, N);
        // System.out.print("minIndex: " + minIndex + "\t");
        return (minIndex >= 0) ? nums[minIndex] : -1;
    }

    private int binarySearch(int[] nums, int start, int end, int N){
        // System.out.println("\tstart: " + start + "\tend:" + end);
        int mid = (start + end) / 2; //start + (end-start) / 2;
        
        int next = (mid + 1) % N;
        int prev = (mid - 1 + N) % N;

        if(nums[mid] < nums[next] && nums[mid] < nums[prev]){
            return mid;
        }
        if(nums[mid] < nums[start] || nums[mid] == nums[prev]){
            //left
            return binarySearch(nums, start, mid, N);
        }
        if(nums[mid] > nums[end]){
            //right
            return binarySearch(nums, mid, end, N);
        }

        return -1;
    }
}