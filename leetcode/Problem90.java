/**
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Problem90{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans: " + sol.subsetsWithDup(new int[]{1,2,2}));       
    }
}

class Solution {
    List<List<Integer>> powerSet;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        powerSet = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<Integer>());
        return powerSet;
    }
    private void backtrack(int[] nums, int currIndex, List<Integer> currList){
        powerSet.add(new ArrayList<>(currList));
        for(int i = currIndex; i < nums.length; i++){
            //handle dups
            if(i != currIndex && nums[i] == nums[i-1]){
                continue;
            }
            //include
            currList.add(nums[i]);
            System.out.println(currList);
            //explore
            backtrack(nums, i+1, currList);
            //backtrack
            currList.remove(currList.size() -1);
        }

    }
}