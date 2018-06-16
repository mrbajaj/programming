
// Java code for stack implementation/
 
import java.io.*;
import java.util.*;
 
class StackClassDemo
{   
    public static void main (String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        
        // stack.add(0, 7); // allowed but it should be avoided
        for(int i = 0; i < 5; i++)
        {
            stack.push(i);
        }
        System.out.println("After Push: "+ stack);
        System.out.println("Popped: "+ stack.pop());
        System.out.println("After Pop: "+ stack);
        System.out.println("Popped: "+ stack.pop());
        System.out.println("After Pop: "+ stack);

        System.out.println("Peeked :" + stack.peek());
        System.out.println("After Peek: "+ stack);
        
        // Integer pos = (Integer) stack.search(element);
        int p = stack.search(2);
        if( p == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + p);
        
        int q =  stack.search(6);
        if(q == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element is found at position " + q);
        
        // stack_search(stack, 2);
        // stack_search(stack, 6);
    }
}