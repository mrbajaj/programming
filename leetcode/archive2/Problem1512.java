/**
 * URL: 
 * Tags: LinkedList
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

import java.util.Map;
import java.util.HashMap;

public class Problem1512{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.numIdenticalPairs(new int[]{1,2,3,1,1,3}));

        System.out.println("Ans: " + sol.numIdenticalPairs(new int[]{1,1,1,1}));

        System.out.println("Ans: " + sol.numIdenticalPairs(new int[]{1,2,3}));
    }

}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> x : map.entrySet()){
            int n = x.getValue() * (x.getValue() - 1) / 2;
            count += n;
        }
        
        return count;
    }
}