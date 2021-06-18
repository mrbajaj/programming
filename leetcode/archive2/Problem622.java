/**
 * URL: https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * Tags: Medium, Array, Queue
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

public class Problem622{

    public static void main(String[] args) {
        // MyCircularQueue cQueue = new MyCircularQueue(3);
        // "MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"
        // cQueue.enQueue(10); cQueue.printQueue();
        // cQueue.enQueue(20); cQueue.printQueue();
        // cQueue.enQueue(30); cQueue.printQueue();
        // cQueue.enQueue(40); cQueue.printQueue();
        // System.out.print(cQueue.Rear());
        // System.out.print(cQueue.isFull());
        // cQueue.deQueue();   cQueue.printQueue();
        // cQueue.enQueue(40); cQueue.printQueue();
        // System.out.print(cQueue.Rear());
        
        MyCircularQueue cQueue = new MyCircularQueue(5);
        cQueue.enQueue(10); cQueue.printQueue();
        cQueue.enQueue(20); cQueue.printQueue();
        cQueue.enQueue(30); cQueue.printQueue();
        cQueue.enQueue(40); cQueue.printQueue();
        cQueue.enQueue(50); cQueue.printQueue();
        cQueue.enQueue(60); cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.enQueue(60); cQueue.printQueue();
        cQueue.enQueue(70); cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.enQueue(70); cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.enQueue(80); cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.enQueue(90); cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.enQueue(100); cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.deQueue();   cQueue.printQueue();
        cQueue.enQueue(110); cQueue.printQueue();
        cQueue.enQueue(120); cQueue.printQueue();
        // cQueue.enQueue(50); cQueue.printQueue();
        // cQueue.enQueue(60); cQueue.printQueue();
        // cQueue.printQueue(); cQueue.printQueue();
    }
}

class MyCircularQueue {
    private int maxSize;
    private int currSize;
    private int[] store;
    private int front, rear;
    public MyCircularQueue(int k) {
        maxSize = k;
        currSize = 0;
        store = new int[k];
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(this.isFull() == true){
            System.out.println("Queue is full!! Can not enQueue: " + value);
            return false;
        }
        //add element at rear
        this.rear = (this.rear+1)%maxSize;
        store[this.rear] = value;
        currSize++;
        if(front==-1){
            front++;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty() == true){
            System.out.println("Queue is empty!! Can not deQueuu: ");
            return false;
        }
        //remove element from front
        store[front] = 0;
        this.front = (this.front+1)%maxSize;
        currSize--;
        return true;
    }
    
    public int Front() {
        if(this.isEmpty() == true){
            return -1;
        }
        return store[this.front];
    }
    
    public int Rear() {
        if(this.isEmpty() == true){
            return -1;
        }
        return store[this.rear];
    }
    
    public boolean isEmpty() {
        if(currSize == 0){
            // this.front=-1;
            // this.rear=-1;
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if( currSize == maxSize ){
            return true;
        }
        return false;
    }

    public boolean printQueue() {
        System.out.print("Front: " + front + "\tRear: " + rear + "\t\tSize: " + currSize);
        System.out.println("\t\tQueue: " + Arrays.toString(store) + "\n");
        return false;
    }
}