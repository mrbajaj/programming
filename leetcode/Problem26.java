import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 */
class Problem26{
    public static void main(String[] args) {
        Problem26 obj = new Problem26();

        System.out.println("Ans: " + obj.removeDuplicates(new int[]{1,1,2}));
        
        System.out.println("Ans: " + obj.removeDuplicates(new int[]{0,1,2,3,4,5}));

        System.out.println("Ans: " + obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int length = -1;
        for(int i = 0 ; i < nums.length;){
            int currItem = nums[i];
            while( i < nums.length && currItem == nums[i] ){
                i++;
            }
            length++;
            nums[length] = currItem;
        }

        return length+1;

    }
}