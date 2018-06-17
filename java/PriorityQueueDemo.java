import java.util.*;
 
public class PriorityQueueDemo
{
  public static void main(String[] args)
  {
    Queue<Integer> q = new PriorityQueue<>();
    
    Collections.addAll(q, 1,2,3,7,5);
    q.offer(10);
    System.out.println("Initial queue:" + q );
    System.out.println("Removed element:" + q.remove());
    System.out.println("After Removal:" + q);
    System.out.println("Head of queue:" + q.peek());
    System.out.println("Size of queue:" + q.size() +"\n\n");

    Comparator cmp = new Comparator() {
        public int compare(Object o1, Object o2){
            String s1 = o1.toString(); // or (String)o1;
            String s2 = o2.toString(); // or (String)o2;
            return s1.compareTo(s2);
        }
    };
    
    Queue<String> q2 = new PriorityQueue<>(cmp);
    q2.offer("BB"); q2.offer("DD"); q2.offer("CC"); q2.add("AA");
    System.out.println("Initial queue:" + q2 );
    System.out.println("Removed element:" + q2.remove());
    System.out.println("After Removal:" + q2);
    System.out.println("Head of queue:" + q2.element());
    System.out.println("Size of queue:" + q2.size());


  }
}
