/**
 * 
 * @author Mayur Bajaj
 */
public class QueueDemo{

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.dequeue();

        queue.enqueue(4); queue.print();
        queue.enqueue(7); queue.print();
        queue.enqueue(9); queue.print();
        queue.enqueue(12); queue.print();
        queue.enqueue(15); queue.print();

        queue.dequeue(); queue.print();
        
        queue.enqueue(18); queue.print();

        queue.dequeue(); queue.print();

        queue.enqueue(21); queue.print();
        
        queue.enqueue(23); queue.print();

        // System.out.println("Peek: " + queue.peek());
        // System.out.println("Index of 9: " + queue.search(9));

    }
}

/**
 * 
 * @author Mayur Bajaj
 */
class MyQueue{
    private static final int MAX = 5;
    private int front, rear, size;
    private int[] a = new int[MAX];
    
    MyQueue(){
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Enqueue the given item at the back/rear of the queue
     * @param item
     */
    public void enqueue(int item){
        if( isFull() == true){
            System.out.println("Overflow: unable to insert " + item);
            return;
        }
        this.rear = (this.rear+1)%MAX;
        this.a[this.rear] = item;
        this.size++;
    }


    /**
     * Dequeue the element from the front of the queue
     */
    public int dequeue(){
        if( isEmpty() == true){
            System.out.println("Underflow: Stack is empty, nothing to dequeue");
            return Integer.MIN_VALUE;
        }
        int item = a[this.front];
        this.front = (this.front+1)%MAX;
        this.size--;
        return item;

    }


    /**
     * Read the front element from the queue without removing it
     */
    public int peek(){
        if(isEmpty() == true){
            return Integer.MIN_VALUE;
        }
        return a[front];
    }

    /**
     * Check tit queue is empty or not
     * @return
     */
    public Boolean isEmpty(){
       return (this.size == 0);
    }


    /**
     * Check the stack is full or not
     */
    public Boolean isFull(){
        return (this.size == MAX);
    }

    /**
     * Print the queue
     */
    public void print(){
        if(this.isEmpty() == true){
            System.out.println("Stack is empty");
            return;
        }
        
        int itr = this.front;

        while (itr != this.rear) {
            System.out.print(a[itr] + " ");
            itr = (itr+1) % MAX;
        }
        System.out.println(this.a[itr]);
    
    }

    /**
     * Return the size of the stack
     */
    public int size(){
        return size;
    }

}