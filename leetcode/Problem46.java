/**
 * URL: https://leetcode.com/problems/permutations/
 * 
 */
import java.util.List;
import java.util.ArrayList;

class Problem46{

    public static void main(String[] args) {
        Problem46 obj = new Problem46();

        System.out.println("Ans: " + obj.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        this.helper(nums, 0, nums.length -1, result);
        return result;
    }

    private void helper(int[] nums, int l, int r, List<List<Integer>> result) 
    { 
        System.out.println("l:" +l + "\tr:" + r);
        if (l == r){
            result.add(this.convertArrayToList(nums));
        }
        
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                System.out.println("\ti:" + i);
                this.swap(nums,l,i); 
                this.helper(nums, l+1, r, result); 
                this.swap(nums,l,i); // change it back to normal
            } 
        } 
    } 

    public void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<Integer> convertArrayToList(int[] nums) 
    {
        List<Integer> list = new ArrayList<Integer>(nums.length);
        for (int i : nums)
        {
            list.add(i);
        }
        return list;
    } 
}