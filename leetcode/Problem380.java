/**
 * URL: https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Problem380 {

    public static void main(String[] args) {
        
        test1();
        test2();
        test3();
        test4();
    
    }

    private static void test1(){
        RandomizedSet rset = new RandomizedSet();
        System.out.println("Removing 9"); rset.remove(9);
        rset.insert(10);
        // rset.insert(9);
        // rset.insert(14);
        // rset.insert(13);
        // rset.insert(42);
        // rset.insert(12);
        // rset.insert(33);
        System.out.println("Removing 9"); rset.remove(9);
        System.out.println("Removing 13"); rset.remove(13);
        rset.insert(9);
        for(int i = 0; i < 4; i++){
            System.out.println(rset.getRandom());
        }
    }

    private static void test2(){
        RandomizedSet rset = new RandomizedSet();
        rset.insert(1); System.out.println();
        rset.remove(2); System.out.println();
        rset.insert(2); System.out.println();
        System.out.println(rset.getRandom()); 
        rset.remove(1); System.out.println();
        rset.insert(2); System.out.println();
        System.out.println(rset.getRandom()); 
    }

    private static void test3(){
        RandomizedSet rset = new RandomizedSet();
        System.out.print("A: Removing 0\t"); rset.remove(0);
        System.out.print("B: Removing 0\t"); rset.remove(0); System.out.println();
        System.out.print("C: Adding 0\t"); rset.insert(0); System.out.println();
        System.out.print("D: Random\t" + rset.getRandom()); System.out.println();
        System.out.print("E: Removing 0\t"); rset.remove(0); System.out.println();
        System.out.print("F: Adding 0\t"); rset.insert(0); System.out.println();
    }

    private static void test4(){
        RandomizedSet rset = new RandomizedSet();
// ["RandomizedSet","insert","insert","getRandom","getRandom","insert","remove","getRandom","getRandom","insert","remove"]
// [[],[3],[3],[],[],[1],[3],[],[],[0],[0]]
        System.out.print("Adding 3\t"); rset.insert(3); System.out.println();
        System.out.print("Adding 3\t"); rset.insert(3); System.out.println();
        System.out.print("Random\t" + rset.getRandom()); System.out.println();
        System.out.print("Random\t" + rset.getRandom()); System.out.println();
        System.out.print("Adding 1\t"); rset.insert(1); System.out.println();
        System.out.print("Removing 3\t"); rset.remove(3); System.out.println();
        System.out.print("Random\t" + rset.getRandom()); System.out.println();
        System.out.print("Random\t" + rset.getRandom()); System.out.println();
        System.out.print("Adding 0\t"); rset.insert(0); System.out.println();
        System.out.print("Removing 0\t"); rset.remove(0); System.out.println();

    }
    
}

class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. 
     * Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            // element is already inserted
            return false;
        }

        int index = list.size();
        map.put(val, index);
        list.add(val);
        // this.printMe();
        return true;
    }
    
    /** Removes a value from the set. 
     * Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int size = list.size();
        if(!map.containsKey(val)){
            // element is not available
            // System.out.println("element not available");
            return false;
        }
       
        if(list.get(size - 1) == val){
            list.remove(size -1);
            map.remove(val);
            return true;
        }
        
        int index = map.get(val);
        // System.out.println("Index of " + val  + " is " + index);
        int tmpValue = list.get(size - 1);
        // System.out.println("Last value is " + tmpValue + "\t list" + list);
        
        list.remove(size - 1);
        list.set(index, tmpValue);
        map.remove(val);
        map.put(list.get(index), index);

        // this.printMe();
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // if(list.size() == 0){
            // return 0;
        // }
        int size = list.size();
        int randomIndex = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        return list.get(randomIndex);
    }

    private void printMe(){
        System.out.println(map);
        System.out.println(list);


        // int indexOfElementToBeDeleted = map.get(val);
        // int lastElementIndex = list.size() - 1;
        // int lastElementValue = list.get(lastElementIndex);
        // System.out.println("indexOfElementToBeDeleted: " + indexOfElementToBeDeleted);
        // System.out.println("lastElementIndex: " + lastElementIndex);
        // System.out.println("lastElementValue: " + lastElementValue);
        // list.add(indexOfElementToBeDeleted, lastElementValue);
        // map.put(lastElementValue, indexOfElementToBeDeleted);
        // list.remove(lastElementIndex + 1);
        // map.remove(val);
    }


}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */