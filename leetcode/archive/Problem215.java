/**
 * URL: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 */
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

class Problem215{
    public static void main(String[] args) {

        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();

     
        System.out.println("Ans: " +  sol1.findKthLargest(new int[]{3,2,1,5,6,4}, 2) );
        System.out.println("Ans: " +  sol1.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4) );

        System.out.println("Ans: " +  sol2.findKthLargest(new int[]{3,2,1,5,6,4}, 2) );
        System.out.println("Ans: " +  sol2.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4) );
     
        
        
    }

}

class Solution1{

    public int findKthLargest(int[] nums, int k) {
        
        Arrays.sort(nums); 
        return nums[nums.length - k];
   
    }
}

class Solution2{

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        
        for(int i = 0; i < nums.length; i++){
            System.out.println("maxHeap PriorityQueue : " + maxHeap + "\tTop:" + maxHeap.peek()); 
            if(i < (nums.length - k + 1)){
                maxHeap.add(nums[i]);
            }else{
                // current max is top of the heap
                // if currentMax is greater than nums[i] then remove currentMax and add nums[i] into heap
                int currentMax = maxHeap.peek();
                if(currentMax > nums[i]){
                    maxHeap.poll();
                    maxHeap.add(nums[i]);
                }
            }
        }
        
        // System.out.println(maxHeap.size());

        return maxHeap.peek();
    }
}