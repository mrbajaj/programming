// Java program to demonstrate working of HashSet
import java.util.*;

import javafx.scene.shape.Circle;
 
public class HashSetDemo {
    public static void main(String[] args){
        Set<String> cities = new HashSet<String>();
 
        // adding into HashSet
        cities.add("Mumbai");
        Collections.addAll(cities,"Hyderabad","Bangalore","Chennai");
        cities.add("Hyderabad");// adding duplicate elements
 
        // printing HashSet
        System.out.println("Initial cities: " + cities);
        System.out.println("Hyderabad found:" + cities.contains("Hyderabad"));
 
        // Removing an item
        cities.remove("Bangalore");
        System.out.println("Cities after removing Bangalore: " + cities);
 
        // Iterating over hash set items
        System.out.println("Iterating over list");
        Iterator<String> i = cities.iterator();
        while (i.hasNext())
            System.out.print(i.next() + "\t");
        System.out.println();
    }
}