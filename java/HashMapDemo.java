import java.util.*;    
class Book {    
int id;    
String name,author;    
int quantity;    
public Book(int id, String name, String author, int quantity) {    
    this.id = id;    
    this.name = name;    
    this.author = author;
    this.quantity = quantity;    
}    
}    
public class HashMapDemo {    
public static void main(String[] args) {    
    Map<Integer,Book> map=new HashMap<Integer,Book>();
    Book b1=new Book(101,"Head first java","Siera & Bates",8);    
    Book b2=new Book(102,"Coding Interview Questions","Gayle Laakmann",4);    
    Book b3=new Book(103,"Core Java","Horstmann",6);
    //Adding Books to map   
    map.put(1,b1);  
    map.put(2,b2);  
    map.put(3,b3);  
      
    //Traversing map  
    System.out.println("Details:");
    for(Map.Entry<Integer, Book> entry:map.entrySet()){    
        int key=entry.getKey();  
        Book b=entry.getValue();  
        System.out.println("Key:" + key +"\t Book Details: "+b.id+" "+b.name+" "+b.author+" "+" "+b.quantity);   
    }

    Map<String,Integer> dir=new HashMap<String,Integer>(); //phone directory
    dir.put("John", 22228595);
    dir.put("Alice", 34258564);
    dir.put("Bob", 98458553);
    dir.put("Peter", 56458453);
    System.out.println(dir.toString());
    dir.replace("John", 22228595, 32228595);
    System.out.println(dir.toString());
    System.out.println("Bob present: " + dir.containsKey("Bob"));

    Collection<Integer> numbers = dir.values();
    System.out.println("Phone numbers: " + numbers);
    Set<String> names = dir.keySet();
    System.out.println("Names: " + names);
    dir.remove("Alice");
    System.out.println("Size of removal: " + dir.size());


}    
}    