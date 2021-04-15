/**
 * URL: https://leetcode.com/problems/valid-parentheses/
 * Tags: Stack
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Stack;

public class String16{

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Ans: " + sol.isValid("()[]{}"));

        System.out.println("Ans: " + sol.isValid("(]"));
    }

}


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            // System.out.println(stack.toString());
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character top = stack.pop();
                if(top == '(' && s.charAt(i) != ')'){
                    return false;
                }
                if(top == '{' && s.charAt(i) != '}'){
                    return false;
                }
                if(top == '[' && s.charAt(i) != ']'){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}