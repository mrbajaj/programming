import java.lang.*;
import java.util.*;
import java.io.*;

public class LinkedListBasics{
    public static void main(String[] args){
        LinkedList myList = new LinkedList();  

        // myList.insertIntermediate(10, 0); myList.printList();
        // myList.insertAtBeginning(9); myList.printList();   
        // myList.insertAtBeginning(7); myList.printList();   
        // myList.insertAtBeginning(5); myList.printList();   
        // myList.insertAtEnd(11); myList.printList();   
        // myList.insertAtEnd(13); myList.printList();   
        // myList.insertAtEnd(14); myList.printList();   
        // myList.insertIntermediate(18,10); myList.printList();
        // myList.insertIntermediate(2, 0); myList.printList();
        // myList.insertIntermediate(3, 1); myList.printList();
        // myList.insertIntermediate(6, 4); myList.printList();   
        // myList.insertIntermediate(12, 9); myList.printList();   
        // myList.insertIntermediate(4, 3); myList.printList();

        myList.insertSorted(10); myList.printList();
        myList.insertSorted(9); myList.printList();   
        myList.insertSorted(7); myList.printList();   
        myList.insertSorted(5); myList.printList(); 
        myList.insertSorted(11); myList.printList();   
        myList.insertSorted(13); myList.printList();   
        myList.insertSorted(14); myList.printList();
        myList.insertSorted(18); myList.printList();
        myList.insertSorted(2); myList.printList();
        myList.insertSorted(3); myList.printList();
        myList.insertSorted(6); myList.printList();   
        myList.insertSorted(12); myList.printList();   
        myList.insertSorted(4); myList.printList();
    
    }

}
class LinkedList{
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

    public void insertSorted(int value){
        
        Node iterator = this.head;
        int pos = 0;
        while(iterator != null && iterator.data < value){
            iterator = iterator.next;
            pos += 1;
        }
        if(head == null || pos == 0){
            this.insertAtBeginning(value);
        }else if(iterator == null){
            this.insertAtEnd(value);
        }else{
            this.insertIntermediate(value, pos+1);
        }
    }
}

