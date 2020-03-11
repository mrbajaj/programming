/**
 * URL:https://leetcode.com/problems/single-number/
 * 
 * I was asked without using extra memory: but solved with extra memory
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Problem136{
    public static void main(String[] args) {
        Solution1 obj1 = new Solution1();
        Solution2 obj2 = new Solution2();

        System.out.println("Ans: " + obj1.singleNumber(new int[]{2,2,1}) + "\n");

        System.out.println("Ans: " + obj1.singleNumber(new int[]{4,1,2,1,2}) + "\n");

        System.out.println("Ans: " + obj1.singleNumber(new int[]{}) + "\n");

        System.out.println("Ans: " + obj2.singleNumber(new int[]{2,2,1}) + "\n");

        System.out.println("Ans: " + obj2.singleNumber(new int[]{4,1,2,1,2}) + "\n");

        System.out.println("Ans: " + obj2.singleNumber(new int[]{}) + "\n");

        

        
    }
}

class Solution1{
    public int singleNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> unique = new HashSet<>();
        
        for(int i=0; i< nums.length; i++){
            if(unique.contains(nums[i])){
                unique.remove(nums[i]);
            }else{
                unique.add(nums[i]);
            }
            
        }
        
        return unique.iterator().next();
    }
}

class Solution2{

    public int singleNumber(int[] nums) {
        // System.out.println(Arrays.toString(nums));
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        Map<Integer,Integer> freq = new HashMap<>();
        

        for(int i=0; i < n; i++){
            int key = nums[i];
            Integer existingCount = freq.get(key);
            if(existingCount != null){
                freq.put(key, existingCount+1);
            }else{
                freq.put(key, 1);
            }
        }

        Integer singleElement = nums[0];

        Set<Integer> keys = freq.keySet();

        // System.out.println(freq);
        // System.out.println(keys);

        for(Integer key: keys){
            if(freq.get(key) == 1){
                singleElement = key;
            }
        }
        
        return singleElement;
    }
}