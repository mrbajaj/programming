
class Fizz implements Runnable{

    @Override
    public void run(){
        for(int i=0; i< 10; i++){
            System.out.println("Fizz");
            try {Thread.sleep(10);} catch(Exception e) {}
        }
    }
}

class Buzz implements Runnable{

    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(" Buzz");
            try {Thread.sleep(10);} catch(Exception e) {}
        }
    }
}

public class FizzBuzz{

    public static void main(String[] args) {
        
        Fizz f = new Fizz();
        Buzz b = new Buzz();

        Thread t1 = new Thread(f);
        Thread t2 = new Thread(b);

        t1.start();
        try {Thread.sleep(5);} catch(Exception e) {}
        t2.start();

        try {t1.join();} catch(Exception e) {}
        try {t2.join();} catch(Exception e) {}
        
        System.out.println("Completed");
    }
}