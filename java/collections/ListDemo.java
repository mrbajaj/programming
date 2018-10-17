import java.util.*;
import java.util.List;
 
public class ListDemo
{
    public static void main (String[] args)
    {
        // Let us create a list
        // ArrayList<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0, 1);  // adds 1 at 0 index
        l1.add(1, 2);  // adds 2 at 1 index
        System.out.println(l1);  // [1, 2]
 
        // Let us create another list
        // List l2 = new ArrayList();
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
 
        // will add list l2 from 1 index
        l1.addAll(1, l2);
        System.out.println(l1);
 
        l1.remove(1);     // remove element from index 1
        System.out.println(l1); // [1, 2, 3, 2]
 
        // prints element at index 3
        System.out.println(l1.get(3));
 
        l1.set(0, 5);   // replace 0th element with 5
        System.out.println(l1);  // [5, 2, 3, 2]
        
        System.out.println("first index of 2:\t" + l1.indexOf(2));
        System.out.println("last index of 2:\t" + l1.lastIndexOf(2));
        System.out.println("first index of 1:\t" + l1.indexOf(1));

        // print list in forward order
        ListIterator<Integer> frd = l1.listIterator(); // or :- ListIterator frd = l1.listIterator();
        while(frd.hasNext()){
            System.out.print(frd.next() + "\t");
        }
        System.out.println();

        // print list in reverse order
        ListIterator<Integer> rev = l1.listIterator(l1.size()); // or :- ListIterator rev = l1.listIterator(l1.size()); 
        while(rev.hasPrevious()){
            System.out.print(rev.previous() + "\t");
        }
        System.out.println();


        List<Integer> sub = new ArrayList<>();
        sub = l1.subList(1,3); // sublist from 1st(including) to 3rd(exclusing)
        System.out.println(sub);

    }
}