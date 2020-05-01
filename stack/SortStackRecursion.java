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

public class SortStackRecursion{
    public static void main(String[] args) {
        Solution sol = new Solution();

        Stack<Integer> stack = new Stack<>();
        stack.push(50); stack.push(30); stack.push(60); stack.push(40); stack.push(10); stack.push(20);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        stack.push(50); stack.push(30); stack.push(60); stack.push(40); stack.push(10); stack.push(20);
        sol.sortStack(stack); System.out.println();
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


    }
}

class Solution{

    public void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Integer curr = stack.pop();

        sortStack(stack);
        
        insert_at_sorted_position(curr, stack);

    }

    static void insert_at_sorted_position(Integer a, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(a);
        }else{

            Integer b = stack.pop();
            if(a < b){ 
                // ascending order, for descending order a > b
                stack.push(b);
                stack.push(a);
            }else{
                insert_at_sorted_position(a, stack);
                stack.push(b);
            }
            
            
        }
    }
}