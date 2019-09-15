
/**
 * @author Mayur Bajaj
 */
public class DoublyLinkedListDemo{

    public static void main(String[] args) {
        MyDoublyLinkedList dll = new MyDoublyLinkedList();

        dll.insertFront(10);
        dll.insertFront(20);
        dll.insertFront(30);
        dll.print(); System.out.println();

        dll.insertLast(5);
        dll.insertLast(3);
        dll.print(); System.out.println();

        dll.deletValue(30);
        dll.print(); System.out.println();

        dll.deletValue(10);
        dll.print(); System.out.println();

        dll.deletValue(10);
        dll.print(); System.out.println();
    }
}

/**
 * @author Mayur Bajaj
 */
class MyDoublyLinkedList{

    private Node head;

    static class Node{
        Node prev;
        Integer value;
        Node next;

        Node(){
            prev = next = null;
            value = null;
        }
        Node(Integer item){
            prev = next = null;
            value = item;
        }
    }

    /**
     * Insert given item at the front of the list
     */
    public void insertFront(Integer item){
        Node newNode = new Node(item);
        if(this.head == null){
            this.head = newNode;
            return;
        }
        this.head.prev = newNode;
        newNode.next = this.head;
        this.head = newNode;
        
    }

    /**
     * Insert given item at the given position
     * @param item
     * @param pos
     */
    public void insertAtPosition(Integer item, Integer pos){
        // ToDo
    }


    /**
     * Insert given item at the last of the list
     * @param item
     */
    public void insertLast(Integer item){
        Node newNode = new Node(item);
        if(this.head == null){
            this.head = newNode;
            return;
        }

        Node itr = head;
        while(itr.next != null){
            itr = itr.next;
        }
        itr.next = newNode;
        newNode.prev = itr;

    }

    /**
     * Delete the given item from the list
     * @param item
     */
    public void deletValue(Integer item){
        if(head.value == item){
            deleteFront();
            return;
        }

        Node oneb4 = null;
        Node itr = head;
        while(itr != null && itr.value != item){
            oneb4 = itr;
            itr = itr.next;
        }
        if(itr == null){
            System.out.println("Value ("+ item + ") to be deleted not found in the list");
            return;
        }

        oneb4.next = itr.next;
        
        if(oneb4.next !=null){
            oneb4.next.prev = oneb4;
        }
        

    }

    /**
     * 
     */
    public void deleteFront(){
        if(head == null){
            System.out.println("Linked list is empty: can not delete");
            return;
        }
        head = head.next;
        head.prev = null;
    }

    /**
     * print the list in forward manner
     */
    public void print(){
        if(head == null){
            System.out.println("Linked list is empty.!!");
            return;
        }

        Node itr = head;
        while(itr != null){
            System.out.print(itr.value + " ");
            itr = itr.next;
        }

    }
}

