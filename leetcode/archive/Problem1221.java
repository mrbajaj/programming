/**
 * 
 * URL: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
import java.util.Stack;

class Problem1221{
    public static void main(String[] args) {
        Problem1221 obj = new Problem1221();

        System.out.println(4 == obj.balancedStringSplit("RLRRLLRLRL"));

        System.out.println(3 == obj.balancedStringSplit("RLLLLRRRLR"));

        System.out.println(1 == obj.balancedStringSplit("LLLLRRRR"));

        System.out.println(2 == obj.balancedStringSplit("RLRRRLLRLL"));


    }

    public int balancedStringSplit(String s) {
        int count = 0;

        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for(int i=1; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() != s.charAt(i)){
                stack.pop();
            }else{
                stack.add(s.charAt(i));
            }
            
            if(stack.isEmpty()){
                count++;
            }
        }

        return count;
    }
}