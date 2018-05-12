import java.lang.*;
import java.util.*;

import java.io.*;
/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

class MergeSortedLinkedLists{
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
    
    public Node mergeLists(Node headA, Node headB) {
        if(headA == null){
            return headB;
        }
        if(headB == null){
            return headA;
        }
        MergeSortedLinkedLists myListC = new MergeSortedLinkedLists();
        myListC.head = headA;
        Node iterator = headB;
        while(iterator != null){
            myListC.insertSorted(iterator.data);
            iterator = iterator.next;
        }
        return myListC.head;
    }

    public static void main(String[] args){
        MergeSortedLinkedLists myListA = new MergeSortedLinkedLists();
        MergeSortedLinkedLists myListB = new MergeSortedLinkedLists();
        MergeSortedLinkedLists obj = new MergeSortedLinkedLists();
        myListA.insertSorted(10);
        myListA.insertSorted(9);
        myListB.insertSorted(7);
        myListA.insertSorted(5);
        myListB.insertSorted(11);
        myListA.insertSorted(13);
        myListA.insertSorted(14);
        myListB.insertSorted(18);
        myListA.insertSorted(2);
        myListA.insertSorted(3);
        myListB.insertSorted(6);
        myListA.insertSorted(12);
        myListB.insertSorted(4);
        
        myListA.printList();
        myListB.printList();
        MergeSortedLinkedLists myListC = new MergeSortedLinkedLists();
        myListC.head= obj.mergeLists(myListA.head,myListB.head);
        myListC.printList();
    }

}