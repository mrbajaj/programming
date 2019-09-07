
public class LinkedListDemo{

    public static void main(String[] args) {
        MySinglyLinkedList myList = new MySinglyLinkedList();

        myList.insertAtFront(new Node(5));
        myList.insertAtFront(new Node(3));
        myList.insertAtEnd(new Node(9));

        myList.insertAtPosition(new Node(1), 1);

        myList.print();
    }

}

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
        if(pos == 1){
            insertAtFront(n);
            return;
        }

        Node itr = head;
        
        while(pos-1 != 0 && itr != null){
            System.out.println(itr.val + "   " + pos);
            itr = itr.next;
            pos -= 1;
        }
        if(itr == null){
            System.out.println("At end");
            insertAtEnd(n);
            return;
        }
        System.out.println(itr.val + "   " + pos);
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

}