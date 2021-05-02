
/**
 * URL: 
 * Tags: Tree
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.List;
import java.util.ArrayList;

public class Problem1431{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.kidsWithCandies(new int[]{2,3,5,1,3}, 3) );
    }
}

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> ans = new ArrayList<>();
        for(int c: candies){
            if(c > max){
                max = c;
            }
        }

        for(int c: candies){
            if(c + extraCandies >= max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;

    }
}