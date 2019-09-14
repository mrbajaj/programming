/**
 * 
 * @author Mayur Bajaj
 */
public class QueueDemo{

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.enqueue(4); queue.print();
        queue.enqueue(7); queue.print();

        queue.enqueue(9); queue.print();

        queue.dequeue(); queue.print();
        
        // System.out.println("Peek: " + queue.peek());

        // queue.enqueue(10); queue.print();

        // System.out.println("Index of 9: " + queue.search(9));

        
    }
}

/**
 * 
 * @author Mayur Bajaj
 */
class MyQueue{
    private static final int MAX = 100;
    private int size;
    private int front, rear;
    private int[] a = new int[MAX];
    
    MyQueue(){
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Enqueue the given item at the back/rear of the queue
     * @param item
     */
    public void enqueue(int item){
        if( isFull() == true){
            // overflow
            System.out.println("Overflow");
        }
        rear = (rear+1)%MAX;
        a[rear] = item;
        size++;
    }


    /**
     * Dequeue the element from the front of the queue
     */
    public int dequeue(){
        if( isEmpty() == true){
            // overflow
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        int item = a[front];
        front = (front+1)%MAX;
        size--;
        return item;

    }


    /**
     * Read the front element from the queue without removing it
     */
    public int peek(){
        // ToDo
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
        // ToDO
        return (this.size == 0);
    }


    /**
     * Check the stack is full or not
     */
    public Boolean isFull(){
        // ToDO
        return (this.size == this.MAX);
    }

    /**
     * Print the queue
     */
    public void print(){
        if(isEmpty() == true){
            System.out.println("Stack is empty");
        }

        int itr = front;

        while (itr != rear) {
            System.out.print(a[itr] + " ");
            itr = (itr+1)%size;
        }
        System.out.println(a[itr]);
    }

    /**
     * Return the size of the stack
     */
    public int size(){
        return size;
    }

}