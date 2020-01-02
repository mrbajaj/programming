
import java.nio.Buffer;
import java.util.LinkedList;

public class ProducerConsumer {
    
    public static void main(String[] args) {
        Machine m = new Machine();

        Thread p = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{ m.produce(); }catch(Exception e) {}
            }
        });

        Thread c = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{ m.consume(); }catch(Exception e) {}
                
            }
        });

        p.start();
        c.start();

        System.out.println("Completed");
    }


}

class Machine {

    int capacity = 3;

    LinkedList<Integer> buffer = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0; 
        while(true){
            synchronized(this){
                if(buffer.size() == capacity){
                    wait();
                }
                System.out.println("Produced " + value); 
                buffer.add(value++); 
                notify();
                Thread.sleep(100);
            }
        }
    }

    public void consume() throws InterruptedException {

        while(true){
            synchronized(this){
                if(buffer.size() == 0){
                    wait();
                }
                int val = buffer.removeFirst(); 
                System.out.println("\tConsumer " + val); 
                notify();
                Thread.sleep(100);
            }
            
        }
    }
}