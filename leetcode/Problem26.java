import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 */
class Problem26{
    public static void main(String[] args) {
        Problem26 obj = new Problem26();

        System.out.println("Ans: " + obj.removeDuplicates(new int[]{1,1,2}));

        System.out.println("Ans: " + obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j=0;
        for(int i=0; i < n; i++){
            int curr = nums[i];
            while( i < n && nums[i] == curr ){
                // nums[i] = 0;
                i++;
            }
            i--;

            nums[j] = curr;
            j++;

        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}