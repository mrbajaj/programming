
import java.util.*;
 
public class LinkedListDemo
{
    public static void main(String args[])
    {
        // Creating object of class linked list
        LinkedList<String> myList = new LinkedList<String>();
 
        // Adding elements to the linked list
        myList.add("P");
        Collections.addAll(myList,"B","C","F","G");
        myList.addLast("C");
        myList.addFirst("D");
        myList.add(4, "E");
        System.out.println("Linked list : " + myList);
 
        // Removing elements from the linked list
        myList.remove("B");
        myList.remove(3);
        myList.removeFirst();
        myList.removeLast();
        System.out.println("Linked list after deletion: " + myList);
 
        // Finding elements in the linked list
        if(myList.contains("E"))
            System.out.println("List contains the element 'E' ");
        else
            System.out.println("List doesn't contain the element 'E'");
 
        // Number of elements in the linked list
        int size = myList.size();
        System.out.println("Size of linked list = " + size);
 
        // Get and set elements from linked list
        System.out.println("Element returned by get(2) : " + myList.get(2));
        myList.set(2, "Y");
        System.out.println("Linked list after change : " + myList);

        myList.offer("A");
        System.out.println("After offer('A'): " + myList);

        myList.offerFirst("AA");
        System.out.println("After offerFirst('AA'): " + myList);

        myList.offerLast("Z");
        System.out.println("After offerLast('Z'): " + myList);

        System.out.println("Peeked: " + myList.peek());
        System.out.println("After peek(): " + myList);

        System.out.println("Peeked: " + myList.peekFirst());
        System.out.println("After peekFirst(): " + myList);

        System.out.println("Peeked: " + myList.peekLast());
        System.out.println("After peekLast(): " + myList);


        System.out.println("Polled: " + myList.poll());
        System.out.println("After poll(): " + myList);

        System.out.println("Polled: " + myList.pollFirst());
        System.out.println("After pollFirst(): " + myList);

        System.out.println("Polled: " + myList.pollLast());
        System.out.println("After pollLast(): " + myList);
    }
}