/**
 * URL: https://leetcode.com/problems/contiguous-array/
 * 
 */
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Problem525 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        System.out.println("Ans: " + sol.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        System.out.println("Ans: " + sol.findMaxLength(new int[]{0, 1}));
        System.out.println("Ans: " + sol.findMaxLength(new int[]{0, 1, 1}));
    }

}

class Solution1{

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int counter = 0;
        Map<Integer, Integer> source = new HashMap<>();
        Map<Integer, Integer> dest = new HashMap<>();

        source.put(0,-1);
        dest.put(0,-1);
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                counter--;
            }else{
                counter++;
            }

            if(source.containsKey(counter)){
                dest.put(counter, i);
            }else{
                source.put(counter, i);
                dest.put(counter, i);
            }
        }
        System.out.println(source);
        System.out.println(dest);
        int maxDist = 0;
        Set<Integer> keys = source.keySet();

        for(Integer key: keys){
            int currDist = dest.get(key) - source.get(key);
            if(currDist >= maxDist){
                maxDist = currDist;
            }
        }

        return maxDist;
    }

}

class Solution2{

    // optimization for solution 1
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int counter = 0;
        Map<Integer, Integer> source = new HashMap<>();
        int maxDist = 0;

        source.put(0,-1);
        
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                counter--;
            }else{
                counter++;
            }

            if(source.containsKey(counter)){
                int currDist = i - source.get(counter);
                if(currDist > maxDist){
                    maxDist = currDist;
                }
            }else{
                source.put(counter, i);
            }
        }
        System.out.println(source);

        return maxDist;
    }

}