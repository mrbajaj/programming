import java.lang.*;
import java.util.*;
import java.io.*;

public class LinkedList{
    Node head;
    static class Node{
        int data;
        Node next;
    
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    public void printList(){
        Node iterator = head;
        while(iterator != null){
            System.out.format("%d -> ",iterator.data);
            iterator = iterator.next;
        }
        System.out.println("/");
    }

    public void insertAtBeginning(int value){
        Node newNode = new Node(value);
        
        if(head == null){
            this.head= newNode;
        }else{
            newNode.next = this.head;
            this.head= newNode;
        }
        
    }

    public void insertIntermediate(int value, int pos){
        if(pos == 0){
            this.insertAtBeginning(value);
        }else{
            Node newNode = new Node(value);
            Node iterator = this.head;

            if(this.head == null){
                this.head = newNode;
            }

            while(iterator.next != null && pos-1 > 1){
                iterator = iterator.next;
                pos = pos - 1;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;

        }
        
    }

    public void insertAtEnd(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node iterator = this.head;
        while(iterator.next != null){
            iterator = iterator.next;
        }
        iterator.next = newNode;
        }
        
    }

    public static void main(String[] args){
        LinkedList myList = new LinkedList();
        
        // myList.head = new Node(5);
        // myList.head.next   = new Node(10);
        // myList.head.next.next   = new Node(14);;
        // myList.head.next.next.next   = new Node(15);;
        // myList.head.next.next.next.next   = new Node(18);;
       
        // myList.head = myList.insertIntermediate(myList.head, 10, 0); myList.printList();
        // myList.head = myList.insertAtBeginning(myList.head, 9); myList.printList();   
        // myList.head = myList.insertAtBeginning(myList.head, 7); myList.printList();   
        // myList.head = myList.insertAtBeginning(myList.head, 5); myList.printList();   

        // myList.head = myList.insertAtEnd(myList.head, 11); myList.printList();   
        // myList.head = myList.insertAtEnd(myList.head, 12); myList.printList();   
        // myList.head = myList.insertAtEnd(myList.head, 14); myList.printList();   

        // myList.head = myList.insertIntermediate(myList.head, 2, 0); myList.printList();
        // myList.head = myList.insertIntermediate(myList.head, 3, 1); myList.printList();
        // myList.head = myList.insertIntermediate(myList.head, 6, 4); myList.printList();   
        // myList.head = myList.insertIntermediate(myList.head, 11, 8); myList.printList();   
        // myList.head = myList.insertIntermediate(myList.head, 15, 3); myList.printList();   

        myList.insertIntermediate(10, 0); myList.printList();
        
        myList.insertAtBeginning(9); myList.printList();   
        myList.insertAtBeginning(7); myList.printList();   
        myList.insertAtBeginning(5); myList.printList();   

        myList.insertAtEnd(11); myList.printList();   
        myList.insertAtEnd(13); myList.printList();   
        myList.insertAtEnd(14); myList.printList();   
        
        myList.insertIntermediate(18,10); myList.printList();

        myList.insertIntermediate(2, 0); myList.printList();
        myList.insertIntermediate(3, 1); myList.printList();
        myList.insertIntermediate(6, 4); myList.printList();   
        myList.insertIntermediate(12, 9); myList.printList();   
        myList.insertIntermediate(4, 3); myList.printList();
    }


}

