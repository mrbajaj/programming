/**
 * URL: https://leetcode.com/problems/verifying-an-alien-dictionary/
 * Tags: Medium, Array, Queue
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class Problem953{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));

        System.out.println("Ans: " + sol.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));

        System.out.println("Ans: " + sol.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int i = 0;
        while(i < words.length - 1){
            
            //traverse trhough string
            int j = 0;
            for(j = 0; j < words[i].length() && j < words[i+1].length(); j++){
                
                if( words[i].charAt(j) == words[i+1].charAt(j) ){
                    continue;
                }else if(order.indexOf( words[i].charAt(j)) < order.indexOf( words[i+1].charAt(j))){
                    break;
                }else{
                    return false;
                } 
            }
            
            if( j == words[i+1].length() && j <  words[i].length()){
                return false;
            }
            i++;
        }
        
        
        return true;
    }
}