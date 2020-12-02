import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

/**
 * URL: https://leetcode.com/problems/majority-element/
 * 
 * Note: not the optimal solution, should be solved with moore's voting algorithm
 */

 class Problem169{

    public static void main(String[] args) {
        Solution3 sol = new Solution3();

        // int[] nums = new int[]{2,2,1,1,1,2,2,1,1};
        int[] nums = new int[]{1,3,3};
        
        System.out.println("Ans: " + sol.majorityElement(nums));

    }
    
 }

 class Solution1 {
     // Time: O(n), Space: O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int count  = freq.getOrDefault(num, 0);
            freq.put(num, count+1);
        }

        int maxFreq = 1, maxItem = nums[0];

        Set<Integer> keys = freq.keySet();
        for(Integer key: keys){
            if(freq.get(key) > maxFreq ){
                maxFreq = freq.get(key);
                maxItem = key;
            }
        }
        return maxItem;
    }
}

class Solution2 {

    // Time: O(nlogn), Space: O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

class Solution3 {

    // Time: O(n), Space: O(1)
    public int majorityElement(int[] nums) {

        int candidateMajority = nums[0];
        int counter = 1;

        for(int i = 1; i < nums.length; i++){
            if(candidateMajority == nums[i]){
                counter++;
            }else{
                counter--;
            }
            if(counter == 0){
                candidateMajority = nums[i];
                counter = 1;
            }
        }

        return candidateMajority;
    }

}