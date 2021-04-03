/**
 * URL: https://leetcode.com/problems/longest-valid-parentheses/
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Stack;

public class Problem32{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println( "Ans: " + sol.longestValidParentheses("(()") );     // 2
        System.out.println( "Ans: " + sol.longestValidParentheses(")()())") );  // 4
        System.out.println( "Ans: " + sol.longestValidParentheses("") );        // 0
        System.out.println( "Ans: " + sol.longestValidParentheses("()(()") );   // 2
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek() );
                }
            }
            
        }
        return max;
    }   
}
