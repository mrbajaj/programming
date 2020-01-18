/**
 * URL: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 */
import java.util.Arrays;

class Problem215{
    public static void main(String[] args) {

        Problem215 obj = new Problem215();

     
        System.out.println("Ans: " +  obj.findKthLargest(new int[]{3,2,1,5,6,4}, 2) );
        System.out.println("Ans: " +  obj.findKthLargest_Heap(new int[]{3,2,1,5,6,4}, 2) );
        
        System.out.println("Ans: " +  obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4) );
        System.out.println("Ans: " +  obj.findKthLargest_Heap(new int[]{3,2,3,1,2,4,5,5,6}, 4) );
     
        
        
    }

    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums); 
        return nums[nums.length - k];
   
    }

    public int findKthLargest_Heap(int[] nums, int k) {
        //TODO
        return 0;
   
    }

}