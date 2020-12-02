/**
 * First Unique Number
 * 
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * Implement the FirstUnique class:
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 *
 * Example 1:
 * Explanation: 
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * 
 * 
 * Example 2:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * 
 * 
 * 
 * Example 3:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class ProblemDay28April2020Leetcode{

    public static void main(String[] args) {
        
        test1();


    }

    private static void test1(){
        FirstUnique firstUnique = new FirstUniqueBruteforce(new int[]{2,3,5});
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        firstUnique.showFirstUnique(); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        firstUnique.showFirstUnique(); // return -1
    }

    private static void test2(){
        FirstUnique firstUnique = new FirstUniqueBruteforce(new int[]{7,7,7,7,7,7});
        firstUnique.showFirstUnique(); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]

    }

    private static void test3(){
        FirstUnique firstUnique = new FirstUniqueBruteforce(new int[]{809});
        firstUnique.showFirstUnique(); // return 809
        firstUnique.add(809);          // the queue is now [809,809]
        firstUnique.showFirstUnique(); // return -1
    }

}

interface FirstUnique{

    public int showFirstUnique();
    public void add(int num);

}


class FirstUniqueImproved implements FirstUnique{
    // Improved
    private Map<Integer, Integer> countMap = new HashMap<>();
    private Queue<Integer> queue = new LinkedList<>();

    public FirstUniqueImproved(int[] nums) {
        for(int num: nums){
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        while(!queue.isEmpty() && countMap.get(queue.peek()) > 1 ){
            queue.remove();
        }
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }
    
    public void add(int num) {
        int count = countMap.getOrDefault(num, 0);
        countMap.put(num, count+1);

        if(count == 0){
            queue.add(num);
        }
    }
}


class FirstUniqueBruteforce implements FirstUnique{
    // BruteForce
    List<Integer> list = new ArrayList<>();
    List<Integer> firstUnique = new ArrayList<>();

    public FirstUniqueBruteforce(int[] nums) {
        for(int num: nums){
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        if(firstUnique.size() == 0){
            return -1;
        }
        System.out.println(list + "\t : \t" + firstUnique.get(0));
        return firstUnique.get(0);
    }
    
    public void add(int num) {
        if(!list.contains(num)){
            firstUnique.add(num);
        }else{
            int index = firstUnique.indexOf(num);
            if(index != -1) firstUnique.remove(index);
        }
        list.add(num);
    }
}