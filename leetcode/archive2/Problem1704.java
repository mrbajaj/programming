/**
 * URL: https://leetcode.com/problems/determine-if-string-halves-are-alike/
 * Tags: Medium, Array, Queue
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

 import java.util.Set;
 import java.util.HashSet;
 import java.util.Arrays;


public class Problem1704{
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.halvesAreAlike("book"));

        System.out.println("Ans: " + sol.halvesAreAlike("textbook"));

        System.out.println("Ans: " + sol.halvesAreAlike("MerryChristmas"));

        System.out.println("Ans: " + sol.halvesAreAlike("AbCdEfGh"));
    }
}

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int n = s.length();
        int count = 0;
        for(int i = 0, j = n/2; j < n; i++, j++){
            if(set.contains(s.charAt(i))){
                count++;
            }
            if(set.contains(s.charAt(j))){
                count--;
            }
        }
        return count == 0;
    }
}