/**
 * URL: https://leetcode.com/problems/lru-cache/
 * 
 */

import java.util.Map;
import java.util.HashMap;

class Node{
    Node previous;
    Node next;
    Integer key;
    Integer value;
    Node(Integer k,Integer v){
        this.key = k;
        this.value = v;
        previous = null;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

public class Problem146 {
    public static void main(String[] args) {
        Problem146 runner = new Problem146();
        
        runner.test3();
    }

    public void test1(){
        LRUCache obj = new LRUCache(5);
        System.out.println(obj.get(1));
        obj.put(1,100);
        obj.put(2,200);
        obj.put(3,300);
        obj.put(4,400);
        obj.put(5,500);
        obj.printStatus();
        System.out.println(obj.get(2));
        System.out.println(obj.get(5));
        obj.printStatus();
        obj.put(6,600);
        obj.printStatus();
    }
    public void test2(){
        LRUCache obj = new LRUCache(2);
        obj.put(1,100); obj.printStatus();
        obj.put(2,200); obj.printStatus();
        
        obj.get(1); obj.printStatus();
        obj.put(3,300); obj.printStatus();
        
        obj.get(2); obj.printStatus();
        obj.put(4,400); obj.printStatus();
        
        obj.get(1); obj.printStatus();
        obj.get(3); obj.printStatus();
        obj.get(4); obj.printStatus();
    }
    public void test3(){
        LRUCache obj = new LRUCache(2);
        obj.put(2,100); obj.printStatus();
        obj.put(2,200); obj.printStatus();

        obj.get(2); obj.printStatus();

        obj.put(1,100); obj.printStatus();
        obj.put(1,400); obj.printStatus();

        obj.get(2); obj.printStatus();
        
    }
}


class LRUCache {
    private Integer capacity;
    private Map<Integer, Node> cache = new HashMap<>();
    private Node lruHead = null;
    private Node lruTail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        System.out.println("get " + key);
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            this.remove(node);
            this.add(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        System.out.println("put " + key + " : " + value);
        if(!cache.containsKey(key)){
            if(cache.size() == capacity){
                cache.remove(lruHead.key);
                remove(lruHead);
            }
            Node node = new Node(key,value);
            this.add(node);
            cache.put(key, node);
        }else{
            Node node = cache.get(key);
            this.remove(node);
            node.value = value;
            cache.put(key, node);
            this.add(node);
        }
    }

    private void add(Node n){
        if(lruHead == null && lruTail == null){
            lruHead = n;
            lruTail = n;
            return;
        }
        lruTail.next = n;
        n.previous = lruTail;
        lruTail = n;
        lruTail.next = null;
    }
    private void remove(Node n){
        if(lruHead == n && lruTail == n){
            // single node in list which needs to be deleted
            lruHead = null;
            lruTail = null;
        }else if(lruHead == n){
            // first node to be deleted
            lruHead = lruHead.next;
            lruHead.previous = null;
        }else if(lruTail == n){
            // last node to be deleted
            lruTail = lruTail.previous;
            lruTail.next = null;
        }else{
            // intermediate node to be deleted
            n.previous.next = n.next;
            n.next.previous = n.previous;
        }

    }
    public void printStatus(){
        System.out.println("\tcache:: " + cache);
        Node itr = lruHead;
        while(itr != null){
            System.out.print("\t" + itr.key + "->");
            itr = itr.next;
        }
        System.out.println();
        itr = lruHead;
        while(itr != null){
            System.out.print("\t" + itr.value + "->");
            itr = itr.next;
        }
        System.out.println("\n");
    }
}
