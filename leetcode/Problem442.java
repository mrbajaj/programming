import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * URL: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 */
class Problem442{
    public static void main(String[] args) {
        Problem442 obj = new Problem442();
        
        System.out.println("Ans: " + obj.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println("Ans: " + obj.findDuplicates_better(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums){

            if(freq.containsKey(n)){
                int x = freq.get(n);
                freq.put(n, x+1);
            }else{
                freq.put(n, 1);
            }

        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()){

            if(entry.getValue() > 1){
                ans.add(entry.getKey());
            }

        }

        return ans;
    }


    
    public List<Integer> findDuplicates_better(int[] nums) {
        // when find a number i, flip the number at position i-1 to negative. 
        // if the number at position i-1 is already negative, i is the number that occurs twice.
    
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i])-1;
            if (nums[x] < 0)
                res.add(Math.abs(x+1));
            nums[x] = -nums[x];
            System.out.println(Arrays.toString(nums));
        }
        return res;
    }

}