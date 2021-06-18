/**
 * URL: https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * Tags: Medium, Array, Queue
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.HashSet;
import java.util.Arrays;

public class Problem575{

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        
        System.out.println("Ans: " + sol.distributeCandies(new int[]{1,1,2,2,3,3}));

        System.out.println("Ans: " + sol.distributeCandies(new int[]{1,1,2,3}));

        System.out.println("Ans: " + sol.distributeCandies(new int[]{6,6,6,6}));

    }
}

class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int N = candyType.length;
        for(int i =0; i < N; i++){
            set.add(candyType[i]);
        }
        if(set.size()  > N/2){
            return N/2;
        }else{
            return set.size();
        }
    }
}
/**
 * Java 8
 */
class Solution2{
    public int distributeCandies(int[] candies) {
        return Math.min(candies.length / 2, ((int) Arrays.stream(candies).distinct().count()));
    }
}