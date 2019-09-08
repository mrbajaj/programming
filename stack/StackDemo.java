/**
 * 
 * @author Mayur Bajaj
 */
public class StackDemo{
    
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1); stack.print();

        stack.push(2); stack.print();

        stack.push(3); stack.print();
        
        stack.push(7); stack.print();

        stack.pop(); stack.print();

        stack.push(8); stack.print();

        System.out.println("Peek Stack Element:\t" + stack.peek());

    }
}

/**
 * 
 * @author Mayur Bajaj
 */
class MyStack{
    static final int MAX = 100;
    private int TOP;
    private int a[] = new int[MAX];

    MyStack(){
        TOP = -1;
    }

    public void print(){
        int itr = TOP;

        while(itr != -1){
            System.out.print(a[itr] + " ");
            itr--;
        }
        System.out.println();

    }

    /**
     * Pop top item from the stack
     * @return
     */
    public int pop(){
        if(TOP == -1){
            // underflow
            System.out.println("Underflow");
            return -1;
        }

        return a[TOP--];
    }

    /**
     * Push item into the stack
     * @param item
     */
    public void push(int item){
        if(TOP == MAX-1){
            //overflow
            System.out.println("Overflow");
            return;
        }

        TOP++;
        a[TOP] = item;

    }

    /**
     * Return the top element of stack without removing it from stack
     * @return
     */
    public int peek(){
        if(TOP == -1){
            // underflow
            System.out.println("Underflow");
            return -1;
        }

        return a[TOP];
    }


    /**
     * Check the stack is empty or not
     * @return
     */
    public Boolean isEmpty(){
        if(TOP == -1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Returns first occurance index of the given item
     * @return
     */
    public int search(int item){
        int itr = TOP;
        while(itr != -1){
            if(a[itr] == item){
                return itr;
            }
            itr--;
        }

        return -1;
    }
}