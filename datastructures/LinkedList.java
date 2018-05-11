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

    public static void main(String[] args){
        LinkedList myList = new LinkedList();

        myList.head = new Node(5);
        myList.head.next   = new Node(10);
        myList.head.next.next   = new Node(14);;
        myList.head.next.next.next   = new Node(15);;
        myList.head.next.next.next.next   = new Node(18);;

        myList.printList();
        
    }


}

