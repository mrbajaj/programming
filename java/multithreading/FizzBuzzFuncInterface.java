public class FizzBuzzFuncInterface{

    public static void main(String[] args) {

        Thread t1 = new Thread( () -> {
            for(int i=0; i < 5; i++){
                System.out.println("Fizz");
                try {Thread.sleep(10);} catch(Exception e) {}
            }
        } );
        Thread t2 = new Thread( () -> {
            for(int i=0; i < 5; i++){
                System.out.println(" Buzz");
                try {Thread.sleep(10);} catch(Exception e) {}
            }
        });

        t1.start();
        try {Thread.sleep(5);} catch(Exception e) {}
        t2.start();

        try {t1.join();} catch(Exception e) {}
        try {t2.join();} catch(Exception e) {}
        
        System.out.println("Completed");
    }
    
    
    // Runnable f = () -> {
        //         for(int i=0; i < 5; i++){
        //             System.out.println("Fizz");
        //             try {Thread.sleep(10);} catch(Exception e) {}
        //         }
        //     };
        // Runnable b = () -> {
        //         for(int i=0; i < 5; i++){
        //             System.out.println(" Buzz");
        //             try {Thread.sleep(10);} catch(Exception e) {}
        //         }
        //     };

        // Thread t1 = new Thread(f);
        // Thread t2 = new Thread(b);
}