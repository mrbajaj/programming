
/**
 * 
 * @author Mayur Bajaj
 */
public class LinkedListDemo{

    public static void main(String[] args) {
        MySinglyLinkedList myList = new MySinglyLinkedList();

        myList.insertAtFront(new Node(5)); myList.print();
        myList.insertAtFront(new Node(3)); myList.print();
        myList.insertAtEnd(new Node(9)); myList.print();
        myList.insertAtPosition(new Node(1), 1); myList.print();
        
        myList.deleteAtPosition(2); myList.print();
        
        myList.insertAtPosition(new Node(9), 2); myList.print();

        myList.deleteNodeWithValue(9); myList.print();
    
    }

}

/**
 * 
 * @author Mayur Bajaj
 */
class Node{
    Integer val;
    Node next;

    Node(){
        val = null;
        next = null;
    }

    Node(int val){
        this.val = val;
        next = null;
    }

}


class MySinglyLinkedList{
    private Node head; // making it private so the linked can not be tampered using head

    MySinglyLinkedList(){
        head = null;
    }

    /**
     * Insert the front of the linked list
     * @param n
     */
    public void insertAtFront(Node n){
        n.next = head;
        head = n;
    }
    
    /**
     * Insert at the end of the linked list
     * @param n
     */
    public void insertAtEnd(Node n){
        if(head == null){
            insertAtFront(n);
            return;
        }
        Node prev = head;
        Node itr = head.next;
        while(itr != null){
            prev = itr;
            itr = itr.next;
        }
        prev.next = n;
    }

    /**
     * Insert at give position starting from 1
     * and if given pos is greater than number of items in list then insert new node at end
     * @param n
     * @param pos
     */
    public void insertAtPosition(Node n, int pos){
        if(pos < 1){
            System.out.println("Invalid position to insert");
        }
        if(pos == 1){
            insertAtFront(n);
            return;
        }

        Node itr = head;
        
        while(pos-1 != 1 && itr != null){
            itr = itr.next;
            pos -= 1;
        }
        if(itr == null){
            System.out.println("At end");
            insertAtEnd(n);
            return;
        }
        n.next = itr.next;
        itr.next = n;

    }

    /**
     *  Sort the linked list in ASC order
     */
    public void sort(){
        // ToDo
    }

    /**
     * Prints the linked list list
     */
    public void print(){
        if(head == null){
            System.out.println("Linked List is empty");
        }

        Node itr = head;
        while(itr != null){
            System.out.print(itr.val + "  ");
            itr = itr.next;
        }
        System.out.println();
    }

    /**
     * Delete the node at the given postion (starting from 1), 
     * if position is greater than size of linked list then do not delte anything
     * @param pos
     */
    public void deleteAtPosition(int pos){
        if(pos < 1){
            System.out.println("Invalid position to insert");
            return;
        }
        if(pos == 1){
            deleteAtFront();
            return;
        }
        
        Node itr = head;
        while(pos-1 != 1 && itr != null){
            //System.out.println(itr.val + "   " + pos);
            pos -= 1;
            itr = itr.next;
        }

        if(itr != null){
            itr.next = itr.next.next;
        }
    }

    /**
     * Delete the node from the front of the linked list
     */
    public void deleteAtFront(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    /**
     * Delete at the last node of the linked list
     */
    public void deleteAtEnd(){
        Node prev = head;
        Node itr = head.next;
        while(itr != null){
            prev = itr;
            itr = itr.next;
        }
        prev.next = null;
    }


    /**
     * Delete all the nodes with given value
     * @param val
     */
    public void deleteNodeWithValue(int val){
        if(head == null)
            return;
        
        Node itr = head;
        int count = 1;
        while(itr != null){
            if(itr.val == val){
                deleteAtPosition(count);
                
            }else{
                count += 1;
            }
            itr = itr.next;
            
        }
    }
}