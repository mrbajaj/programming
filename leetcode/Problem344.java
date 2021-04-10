/**
 * URL: https://leetcode.com/problems/reverse-string/
 * Tags: Array
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

 public class Problem344{

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        char[] arr = new char[]{'m','a','y','u','r'};
        sol.reverseString(arr);
        System.out.println(Arrays.toString(arr));
    
    }
 }

 class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while(i < j){
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}