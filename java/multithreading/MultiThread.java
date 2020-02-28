/**
 * Example: Creating a job to be excuted by different threads one after another
 */
class MyJob implements Runnable{    
    private Integer jobNum;
    public MyJob(Integer n){
        this.jobNum = n;
    }
    @Override
    public void run() {
        System.out.print("Runing Job: "+ this.jobNum + " \t" + Thread.currentThread().getName() +"\t :: \t");
        for(int i=1; i<=5; i++){
            System.out.print(i*(this.jobNum) + "\t");
        }
        System.out.println();
    }
    
}

class MultiThread{   
    public static void main(String[] args) {

        for(Integer jobNum=1; jobNum <= 5; jobNum++){
            MyJob m = new MyJob(jobNum);
            Thread t = new Thread(m);
            t.setName("ThreadForJob" + jobNum);
            try{
                t.start();
                t.join();
                System.out.println("Completed\n");
            }catch(Exception e){
                System.out.println("Exception Occured");
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