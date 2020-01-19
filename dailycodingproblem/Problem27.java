/**
 * Good morning! Here's your coding interview problem for today.
 * 
 * This problem was asked by Facebook.
 * 
 * Given a string of round, curly, and square open and closing brackets, 
 * return whether the brackets are balanced (well-formed).
 * 
 * For example, given the string "([])[]({})", you should return true.
 * Given the string "([)]" or "((()", you should return false.
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Problem27{

    public static void main(String[] args) {
        Problem27 obj = new Problem27();

        
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