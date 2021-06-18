/**
 * URL: 
 * Tags: String, Medium
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */


public class Problem583{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.minDistance("sea","eat"));
        System.out.println("Ans: " + sol.minDistance("leetcode","etco"));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        
        int i = 0, j = 0, diff = 0;

        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++; j++;
            }else{
                diff++;
                j++;
            }
        }
        i = 0; j = 0;
        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++; j++;
            }else{
                diff++;
                i++;
            }
        }
        // if(i < word1.length()){
        //     diff = diff + (word1.length() - i);
        // }
        // if(j < word2.length()){
        //     diff = diff + (word2.length() - j);
        // }

        return diff;

    }
}