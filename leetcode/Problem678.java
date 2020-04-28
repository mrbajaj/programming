/**
 * URL: https://leetcode.com/problems/valid-parenthesis-string/
 * 
 */
import java.util.Stack;
public class Problem678 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        // System.out.println("Input () \tAns: " + sol.checkValidString("()") + "\n");
        // System.out.println("Input *(()*)) \tAns: " + sol.checkValidString("*(()*))") + "\n");
        // System.out.println("Input )*() \tAns: " + sol.checkValidString(")*()") + "\n");
        // System.out.println("Input (*(**) \tAns: " + sol.checkValidString("(*(**)") + "\n");
        // System.out.println("Input (*(**) \tAns: " + sol.checkValidString("(*(*") + "\n");
        System.out.println("Input ***(() \tAns: " + sol.checkValidString("***(()") + "\n");
        
    
        // System.out.println("Input (*) \tAns: " + sol.checkValidString("(*)") + "\n");
        // System.out.println("Input *()* \tAns: " + sol.checkValidString("") + "\n");
        // System.out.println("Input (*)) \tAns: " + sol.checkValidString("(*))") + "\n");
        // System.out.println("Input ()*) \tAns: " + sol.checkValidString("()*)") + "\n");
        // System.out.println("Input ()) \tAns: " + sol.checkValidString("") + "\n");
        // System.out.println("Input ())* \tAns: " + sol.checkValidString("") + "\n");

    }
}

class Solution1 {
    public boolean checkValidString(String s) {
        Stack<Integer> opensPositions = new Stack<>();
        Stack<Integer> starPositions = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            System.out.println("Inside 1");
            System.out.println("\t:" + opensPositions);
            System.out.println("\t:" + starPositions);
            Character ch = s.charAt(i);
            if(ch == '(') {
                opensPositions.push(i);
            }else if (s.charAt(i) == '*'){
                starPositions.push(i);
            }else{
                if(!opensPositions.isEmpty()){
                    // open is not empty
                    opensPositions.pop();
                }else if(!starPositions.isEmpty()){
                    // stars is not empty
                    starPositions.pop();
                }else{
                    return false;
                }
            }
        }
        
        while(!opensPositions.isEmpty() && !starPositions.isEmpty()){
            System.out.println("Inside 2");
            System.out.println("\t:" + opensPositions);
            System.out.println("\t:" + starPositions);
            int openIndex = opensPositions.pop();
            int starIndex = starPositions.pop();
            if(openIndex > starIndex){
                return false;
            }
        }

        System.out.println("Outside 1");
        System.out.println("\t:" + opensPositions);
        System.out.println("\t:" + starPositions);
        if(!opensPositions.isEmpty()){
            return false;
        }

        return true;
    }
}

class Solution2 {
    //Dynamic programing
    public boolean checkValidString(String s) {
        // TODO
        return true;
    }
}