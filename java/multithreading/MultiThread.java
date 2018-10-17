class MultiThread implements Runnable{    
    private Integer tNum;
    public MultiThread(Integer n){
        this.tNum = n;
    }
    @Override
    public void run() {
        System.out.println("Run: "+ this.tNum + " " + Thread.currentThread().getName());
        for(int i=1; i<=5; i++){
            System.out.print(i*(this.tNum +1) + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        for(Integer i=0; i < 5; i++){
            MultiThread m = new MultiThread(i);
            Thread t = new Thread(m);
            try{
                t.start();
                // System.out.println("Wating for " + t.getName() + " to complete");
                t.join();
            }catch(Exception e){
                // 
            }
            
        }
        
    }
}

// class MultiThread implements Runnable{    
//     @Override
//     public void run() {
//         for(int i=0; i<6; i++){
//             System.out.print(i + "\t");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {

//         for(int i=0; i < 5; i++){
//             MultiThread m = new MultiThread();
//             Thread t = new Thread(m);
//             t.start();
//         }
//     }
// }