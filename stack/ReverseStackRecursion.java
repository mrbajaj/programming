/**
 * Reverse the stack using recursion
 * 
 * Write a program to reverse a stack using recursion. 
 * You are not allowed to use loop constructs like while, for..etc, 
 * and you can only use the following ADT functions on Stack S:
 * isEmpty(S)
 * push(S)
 * pop(S)
 * 
 * 
 */

import java.util.Stack;

public class ReverseStackRecursion{
    public static void main(String[] args) {
        Solution sol = new Solution();

        Stack<Integer> stack = new Stack<>();
        stack.push(10); stack.push(20); stack.push(30); stack.push(40);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        stack.push(10); stack.push(20); stack.push(30); stack.push(40);
        sol.reverseStack(stack); System.out.println();
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


    }
}

class Solution{

    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Integer curr = stack.pop();

        reverseStack(stack);
        
        insert_at_bottom(curr, stack);

    }

    static void insert_at_bottom(Integer x, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(x);
        }else{
            Integer tmp = stack.pop();
            insert_at_bottom(x, stack);
            stack.push(tmp);
        }

    }
}