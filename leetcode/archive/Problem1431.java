/**
 * URL: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * 
 */
import java.util.List;
import java.util.ArrayList;

public class Problem1431 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] candies = new int[]{2,3,5,1,3};
        
        System.out.println(sol.kidsWithCandies(candies, 3));
    }    
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int greatest = findGreatest(candies);
        for(int i=0; i < candies.length; i++){
            result.add(candies[i] + extraCandies >= greatest);   
        }
        return result;
    }

    private static int findGreatest(int[] candies){
        if(candies.length <=0 ){
            return Integer.MIN_VALUE;
        }
        int max = candies[0];

        for(int i=1; i < candies.length; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        return max;
    }
    
}
