/**
 * URL: https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 * URL: https://www.tutorialspoint.com/javaexamples/data_stack.htm
 * 
 * Tags: Stack
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */

public class StackAndQueue1{

    public static void main(String[] args) {
        boolean isPushed;


        MyStack<Character> stack = new MyStack<Character>(4);
        System.out.println("isFull:" + stack.isFull());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.getSize() + "\n--------------------------");

        isPushed = stack.push('a');
        stack.printSack();
        System.out.print("isPushed:" + isPushed + "\n--------------------------");
        
        isPushed = stack.push('b');
        stack.printSack();
        System.out.print("isPushed:" + isPushed + "\n--------------------------");

        isPushed = stack.push('c');
        stack.printSack();
        System.out.print("isPushed:" + isPushed + "\n--------------------------");
        
        isPushed = stack.push('d');
        stack.printSack();
        System.out.print("isPushed:" + isPushed + "\n--------------------------");
        
        isPushed = stack.push('e');
        stack.printSack();
        System.out.print("isPushed:" + isPushed + "\n--------------------------");
        
        Character poped = stack.pop();
        stack.printSack();
        System.out.print("poped:" + poped + "\n--------------------------");

        System.out.println("\nisFull:" + stack.isFull());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.getSize() + "\n--------------------------");

        isPushed = stack.push('f');
        stack.printSack();
        System.out.println("isPushed:" + isPushed + "\n--------------------------");

        System.out.println("isFull:" + stack.isFull());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.getSize() + "\n--------------------------");
    }

}

class MyStack<T>{
    
    private T data[];
    private int maxSize;
    private int size;
    private int top;
    

    public MyStack(int maxSize){
        this.data = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
        this.top = -1;
        this.size = 0;
    }

    public boolean push(T val){
        //Overflow
        if(this.isFull()){
            return false;
        }
        this.data[++top] = val;
        this.size++;
        return true;
    }

    public T pop(){
        if(this.isEmpty()){
            //Underflow
            return null;
        }
        size--;
        return this.data[top--];
    }

    public T peek(){
        if(this.isEmpty()){
            //Underflow
            return null;
        }
        return this.data[top];
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(size == maxSize){
            return true;
        }
        return false;
    }

    public int getSize(){
        return this.size;
    }

    public void printSack(){
        System.out.println("maxSize:\t" + this.maxSize + " ");
        System.out.println("size:\t" + this.size + " ");
        System.out.println("top:\t" + this.top + " ");
        for(int i = 0; i <= top && i < maxSize; i++){
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
}