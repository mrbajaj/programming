/**
 * URL:https://leetcode.com/problems/single-number/
 * 
 * I was asked without using extra memory: but solved with extra memory
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Problem136{
    public static void main(String[] args) {
        Problem136 obj = new Problem136();

        System.out.println("Ans: " + obj.singleNumber(new int[]{2,2,1}) + "\n");

        System.out.println("Ans: " + obj.singleNumber(new int[]{4,1,2,1,2}) + "\n");

        System.out.println("Ans: " + obj.singleNumber(new int[]{}) + "\n");

        

        
    }

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