/**
 * URL: https://leetcode.com/problems/valid-parentheses/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Problem20{

    public static void main(String[] args) {
        Problem20 obj = new Problem20();

        
        System.out.println("Ans: " + obj.bracesValidity("([][])"));
        
        System.out.println("Ans: " + obj.bracesValidity("([])[]({})"));

        System.out.println("Ans: " + obj.bracesValidity("([)]"));

        System.out.println("Ans: " + obj.bracesValidity("((()"));


    }

    public boolean bracesValidity(String str){
        
        String opens = "([{";
        String closes = ")]}";

        Map<String, String> openCloseMap = new HashMap<String,String>(){{
            put("(",")");
            put("[","]");
            put("{","}");
        }};
        
        Stack<String> stack = new Stack<>();

        for(int i= 0; i< str.length(); i++){
            String ch = String.valueOf(str.charAt(i));
            if(opens.contains(ch)){
                //push opens into the stack
                stack.add(ch);
            }else if(closes.contains(ch)){
                if(stack.isEmpty()){
                    
                    return false;
                }else{
                    //pop the top open from the stack
                    String o = stack.pop();
                    if(!ch.equals(openCloseMap.get(o))){
                        // open and close does not match
                        return false;
                    }
                }
            
            }

        }



        
        return stack.isEmpty();

    }
}