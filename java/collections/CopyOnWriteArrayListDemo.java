import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// import java.util.ArrayList;

class CopyOnWriteArrayListDemo implements Runnable{

    static CopyOnWriteArrayList<String> cList = new CopyOnWriteArrayList<>();

    // static ArrayList<String> cList = new ArrayList<>();  // it will throw ConcurrentModificationException

    @Override
    public void run() {
        try{Thread.sleep(200);}catch(Exception e){}
        cList.add("Chandigarh");
    }
    public static void main(String[] args) {
        CopyOnWriteArrayListDemo obj = new CopyOnWriteArrayListDemo();

        obj.build();

        Thread t = new Thread(obj);
        t.start();

        Iterator<String> i = cList.iterator();
        
        while(i.hasNext()){
            System.out.println(i.next());
            // i.remove(); // not allowed it will throw UnsupportedOperationException
            try{Thread.sleep(300);}catch(Exception e){}
        }

        while(t.isAlive()){

        }

        System.out.println(cList);
    }


    public void build(){
        
        cList.add("Pune");
        cList.add("Bombay");
        cList.add("Kolkata");
        cList.add("Chennai");
        cList.add("Delhi");

        cList.addIfAbsent("Pune");

        cList.addAllAbsent(Arrays.asList("Indore", "Jaipur", "Pune") );

    }


}