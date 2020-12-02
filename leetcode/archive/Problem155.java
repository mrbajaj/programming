/**
 * URL: https://leetcode.com/problems/min-stack/
 * 
 */
import java.util.Stack;

public class Problem155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(10);
        minStack.push(8);
        minStack.push(12);
        System.out.println("Min: " + minStack.getMin());
        minStack.push(4);
        minStack.push(22);
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();


    }

}

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            mins.push(x);
        }else{
            int currMin = mins.peek();
            stack.push(x);
            if(currMin > x){
                mins.push(x);
            }else{
                mins.push(currMin);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        if(stack.isEmpty()){
            return 0;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if(mins.isEmpty()){
            return 0;
        }
        return mins.peek();
    }
}