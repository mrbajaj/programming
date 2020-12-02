import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/sort-colors/
 * 
 */
class Problem75{
    public static void main(String[] args) {
        Problem75 obj = new Problem75();

        obj.sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int red = 0, white = 1, blue = 2;
        int curr = -1;
        int i = 0;
        for(; i < nums.length; i++ ){
            if(nums[i] == red){
                curr++;
                nums[i] = nums[curr];
                nums[curr] = red;
            }
        }
        i = curr+1;
        for(; i < nums.length; i++ ){
            if(nums[i] == white){
                curr++;
                nums[i] = nums[curr];
                nums[curr] = white;
            }
        }
        // i = curr+1;
        // for(; i < nums.length; i++ ){
        //     if(nums[i] == blue){
        //         curr++;
        //         nums[i] = nums[curr];
        //         nums[curr] = blue;
        //     }
        // }
        System.out.println(Arrays.toString(nums));
    }
}