import java.util.concurrent.ConcurrentMap;
import java.security.KeyStore.Entry;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
// import java.util.Map;
// import java.util.HashMap;

class ConcurrentHashMapDemo implements Runnable{

    static ConcurrentMap<Integer,String> cmap = new ConcurrentHashMap();
    // static Map<Integer,String> cmap = new HashMap(); // it will throw ConcurrentModificationException

    @Override
    public void run() {
        
        try{Thread.sleep(200);}catch(Exception e){}

        cmap.put(7, "Chandigarh");
    }

    public static void main(String[] args) {
        
        ConcurrentHashMapDemo myMap = new ConcurrentHashMapDemo();
        
        myMap.build();
        
        Thread t = new Thread(myMap);
        t.start();

        Set<Integer> set = cmap.keySet();
        Iterator<Integer> i = set.iterator();
        while(i.hasNext()){
            Integer key = i.next();
            System.out.println(cmap.get(key));
            try{Thread.sleep(300);}catch(Exception e){}
        }
        
    }

    public void build(){
        
        cmap.put(1, "Pune");
        cmap.put(3, "Bombay");
        cmap.put(4, "Kolkata");
        cmap.put(5, "Chennai");
        cmap.put(6, "Delhi");

        cmap.replace(3, "Mumbai"); //System.out.println(cmap);
        cmap.putIfAbsent(2, "Bangalore"); //System.out.println(cmap);

        cmap.remove(1, "Pune"); //System.out.println(cmap);
        cmap.putIfAbsent(1, "Hyderabad"); //System.out.println(cmap);
    }
}