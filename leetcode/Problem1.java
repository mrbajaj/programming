/**
 * 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Problem1{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + Arrays.toString(sol.twoSum(new int[]{2,7,11,15}, 9)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int curr = 0; curr < nums.length; curr++){
            if(map.containsKey(nums[curr])){
                ans[0] = map.get(nums[curr]);
                ans[1] = curr;
                return ans;
            }
            map.put(target - nums[curr], curr);
        }
        return ans;
    }
}