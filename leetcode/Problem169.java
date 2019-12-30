import java.util.HashMap;
import java.util.Map;

/**
 * URL: https://leetcode.com/problems/majority-element/
 * 
 * Note: not the optimal solution, should be solved with moore's voting algorithm
 */

 class Problem169{

    public static void main(String[] args) {
        // int[] nums = new int[]{3,2,3};

        int[] nums = new int[]{2,2,1,1,1,2,2,1,1};
        System.out.println("Ans: " + majorityElement(nums));

    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        int[] majorityElement = new int[1];
        int[] majorityElementCount= new int[]{0};
        int magicFigure = nums.length / 2;
        
        for(int i=0; i<nums.length; i++){
            if(countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i])+1);
            }else{
                countMap.put(nums[i], 1);
            }
        }

        countMap.forEach((k,v)-> {
            if(v >= magicFigure && v > majorityElementCount[0]){
                majorityElementCount[0] = v;
                majorityElement[0] = k;
            }
        });

        System.out.println(countMap);

        return majorityElement[0];
        
        
    }
 }